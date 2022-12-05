package com.coherentsolutions.consoleApp.main;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.coherentsolutions.consoleApp.main.server.User;
import com.coherentsolutions.consoleApp.main.server.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

class StoreAppTest {

    @Test
    void testCommandLineRunner() throws Exception {
        StoreApp storeApp = new StoreApp();

        User user = new User();
        user.setId(123L);
        user.setPassword("https://example.org/example");
        user.setRoles("https://example.org/example");
        user.setUsername("janedoe");
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.save((User) any())).thenReturn(user);
        storeApp.commandLineRunner(userRepository, new Argon2PasswordEncoder()).run("foo");
        verify(userRepository, atLeast(1)).save((User) any());
    }
}

