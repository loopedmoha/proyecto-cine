package models;

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


    public Sala() {
        recaudacion = 0;
        bOcupadas = 0;
        bReservadas = 0;
        bLibres = MAX_FILAS * MAX_COLUMNAS;
        numSala = 0;
        tickets = new Ticket[MAX_FILAS * MAX_COLUMNAS];
        butacas = new Butaca[MAX_FILAS][MAX_COLUMNAS];
    }

    /**
     * Constructor que asigna un numero de sala
     *
     * @param sala sala construida
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
     * @return la recaudacion acumulada
     */
    public int increaseRecaudacion() {
        setRecaudacion(getRecaudacion() + PRECIO_ENTRADA);
        return getRecaudacion();
    }

    /**
     * Decrementa la reacudacion de la sala al cancelar una compra. Actualmente no se pueden cancelar compras
     *
     * @return recaudacion acumulada
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
     * @param fila    letra de la fila
     * @param columna columna
     * @return true si la butaca esta libre
     */
    public boolean isLibre(char fila, int columna) {

        return (butacas[LETRA_FILAS.indexOf(fila)][columna].getEstado() == Estado.LIBRE);
    }

    /**
     * Comprueba si una butaca esta reservada
     *
     * @param fila    letra de la fila
     * @param columna numero de columna
     * @return true si esta reservada
     */
    public boolean isReservada(char fila, int columna) {

        return (butacas[LETRA_FILAS.indexOf(fila)][columna].getEstado() == Estado.RESERVADA);
    }

    /**
     * Crea un ticket con un ID
     *
     * @param nSala   numero de la sala de la entrada
     * @param fila    fila de la butaca
     * @param columna numero de la butaca
     */
    public void generarTicket(int nSala, char fila, int columna) {
        int t = nextTicket();
        tickets[t] = new Ticket(nSala, fila, columna);
        tickets[t].printTicket();
    }

    /**
     * Busca el siguiente ticket vacio
     *
     * @return posicion del ticket vacio. -1 si no hay hueco
     */
    public int nextTicket() {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null)
                return i;
        }
        return -1;
    }


    /**
     * Busca un ticket asociado a un id
     *
     * @param id id del ticket (SALA+FILA+COLUMNA)
     * @return la posicion del ticket buscado. -1 si no existe
     */
    public int buscarTicket(String id) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getId().equals(id))
                return i;
        }
        System.out.println("Ticket no encontrado");
        return -1;
    }

    /**
     * Confirma una butaca reservada pasandola de reservada a ocupada
     *
     * @param fila    fila de la butaca
     * @param columna letra de la butaca
     * @return true si la reserva se realiza con exito
     */


    public boolean confirmarReserva(char fila, int columna) {
        if (isReservada(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna].setEstado(Estado.OCUPADA);

            increaseRecaudacion();
            setbOcupadas(bOcupadas + 1);
            setbReservadas(bReservadas - 1);
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
     * @param fila    fila de la butaca
     * @param columna columna de la butaca
     * @return true si se realiza la liberacion
     */
    public boolean liberarButaca(char fila, int columna) {
        if (isReservada(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna].setEstado(Estado.LIBRE);
            //decreaseRecaudacion();

            setbLibres(bLibres + 1);
            setbReservadas(bReservadas - 1);

            return true;
        } else {
            System.out.println("Butaca no reservada. No se puede liberar.");
            return false;
        }

    }

    /**
     * Anula una compra realizada
     *
     * @param fila    fila de la butaca
     * @param columna letra de la butaca
     * @return true si la comrpa se anula con exitop
     */
    public boolean anularCompra(char fila, int columna) {
        if (!isLibre(fila, columna) || !isReservada(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna].setEstado(Estado.LIBRE);
            decreaseRecaudacion();
            setbLibres(bLibres + 1);
            setbOcupadas(bOcupadas - 1);

            int t = buscarTicket("" + numSala + fila + columna);
            if (t != -1)
                tickets[t] = null;
            else {
                System.out.println("Ticket no encontrado.");
                return false;
            }
            return true;
        } else {
            System.out.println("Butaca no comprada. No se puede cancelar.");
            return false;
        }

    }
//TODO Arreglar ordenacion (probar con burbuja)
    public void ticketSort() {
        Ticket tmp = null;
        compactarTickets();
        int size = ticketsSize();

        //cambiar este if para hacerlo ascendente o descendente
        for (int i = 1; i < size; i++)
            for (int j = size - 1; j >= i; j--)
                if (Ticket.compareTicket(tickets[j], tickets[j - 1])==-1) {
                    tmp = tickets[j];
                    tickets[j] = tickets[j - 1];
                    tickets[j - 1] = tmp;
                }
    }

    private int ticketsSize(){
        int size = 0;
        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i] != null) size++;
        }
        return size;
    }
    private void compactarTickets(){
        Ticket tmp = null;
        for (int i = 1; i < tickets.length; i++) {
            if(tickets[i] != null && tickets[i-1] == null) {
                tickets[i - 1] = tickets[i];
            tickets[i] = null;
            }
        }
    }
    /**
     * Compra una butaca que este libre
     *
     * @param fila    fila de la butaca
     * @param columna letra de la butaca
     * @return true si la compra se realiza con exito
     */
    public boolean comprarButaca(char fila, int columna) {
        if (isLibre(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna].setEstado(Estado.OCUPADA);

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
     * @param fila    fila de la butaca
     * @param columna letra de la butaca
     * @return true si la reserva se realiza con exito
     */
    public boolean reservarButaca(char fila, int columna) {
        if (isLibre(fila, columna)) {
            butacas[LETRA_FILAS.indexOf(fila)][columna].setEstado(Estado.RESERVADA);

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

        for (int i = 0; i < MAX_FILAS; i++) {
            System.out.print(LETRA_FILAS.charAt(i));
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                butacas[i][j].printButaca();

            }
            System.out.println();
        }
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
