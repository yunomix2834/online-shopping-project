package com.core.service.impl;


import com.core.dto.request.user.AddressCreateRequestDto;
import com.core.dto.request.user.AddressUpdateRequestDto;
import com.core.dto.response.user.AddressResponseDto;
import com.core.entity.Address;
import com.core.entity.User;
import com.core.helper.AuthenticationHelper;
import com.core.helper.UserHelper;
import com.core.mapper.user.AddressMapper;
import com.core.repository.user.AddressRepository;
import com.core.service.IAddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AddressServiceImpl implements IAddressService {
    AddressRepository addressRepository;
    AddressMapper addressMapper;
    UserHelper userhelper;

    @Override 
    @Transactional
    public void create(
            AddressCreateRequestDto request) {
        String me = AuthenticationHelper.getMyUserId();
        User u = userhelper.getUserById(me);
        Address a = addressMapper.toAddressFromAddressCreateRequestDto(request);
        a.setUser(u);
        addressRepository.save(a);
    }

    @Override @Transactional
    public void update(
            String addressId,
            AddressUpdateRequestDto request) {
        Address a = addressRepository.findById(addressId)
                .orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_FOUND));
        mustOwn(a);
        addressMapper.patchAddressFromAddressUpdateRequestDto(a, request);
        addressRepository.save(a);
    }

    @Override
    @Transactional
    public void softDelete(String addressId) {
        Address a = addressRepository.findById(addressId)
                .orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_FOUND));
        mustOwn(a);
        a.markDeleted(AuthenticationHelper.getMyUserId());
        addressRepository.save(a);
    }

    @Override
    @Transactional
    public void setDefaultShipping(String addressId) {
        Address a = addressRepository.findById(addressId)
                .orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_FOUND));
        mustOwn(a);
        addressRepository.resetDefaultShipping(a.getUser().getId());
        a.setIsDefaultShipping(true);
        addressRepository.save(a);
    }

    @Override
    @Transactional
    public void setDefaultBilling(String addressId) {
        Address a = addressRepository.findById(addressId)
                .orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_FOUND));
        mustOwn(a);
        addressRepository.resetDefaultBilling(a.getUser().getId());
        a.setIsDefaultBilling(true);
        addressRepository.save(a);
    }

    @Override
    @Transactional(readOnly = true)
    public Envelope.Page<AddressResponseDto> listByUser(
            String userId,
            int page, int size) {
        String me = AuthenticationHelper.getMyUserId();
        if (!me.equals(userId)) AuthenticationHelper.requireAdmin();

        List<AddressResponseDto> docs = addressRepository.findByUserId(userId)
                .stream()
                .map(addressMapper::toAddressResponseDtoFromAddress)
                .toList();
        int total = docs.size();
        int from = Math.min(page*size, total);
        int to = Math.min(from+size, total);
        List<AddressResponseDto> slice = docs.subList(from, to);
        int totalPages = (int) Math.max(1, Math.ceil(total/(double)size));

        return Envelope.Page.<AddressResponseDto>builder()
                .page(page)
                .size(size)
                .total(total)
                .totalPages(totalPages)
                .docs(slice)
                .build();
    }

    private void mustOwn(Address a){
        String me = AuthenticationHelper.getMyUserId();
        if (a.getUser()==null || !a.getUser().getId().equals(me)) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
    }
}