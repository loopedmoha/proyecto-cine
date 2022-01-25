package models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

public class Cine {
    private final int NUM_SALAS = 3;
    private final String FILAS = "ABCDE";
    private final int MAX_COLUMNAS = 9;


    private Sala[] salas;
    private String nombreCine = "Cine";

    /**
     * Constructor de cine
     */
    public Cine() {
        salas = new Sala[NUM_SALAS];
        for (int i = 0; i < NUM_SALAS; i++) {
            salas[i] = new Sala(i+1);
        }
    }

    public Sala[] getSalas() {
        return salas;
    }

    public Sala getSalas(int sala) {
        return salas[sala];
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public int getNSalas(){
        return salas.length;
    }
    /**
     * Comprueba que la entrada es correcta para la sala
     *
     * @param sala numero de sala
     * @return booelan
     */
    public boolean isSalaOK(int sala) {
        return (sala < salas.length && sala >=0);
    }

    /**
     * Comprueba que la entrada es correcta para la fila
     *
     * @param fila letra de fila
     * @return booelan
     */
    public boolean isFilaOK(char fila) {
        return (FILAS.indexOf(fila) == -1);
    }

    /**
     * Comprueba que la entrada es correcta para la columna
     *
     * @param columna numero de columna
     * @return booelan
     */
    public boolean isColumnaOK(int columna) {
        return (columna < MAX_COLUMNAS && columna >= 0);
    }


    /**
     * Reserva una entrada en la localizacion dada por sala fila y columna
     *
     * @param sala    numero de sala
     * @param fila    letra de fila
     * @param columna numero de columna
     * @return true si la reserva se realiza con exito
     */
    public boolean reservarEntrada(int sala, char fila, int columna) {
        if (checkData(sala, fila, columna)) return false;

        return salas[sala].reservarButaca(fila, columna);
    }


    /**
     * Compra una entrada en la localizacion dada por sala fila y columna
     *
     * @param sala    numero de sala
     * @param fila    letra de fila
     * @param columna numero de columna
     * @return true si la compra se realiza con exito
     */
    public boolean comprarEntrada(int sala, char fila, int columna) {
        if (checkData(sala, fila, columna)) return false;
        return salas[sala].comprarButaca(fila, columna);
    }


    /**
     * Confrima una entrada reservada en la localizacion dada por sala fila y columna
     *
     * @param sala    numero de sala
     * @param fila    letra de fila
     * @param columna numero de columna
     * @return true si la confirmacion se realiza con exito
     */
    public boolean confirmarReserva(int sala, char fila, int columna) {
        if (checkData(sala, fila, columna)) return false;

        return salas[sala].confirmarReserva(fila, columna);
    }

    public boolean anularReserva(int sala, char fila, int columna){
        if (checkData(sala, fila, columna)) return false;

        return salas[sala].liberarButaca(fila, columna);
    }
    /**
     * Cancela la compra de una entrada y libera su espacio
     *
     * @param id id del ticket de compra
     * @return true si la cancelación se ha realizado con exito
     */
    public boolean cancelarCompra(String id) {
        int nSala = id.charAt(0) - 49;

        return salas[nSala].anularCompra(id.charAt(1), id.charAt(2)-48);
    }


    private boolean checkData(int sala, char fila, int columna) {
        if (!isSalaOK(sala)) {
            System.out.println("Numero de sala no valido.");
            return true;
        } else if (isFilaOK(fila)) {
            System.out.println("Fila incorrecta.");
            return true;
        } else if (!isColumnaOK(columna)) {
            System.out.println("Columna incorrecta.");
            return true;
        }
        return false;
    }

    public void printSala(int sala) {
        Attribute gb = Attribute.GREEN_BACK();
        Attribute rb = Attribute.RED_BACK();
        Attribute bb = Attribute.BLUE_BACK();
        Attribute wt = Attribute.WHITE_TEXT();
        System.out.print(Ansi.colorize("LIBRE ", gb));
        System.out.print(Ansi.colorize("OCUPADA ", rb));
        System.out.print(Ansi.colorize("RESERVADA \n", bb));
        System.out.println("   1     2     3    4     5     6    7     8     9  ");
        salas[sala].printSala();
        System.out.println("   1     2     3    4     5     6    7     8     9  ");
    }

    public void estadisticasSala(int nSala) {
        salas[nSala].estadisticasSala();
    }
}
