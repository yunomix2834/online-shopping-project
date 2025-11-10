package com.core.configuration.init;


import com.core.entity.Role;
import com.core.entity.User;
import com.core.repository.UserRepository;
import java.util.Set;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitializationService {

  com.core.repository.user.RoleRepository roleRepository;
  UserRepository userRepository;
  PasswordEncoder passwordEncoder;

  @Transactional
  void createUserIfProvided(
      String username,
      String roleName,
      String rawPassword,
      String email) {

    if (!StringUtils.hasText(username)) {
      return;
    }

    if (userRepository.findByUsername(username).isPresent()) {
      return;
    }

    Role role = checkRoleAndCreate(roleName);

    User user = userRepository.save(User.builder()
        .username(username)
        .passwordHash(passwordEncoder.encode(rawPassword))
        .email(email)
        .isActive(true)
        .isVerified(true)
        .roles(Set.of(role))
        .build());
  }

  Role checkRoleAndCreate(String roleName) {
    return roleRepository.findById(roleName).orElseGet(() ->
        roleRepository.save(
            Role.builder()
                .name(roleName)
                .build())
    );
  }
}
