import models.Butaca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Estado;

import static org.junit.jupiter.api.Assertions.*;

class ButacaTest {

    private Butaca butaca = new Butaca('A', 1);
    @BeforeEach
    void resetButaca(){
        butaca = new Butaca('A', 1);
    }

    @Test
    void getColumna() {
        assertEquals(1, butaca.getColumna());
    }

    @Test
    void setColumna() {
        butaca.setColumna(2);
        assertEquals(2, butaca.getColumna());
    }

    @Test
    void getFila() {
        assertEquals('A', butaca.getFila());
    }

    @Test
    void setFila() {
        butaca.setFila('B');
        assertEquals('B', butaca.getFila());
    }

    @Test
    void getEstado() {
        assertEquals(Estado.LIBRE, butaca.getEstado());
    }

    @Test
    void setEstado() {
        butaca.setEstado(Estado.OCUPADA);
        assertEquals(Estado.OCUPADA, butaca.getEstado());
    }
}