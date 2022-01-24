package models;

import utils.Estado;

public class Butaca {
    private final String filas = "ABCDEFGHI";

    private char fila;
    private int columna;
    private Estado estado;

    public Butaca(char fila, int columna){
        setFila(fila);
        setColumna(columna);
        setEstado(Estado.LIBRE);
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {

        this.estado = estado;
    }


}
