package com.coherentsolutions.consoleApp.main.server;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {UserRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.coherentsolutions.consoleApp.main.httpSecurity"})
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserRepository#findByUsername(String)}
     */
    @Test
    void testFindByUsername() {
        User user = new User();
        user.setPassword("https://example.org/example");
        user.setRoles("https://example.org/example");
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setPassword("https://example.org/example");
        user1.setRoles("https://example.org/example");
        user1.setUsername("janedoe");
        userRepository.save(user);
        userRepository.save(user1);
        assertFalse(userRepository.findByUsername("https://example.org/example").isPresent());
    }
}

