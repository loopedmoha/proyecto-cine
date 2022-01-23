import models.Sala;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SalaTest {
    private Sala sala = new Sala(1);

    @BeforeEach
    void resetSala() {
        sala = new Sala(1);
    }

    @Test
    void getNumSala() {
        assertEquals(1, sala.getNumSala());
    }

    @Test
    void setNumSala() {
        sala.setNumSala(2);
        assertEquals(2, sala.getNumSala());
    }

    @Test
    void getButacas() {
    }

    @Test
    void setButacas() {
    }
}