package com.banana;

import com.banana.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AppTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void shouldAnswerWithTrue() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        assertNotNull(context);
    }


}
