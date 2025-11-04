package com.business.controller;

import com.business.dto.ErrorResponse;
import com.business.service.IHelloService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yunomi Xavia
 */

@Builder
@RestController
@RequestMapping(
        path = "/api",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(
        name = "CRUD REST APIs for Hello",
        description = "CRUD REST APIs to CREATE, GET, UPDATE, PATCH"
)
@Validated
public class HelloController {

    IHelloService helloService;
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Operation(
            summary = "Get Java version",
            description = "Get Java versions details that is installed into accounts microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    }
    )
    @RateLimiter(name = "fetchJavaVersion", fallbackMethod = "fetchJavaVersionFallback")
    @GetMapping("/java-version")
    com.business.dto.ApiResponse<String> fetchJavaVersion(
            @RequestHeader("yunomix2834-correlation-id") String correlationId) {

        logger.debug("Fetching Java version with correlation-id {}",
                correlationId);

        return com.business.dto.ApiResponse.<String>builder()
                .result(helloService.fetchJavaVersion())
                .build();
    }

    com.business.dto.ApiResponse<String> fetchJavaVersionFallback(
            Throwable throwable) {
        return com.business.dto.ApiResponse.<String>builder()
                .result("Java 21")
                .build();
    }
}
