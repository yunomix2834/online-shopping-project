package com.core.repository.otp;

import com.core.entity.otp.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository
        extends JpaRepository<PasswordResetToken, String> {
    Optional<PasswordResetToken> findByEmail(String email);
}
