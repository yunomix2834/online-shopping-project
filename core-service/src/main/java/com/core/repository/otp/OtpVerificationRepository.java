package com.core.repository.otp;

import com.core.entity.otp.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpVerificationRepository
        extends JpaRepository<OtpVerification, String> {
    Optional<OtpVerification> findByEmail(String email);
}