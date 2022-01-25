package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CineTest {
    private Cine cine;
    private final int MAX_COLUMNAS = 9;

    @BeforeEach
    void resetCine() {
        int salas = 2;
        cine = new Cine(2);
    }

    @Test
    void isSalaOK() {
        int s1, s2, s3;
        s1 = 0;
        s2 = 1;
        s3 = 5;


        assertAll(
                () -> assertTrue(cine.isSalaOK(s1)),
                () -> assertTrue(cine.isSalaOK(s2)),
                () -> assertFalse(cine.isSalaOK(s3))
        );
    }

    @Test
    void isFilaOK() {
        char f1, f2, f3;
        f1 = 'A';
        f2 = ' ';
        f3 = 'J';

        assertTrue(cine.isFilaOK(f1));
        assertFalse(cine.isFilaOK(f2));
        assertFalse(cine.isFilaOK(f3));
    }

    @Test
    void isColumnaOK() {
        int c1, c2, c3;
        c1 = 0;
        c2 = 2;
        c3 = 10;
        assertTrue(cine.isColumnaOK(c1));
        assertTrue(cine.isColumnaOK(c2));
        assertFalse(cine.isColumnaOK(c3));
    }

    @Test
    void reservarEntrada() {
        int sala;
        char fila;
        int columna;

        //todos los datos correctos
        sala = 1;
        fila = 'A';
        columna = 2;
        assertTrue(cine.reservarEntrada(sala, fila, columna));

        //sala incorrecta
        sala = -1;
        assertFalse(cine.reservarEntrada(sala, fila, columna));

        //fila incorrecta
        sala = 1;
        fila = 'K';
        assertFalse(cine.reservarEntrada(sala, fila, columna));

        //columna incorrecta
        fila = 'A';
        columna = -1;
        assertFalse(cine.reservarEntrada(sala, fila, columna));
    }

    @Test
    void comprarEntrada() {
        int sala;
        char fila;
        int columna;

        //todos los datos correctos
        sala = 1;
        fila = 'A';
        columna = 2;
        assertTrue(cine.comprarEntrada(sala, fila, columna));

        //sala incorrecta
        sala = -1;
        assertFalse(cine.comprarEntrada(sala, fila, columna));

        //fila incorrecta
        sala = 1;
        fila = 'K';
        assertFalse(cine.comprarEntrada(sala, fila, columna));

        //columna incorrecta
        fila = 'A';
        columna = -1;
        assertFalse(cine.comprarEntrada(sala, fila, columna));
    }

    @Test
    void confirmarReserva() {
        int sala;
        char fila;
        int columna;

        //todos los datos correctos
        sala = 1;
        fila = 'A';
        columna = 2;
        cine.reservarEntrada(sala, fila, columna);
        assertTrue(cine.confirmarReserva(sala, fila, columna));

        //sala incorrecta
        sala = -1;
        assertFalse(cine.confirmarReserva(sala, fila, columna));

        //fila incorrecta
        sala = 1;
        fila = 'K';
        assertFalse(cine.confirmarReserva(sala, fila, columna));

        //columna incorrecta
        fila = 'A';
        columna = -1;
        assertFalse(cine.confirmarReserva(sala, fila, columna));
    }

    @Test
    void anularReserva() {
        int sala;
        char fila;
        int columna;

        //reservar entrada

        //todos los datos correctos

        sala = 1;
        fila = 'A';
        columna = 2;
        cine.reservarEntrada(sala, fila, columna);
        assertTrue(cine.anularReserva(sala, fila, columna));

        //sala incorrecta
        sala = -1;
        assertFalse(cine.anularReserva(sala, fila, columna));

        //fila incorrecta
        sala = 1;
        fila = 'K';
        assertFalse(cine.anularReserva(sala, fila, columna));

        //columna incorrecta
        fila = 'A';
        columna = -1;
        assertFalse(cine.anularReserva(sala, fila, columna));

    }

    @Test
    void cancelarCompra() {
        String id1;
        cine.comprarEntrada(0, 'A', 2);

        //todos los datos correctos
        id1 = "1A2";
        assertTrue(cine.cancelarCompra(id1));

        //id incorrecto
        id1 = "z# ";
        assertFalse(cine.cancelarCompra(id1));
    }
}