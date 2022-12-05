package com.coherentsolutions.consoleApp.main.httpSecurity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SecurityConfig.class})
@ExtendWith(SpringExtension.class)
class SecurityConfigTest {
    @Autowired
    private SecurityConfig securityConfig;

    /**
     * Method under test: {@link SecurityConfig#securityFilterChain(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSecurityFilterChain() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        HttpSecurity http = null;

        // Act
        SecurityFilterChain actualSecurityFilterChainResult = this.securityConfig.securityFilterChain(http);

        // Assert
        // TODO: Add assertions on result
    }

    @Test
    void testPasswordEncoder() {
        assertTrue((new SecurityConfig(new JpaUserDetailsService(mock(UserRepository.class))))
                .passwordEncoder() instanceof BCryptPasswordEncoder);
    }
}

