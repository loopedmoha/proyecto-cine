import models.Cine;
import utils.Entrada;

import java.util.Scanner;

public class Main {
    private static final int NUM_SALAS = 3;
    private static final String FILAS = "ABCDE";

    public static void main(String[] args) {
        Cine cine = new Cine();
        Scanner sc = new Scanner(System.in);


        char fila;
        int columna = 0;
        int nSala = 0;
        int opt = 0;
        do {
            opt = Entrada.menu();
            switch (opt) {
                //Salir
                case 0:
                    System.out.println("Hasta luego");
                    break;
                //mostrar sala
                case 1:
                    nSala = Entrada.getnSala(cine.getNSalas(), sc);
                    cine.printSala(nSala);
                    break;
                //comprar entrada
                case 2:

                    nSala = Entrada.getnSala(cine.getNSalas(), sc);
                    cine.printSala(nSala);
                    fila = Entrada.getFila(sc);
                    columna = Entrada.getColumna(sc);

                    cine.comprarEntrada(nSala, fila, columna);
                    break;
                //reservar entrada
                case 3:
                    nSala = Entrada.getnSala(cine.getNSalas(), sc);
                    cine.printSala(nSala);

                    fila = Entrada.getFila(sc);
                    columna = Entrada.getColumna(sc);

                    cine.reservarEntrada(nSala, fila, columna);
                    break;
                //confirmar reserva
                case 4:
                    nSala = Entrada.getnSala(cine.getNSalas(), sc);
                    fila = Entrada.getFila(sc);
                    columna = Entrada.getColumna(sc);

                    cine.confirmarReserva(nSala, fila, columna);

                    break;

                //cancelar reserva
                case 5:
                    nSala = Entrada.getnSala(cine.getNSalas(), sc);
                    fila = Entrada.getFila(sc);
                    columna = Entrada.getColumna(sc);

                    cine.anularReserva(nSala, fila, columna);

                    break;

                //anular compra
                case 6:
                    String id = "";
                    do {
                        System.out.println("Introduce el ID de tu recibo: ");
                        id = Entrada.getIdTicket(sc);
                    } while (id.length() != 3);

                    cine.cancelarCompra(id);
                    break;
                //Estadisticas de sala
                case 7:
                    nSala = Entrada.getnSala(cine.getNSalas(), sc);
                    cine.estadisticasSala(nSala);
                    break;
                default:
                    break;
            }
        }
        while (opt != 0);

    }


}
