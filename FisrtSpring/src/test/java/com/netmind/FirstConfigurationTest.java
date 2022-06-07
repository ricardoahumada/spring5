package com.netmind;

import com.netmind.config.FirstConfiguration;
import com.netmind.modelos.Message;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FirstConfigurationTest {

    @Test
    public void createMessage() {
        FirstConfiguration config = new FirstConfiguration();
        Message unMensaje = config.createMessage();
        assertEquals(unMensaje.getMessage(),"Hola! Esto es un mensaje...");
    }
}