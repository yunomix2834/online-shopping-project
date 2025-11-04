package com.core.repository.client;

import com.core.dto.ApiResponse;
import org.springframework.stereotype.Component;

@Component
public class Demo2Fallback implements Demo2Client {
    @Override
    public ApiResponse<String> fetchJavaVersion(
            String correlationId) {
        return null;
    }
}
