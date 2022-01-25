package models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import utils.Estado;

public class Butaca extends Sala {
    private final String filas = "ABCDEFGHI";

    private char fila;
    private int columna;
    private Estado estado;


    public Butaca(){
        fila = ' ';
        columna = 0;
        estado = Estado.LIBRE;
    }
    public Butaca(char fila, int columna) {
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

    public void printButaca() {
        switch (getEstado()) {
            //LIBRE
            case LIBRE:
                System.out.print(Ansi.colorize("[ \uD83E\uDE91 ]", Attribute.GREEN_BACK()));
                break;
            //RESERVADA
            case RESERVADA:
                System.out.print(Ansi.colorize("[   ]", Attribute.BLUE_BACK()));
                break;
            //OCUPADA
            case OCUPADA:
                System.out.print(Ansi.colorize("[   ]", Attribute.RED_BACK()));
                break;
        }
    }
}
