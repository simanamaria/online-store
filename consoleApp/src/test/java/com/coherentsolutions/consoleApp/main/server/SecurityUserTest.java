package com.coherentsolutions.consoleApp.main.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class SecurityUserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SecurityUser#SecurityUser(User)}
     *   <li>{@link SecurityUser#isAccountNonExpired()}
     *   <li>{@link SecurityUser#isAccountNonLocked()}
     *   <li>{@link SecurityUser#isCredentialsNonExpired()}
     *   <li>{@link SecurityUser#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User user = new User();
        user.setId(123L);
        user.setPassword("https://example.org/example");
        user.setRoles("https://example.org/example");
        user.setUsername("janedoe");
        SecurityUser actualSecurityUser = new SecurityUser(user);
        assertTrue(actualSecurityUser.isAccountNonExpired());
        assertTrue(actualSecurityUser.isAccountNonLocked());
        assertTrue(actualSecurityUser.isCredentialsNonExpired());
        assertTrue(actualSecurityUser.isEnabled());
    }

    /**
     * Method under test: {@link SecurityUser#getUsername()}
     */
    @Test
    void testGetUsername() {
        assertNull((new SecurityUser(new User())).getUsername());
    }

    /**
     * Method under test: {@link SecurityUser#getUsername()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsername2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.coherentsolutions.consoleApp.main.httpSecurity.SecurityUser.getUsername(SecurityUser.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        (new SecurityUser(null)).getUsername();
    }

    /**
     * Method under test: {@link SecurityUser#getPassword()}
     */
    @Test
    void testGetPassword() {
        assertNull((new SecurityUser(new User())).getPassword());
    }

    /**
     * Method under test: {@link SecurityUser#getPassword()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPassword2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.coherentsolutions.consoleApp.main.httpSecurity.SecurityUser.getPassword(SecurityUser.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        (new SecurityUser(null)).getPassword();
    }

    /**
     * Method under test: {@link SecurityUser#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.coherentsolutions.consoleApp.main.httpSecurity.SecurityUser.getAuthorities(SecurityUser.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        (new SecurityUser(new User())).getAuthorities();
    }

    /**
     * Method under test: {@link SecurityUser#getAuthorities()}
     */
    @Test
    void testGetAuthorities2() {
        Collection<? extends GrantedAuthority> actualAuthorities = (new SecurityUser(
                new User("janedoe", "https://example.org/example", "https://example.org/example"))).getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("https://example.org/example",
                ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Method under test: {@link SecurityUser#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.coherentsolutions.consoleApp.main.httpSecurity.SecurityUser.getAuthorities(SecurityUser.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        (new SecurityUser(null)).getAuthorities();
    }

    /**
     * Method under test: {@link SecurityUser#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: A granted authority textual representation is required
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)
        //       at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:948)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:499)
        //       at com.coherentsolutions.consoleApp.main.httpSecurity.SecurityUser.getAuthorities(SecurityUser.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        (new SecurityUser(new User("janedoe", "https://example.org/example", ""))).getAuthorities();
    }
}

