package com.coherentsolutions.consoleApp.main.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRoles(String)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRoles()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setId(123L);
        actualUser.setPassword("https://example.org/example");
        actualUser.setRoles("https://example.org/example");
        actualUser.setUsername("janedoe");
        String actualToStringResult = actualUser.toString();
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("https://example.org/example", actualUser.getPassword());
        assertEquals("https://example.org/example", actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals(
                "SecurityUser{id=123, username='janedoe', password='https://example.org/example', roles='https://example"
                        + ".org/example'}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String, String)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setRoles(String)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getRoles()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("janedoe", "https://example.org/example", "https://example.org/example");
        actualUser.setId(123L);
        actualUser.setPassword("https://example.org/example");
        actualUser.setRoles("https://example.org/example");
        actualUser.setUsername("janedoe");
        String actualToStringResult = actualUser.toString();
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("https://example.org/example", actualUser.getPassword());
        assertEquals("https://example.org/example", actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals(
                "SecurityUser{id=123, username='janedoe', password='https://example.org/example', roles='https://example"
                        + ".org/example'}",
                actualToStringResult);
    }
}

