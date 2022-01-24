package models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import utils.Estado;

public class Sala {
    private final int MAX_FILAS = 5;
    private final int MAX_COLUMNAS = 9;
    private final String filas = "ABCDE";


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
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                butacas[i][j] = new Butaca(filas.charAt(i), j);
            }

        }
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

    public Sala reservarButaca(char fila, int columna) {
        if (isLibre(fila, columna)) {
            butacas[filas.indexOf(fila)][columna - 1].setEstado(Estado.RESERVADA);
            return this;
        } else
            System.out.println("Butaca ocupada. Elige otra.");
        return null;
    }

    public void printSala() {
        Attribute gb = Attribute.GREEN_BACK();
        Attribute rb = Attribute.RED_BACK();
        Attribute bb = Attribute.BLUE_BACK();
        for (int i = 0; i < MAX_FILAS; i++) {
            System.out.print(filas.charAt(i));
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (butacas[i][j].getEstado() == Estado.LIBRE)
                    System.out.print(Ansi.colorize("["+j+"]", gb));
                else if(butacas[i][j].getEstado() == Estado.OCUPADA)
                    System.out.print(Ansi.colorize("["+j+"]", rb));
                else
                    System.out.print(Ansi.colorize("["+j+"]", bb));

            }
            System.out.println("");
        }
    }
}
