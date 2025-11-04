package com.business.mapper;

import com.business.dto.request.HelloRequest;
import com.business.dto.response.HelloResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface HelloMapper {

    Hello toHelloFromHelloRequest(HelloRequest helloRequest);

    HelloResponse toHelloResponseFromHello(Hello hello);
}
