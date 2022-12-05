package com.coherentsolutions.consoleApp.main.server;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AsyncConfig.class})
@ExtendWith(SpringExtension.class)
class AsyncConfigTest {
    @Autowired
    private AsyncConfig asyncConfig;

    @Test
    void testTaskExecutor() {
        assertTrue(asyncConfig.taskExecutor() instanceof ThreadPoolTaskExecutor);
    }
}

