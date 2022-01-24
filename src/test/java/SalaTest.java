import models.Sala;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaTest {
    private Sala sala = new Sala(1, 3, 3);
    private int precio = 6;
    @BeforeEach
    void resetSala() {
        sala = new Sala(1, 3, 3);
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
        assertNotEquals(null, sala.getButacas());
    }

    @Test
    void setButacas() {
    }

    @Test
    void getbOcupadas() {

        assertEquals(0, sala.getbOcupadas());
    }

    @Test
    void setbOcupadas() {
        sala.setbOcupadas(5);
        assertEquals(5, sala.getbOcupadas());
    }

    @Test
    void getbReservadas() {

        assertEquals(0, sala.getbReservadas());
    }

    @Test
    void setbReservadas() {
        sala.setbReservadas(5);
        assertEquals(5, sala.getbReservadas());
    }

    @Test
    void getbLibres() {
        assertEquals(9, sala.getbLibres());
    }

    @Test
    void setbLibres() {
        sala.setbLibres(5);
        assertEquals(5, sala.getbLibres());
    }

    @Test
    void increaseRecaudacion() {
        assertEquals(6, sala.increaseRecaudacion());
    }

    @Test
    void decreaseRecaudacion() {
        assertEquals(-1, sala.decreaseRecaudacion());
        sala.setRecaudacion(12);
        assertEquals(6, sala.decreaseRecaudacion());
    }

    @Test
    void isLibre() {
        assertTrue(sala.isLibre('A', 1));

        sala.comprarButaca('A', 1);
        assertFalse(sala.isLibre('A', 1));
    }

    @Test
    void isReservada() {
        assertFalse(sala.isReservada('A', 1));

        //sala.reservarButaca('A', 1);
        assertTrue(sala.reservarButaca('A', 1));
    }

    @Test
    void confirmarReserva() {
        assertFalse(sala.confirmarReserva('A', 1));

        sala.reservarButaca('A', 1);
        assertTrue(sala.confirmarReserva('A', 1));
    }

    @Test
    void liberarButaca() {
        assertFalse(sala.liberarButaca('A', 1));

        sala.reservarButaca('A', 1);
        assertTrue(sala.liberarButaca('A', 1));
    }

    @Test
    void comprarButaca() {
        assertTrue(sala.comprarButaca('A', 1));
        assertFalse(sala.comprarButaca('A',1));
    }

    @Test
    void reservarButaca() {
        assertTrue(sala.comprarButaca('A', 1));
        assertFalse(sala.comprarButaca('A',1));
    }
}