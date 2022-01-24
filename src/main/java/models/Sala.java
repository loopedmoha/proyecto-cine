package models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import utils.Estado;

public class Sala {
    private final int MAX_FILAS = 5;
    private final int MAX_COLUMNAS = 9;
    private final int PRECIO_ENTRADA = 6;
    private final String LETRA_FILAS = "ABCDE";


    private int recaudacion;

    private int bOcupadas;
    private int bReservadas;
    private int bLibres;

    private Ticket[] tickets;

    private int numSala;
    private Butaca[][] butacas;

    /**
     * Constructor vacio
     */
    public Sala() {
        numSala = 0;
        butacas = new Butaca[MAX_FILAS][MAX_COLUMNAS];
        recaudacion = 0;
        bLibres = MAX_COLUMNAS * MAX_FILAS;
        bOcupadas = 0;
        bReservadas = 0;
        tickets = new Ticket[MAX_FILAS * MAX_COLUMNAS];
    }

    /**
     * Constructor que asigna un numero de sala
     *
     * @param sala
     */
    public Sala(int sala) {
        setNumSala(sala);
        recaudacion = 0;
        butacas = new Butaca[MAX_FILAS][MAX_COLUMNAS];
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                butacas[i][j] = new Butaca(LETRA_FILAS.charAt(i), j);
            }

        }
        bLibres = MAX_COLUMNAS * MAX_FILAS;
        bOcupadas = 0;
        bReservadas = 0;

        tickets = new Ticket[MAX_FILAS * MAX_COLUMNAS];
    }

    /**
     * Constructor para salas de tamaño personalizado. Solo usar para testeo
     *
     * @param sala
     * @param filas
     * @param columnas
     */
    public Sala(int sala, int filas, int columnas) {
        setNumSala(sala);
        recaudacion = 0;
        butacas = new Butaca[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                butacas[i][j] = new Butaca(LETRA_FILAS.charAt(i), j);
            }

        }
        bLibres = filas * columnas;
        bOcupadas = 0;
        bReservadas = 0;
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

        return butacas[LETRA_FILAS.indexOf(fila)][columna];
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

    public int getbOcupadas() {
        return bOcupadas;
    }

    public void setbOcupadas(int bOcupadas) {
        this.bOcupadas = bOcupadas;
    }

    public int getbReservadas() {
        return bReservadas;
    }

    public void setbReservadas(int bReservadas) {
        this.bReservadas = bReservadas;
    }

    public int getbLibres() {
        return bLibres;
    }

    public void setbLibres(int bLibres) {
        this.bLibres = bLibres;
    }


    /**
     * Aumenta la recaudacion al realizar una compra
     *
     * @return
     */
    public int increaseRecaudacion() {
        setRecaudacion(getRecaudacion() + PRECIO_ENTRADA);
        return getRecaudacion();
    }

    /**
     * Decrementa la reacudacion de la sala al cancelar una compra. Actualmente no se pueden cancelar compras
     *
     * @return
     */
    public int decreaseRecaudacion() {
        if (getRecaudacion() >= PRECIO_ENTRADA) {
            setRecaudacion(getRecaudacion() - 6);

            return getRecaudacion();
        } else return -1;
    }

    /**
     * Comrpueba si una butaca esta libre
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean isLibre(char fila, int columna) {

        return (butacas[LETRA_FILAS.indexOf(fila)][columna - 1].getEstado() == Estado.LIBRE);
    }

    /**
     * Comprueba si una butaca esta reservada
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean isReservada(char fila, int columna) {

        return (butacas[LETRA_FILAS.indexOf(fila)][columna - 1].getEstado() == Estado.RESERVADA);
    }


    public void generarTicket(int nSala, char fila, int columna) {
        int t = nextTicket();
        StringBuilder sb = new StringBuilder();



        tickets[t] = new Ticket(nSala, fila, columna);
    }


    public int nextTicket() {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null)
                return i;
        }
        return -1;
    }

    public int buscarTicket(String id){
        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i].getId().equals(id))
                return i;
        }
        return -1;
    }

    /**
     * Confirma una butaca reservada pasandola de reservada a ocupada
     *
     * @param fila
     * @param columna
     * @return
     */


    public boolean confirmarReserva(char fila, int columna) {
        if (isReservada(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna - 1].setEstado(Estado.OCUPADA);

            increaseRecaudacion();
            setbReservadas(bOcupadas + 1);
            setbLibres(bLibres - 1);
            generarTicket(numSala, fila, columna);
            return true;
        } else {
            System.out.println("Butaca no reservada.");
            return false;
        }

    }

    /**
     * Libera una butaca reservada
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean liberarButaca(char fila, int columna) {
        if (isReservada(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna - 1].setEstado(Estado.LIBRE);
            //decreaseRecaudacion();

            setbLibres(bLibres + 1);
            setbReservadas(bReservadas - 1);

            int t = buscarTicket(""+ numSala + fila + columna);
            tickets[t] = null;
            return true;
        } else
            return false;
    }

    /**
     * Compra una butaca que este libre
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean comprarButaca(char fila, int columna) {
        if (isLibre(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna - 1].setEstado(Estado.OCUPADA);

            increaseRecaudacion();
            setbOcupadas(bOcupadas + 1);
            setbLibres(bLibres - 1);
            generarTicket(numSala, fila, columna);
            return true;
        } else {
            System.out.println("Butaca no disponible.");
            return false;
        }

    }

    /**
     * Reserva una butaca libre
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean reservarButaca(char fila, int columna) {
        if (isLibre(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna - 1].setEstado(Estado.RESERVADA);

            setbReservadas(bReservadas + 1);
            setbLibres(bLibres - 1);

            return true;
        } else
            System.out.println("Butaca ocupada. Elige otra.");
        return false;
    }

    /**
     * Muestra la sala por consola
     */
    public void printSala() {
        Attribute gb = Attribute.GREEN_BACK();
        Attribute rb = Attribute.RED_BACK();
        Attribute bb = Attribute.BLUE_BACK();
        Attribute wt = Attribute.WHITE_TEXT();
        System.out.print(Ansi.colorize("LIBRE ", gb));
        System.out.print(Ansi.colorize("OCUPADA ", rb));
        System.out.print(Ansi.colorize("RESERVADA \n", bb));
        System.out.println("   1     2     3    4     5     6    7     8     9  ");
        for (int i = 0; i < MAX_FILAS; i++) {
            System.out.print(LETRA_FILAS.charAt(i));
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                butacas[i][j].printButaca();

            }
            System.out.println();
        }
        System.out.println("   1     2     3    4     5     6    7     8     9  ");
    }

    /**
     * Muestra la sala y las estadisticas de la sala
     */
    public void estadisticasSala() {
        printSala();
        System.out.println("Butacas libres: " + getbLibres());
        System.out.println("Butacas reservadas: " + getbReservadas());
        System.out.println("Butacas ocupadas: " + getbOcupadas());

        System.out.println("Recaudación de la sala: " + getRecaudacion());
    }
}
