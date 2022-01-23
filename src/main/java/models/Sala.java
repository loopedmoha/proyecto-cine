package models;

import models.Butaca;
import utils.Estado;

public class Sala {
    private final int MAX_FILAS = 5;
    private final int MAX_COLUMNAS = 9;
    private final String filas = "ABCDEFGHI";


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
        } else return -1;
    }

    public boolean isLibre(char fila, int columna) {

        return (butacas[filas.indexOf(fila)][columna - 1].getEstado() == Estado.LIBRE);
    }

    public boolean reservarButaca(char fila, int columna) {
        if (isLibre(fila, columna)) {
            butacas[filas.indexOf(fila)][columna -1].setEstado(Estado.RESERVADA);
            return true;
        }
        else
            System.out.println("Butaca ocupada. Elige otra.");
        return false;
    }

    public void printSala() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print("[ ] ");
            }
            System.out.println("");
        }
    }
}
