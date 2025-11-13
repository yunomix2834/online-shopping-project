package com.core.configuration.init;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static org.common.constant.RoleConstant.ADMIN_ROLE;
import static org.common.constant.RoleConstant.USER_ROLE;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitialization {

  ApplicationInitializationService applicationInitializationService;
  Environment env;

  @Bean
//  @ConditionalOnProperty(
//      prefix = "spring.datasource",
//      value = "driver-class-name",
//      havingValue = "com.mysql.cj.jdbc.Driver")
  ApplicationRunner applicationRunner() {
    log.info("Khởi chạy ứng dụng!");
    return args -> {

      applicationInitializationService.checkRoleAndCreate(ADMIN_ROLE);
      applicationInitializationService.checkRoleAndCreate(USER_ROLE);


      // Đọc từ env/properties
      applicationInitializationService.createUserIfProvided(
          env.getProperty("app.init.admin.username"),
          ADMIN_ROLE,
          env.getProperty("app.init.admin.password"),
          env.getProperty("app.init.admin.email")
      );
      applicationInitializationService.createUserIfProvided(
          env.getProperty("app.init.user.username"),
          USER_ROLE,
          env.getProperty("app.init.user.password"),
          env.getProperty("app.init.user.email")
      );

      log.info("khởi chạy ứng dụng thành công .....");
    };
  }
}
