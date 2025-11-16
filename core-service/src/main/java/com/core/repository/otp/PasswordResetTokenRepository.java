package com.core.repository.otp;

import com.core.entity.otp.PasswordResetToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository
    extends JpaRepository<PasswordResetToken, String> {

  Optional<PasswordResetToken> findByEmail(String email);
}
