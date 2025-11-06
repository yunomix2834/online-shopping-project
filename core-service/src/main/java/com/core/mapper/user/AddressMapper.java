package com.core.mapper.user;

import com.core.dto.request.user.AddressCreateRequestDto;
import com.core.dto.request.user.AddressUpdateRequestDto;
import com.core.dto.response.user.AddressResponseDto;
import com.core.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    Address toAddressFromAddressCreateRequestDto(
            AddressCreateRequestDto addressCreateRequestDto);

    void patchAddressFromAddressUpdateRequestDto(
            @MappingTarget Address address,
            AddressUpdateRequestDto addressUpdateRequestDto
    );

    AddressResponseDto toAddressResponseDtoFromAddress(
            Address address);
}