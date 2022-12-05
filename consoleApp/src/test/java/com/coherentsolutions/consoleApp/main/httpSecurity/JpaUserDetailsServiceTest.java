package com.coherentsolutions.consoleApp.main.httpSecurity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JpaUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class JpaUserDetailsServiceTest {
    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setId(123L);
        user.setPassword("https://example.org/example");
        user.setRoles("https://example.org/example");
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);
        assertEquals("https://example.org/example", jpaUserDetailsService.loadUserByUsername("janedoe").getPassword());
        verify(userRepository).findByUsername((String) any());
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> jpaUserDetailsService.loadUserByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
    }

    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(userRepository.findByUsername((String) any()))
                .thenThrow(new UsernameNotFoundException("Username not found: "));
        assertThrows(UsernameNotFoundException.class, () -> jpaUserDetailsService.loadUserByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
    }
}

