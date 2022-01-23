package models;

import models.Butaca;

public class Sala {
    private final int MAX_FILAS = 5;
    private final int MAX_COLUMNAS = 9;


    private int recaudacion;
    private int numSala;
    private Butaca[][] butacas;

    public Sala() {
        numSala = 0;
        butacas = new Butaca[MAX_FILAS][MAX_COLUMNAS];
        recaudacion = 0;
    }

    public Sala(int sala) {
        setNumSala(sala);
        recaudacion = 0;
        butacas = new Butaca[MAX_FILAS][MAX_COLUMNAS];
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    public Butaca getButacas(char fila, int columna) {
        String filas = "ABCDEFGHI";
        return butacas[filas.indexOf(fila)][columna];
    }

    public void setButacas(Butaca[][] butacas) {
        this.butacas = butacas;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int increaseRecaudacion() {
        setRecaudacion(getRecaudacion() + 6);
        return getRecaudacion();
    }

    public int decreaseRecaudacion() {
        if (getRecaudacion() >= 6) {
            setRecaudacion(getRecaudacion() - 6);

            return getRecaudacion();
        }else return -1;
    }
}
