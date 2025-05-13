package net.andresbustamante.mystore.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = MyStoreWebApplication.class)
@ActiveProfiles({"test", "h2"})
class MyStoreWebApplicationIT {

    @Test
    void contextLoads() {
        assertTrue(true); // NOSONAR
    }
}
