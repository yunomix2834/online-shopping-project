package com.core.repository.otp;

import com.core.entity.otp.OtpVerification;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpVerificationRepository
    extends JpaRepository<OtpVerification, String> {

  Optional<OtpVerification> findByEmail(String email);
}
