package com.core.service;

import com.core.dto.request.user.AddressCreateRequestDto;
import com.core.dto.request.user.AddressUpdateRequestDto;
import com.core.dto.response.user.AddressResponseDto;
import org.common.http.Envelope;

public interface IAddressService {
    void create(AddressCreateRequestDto req);

    void update(
            String addressId,
            AddressUpdateRequestDto req);

    void softDelete(String addressId);

    void setDefaultShipping(String addressId);

    void setDefaultBilling(String addressId);

    Envelope.Page<AddressResponseDto> listByUser(
            String userId,
            int page, int size);
}