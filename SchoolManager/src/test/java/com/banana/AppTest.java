package com.banana;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AppTest {

    ApplicationContext context;

    @Test
    public void shouldAnswerWithTrue() {
        assertNotNull(context);
    }


}
