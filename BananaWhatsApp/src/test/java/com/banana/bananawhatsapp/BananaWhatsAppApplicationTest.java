package com.banana.bananawhatsapp;

import com.banana.bananawhatsapp.util.DBUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})*/
class BananaWhatsAppApplicationTest {
    @Test
    public void load() {
        DBUtil.reloadDB();
        assertTrue(true);
    }
}