import models.Sala;
import utils.Entrada;

import java.util.Scanner;

public class Main {
    private static final int NUM_SALAS = 3;
    private static final String FILAS = "ABCDE";

    public static void main(String[] args) {
        Sala[] sala = new Sala[NUM_SALAS];
        for (int i = 0; i < NUM_SALAS; i++) {
            sala[i] = new Sala(i + 1);

        }
        Scanner sc = new Scanner(System.in);


        char fila = ' ';
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
                    nSala = Entrada.getnSala(sala, sc);
                    sala[nSala].printSala();
                    break;
                //comprar entrada
                case 2:
                    nSala = Entrada.getnSala(sala, sc);

                    sala[nSala].printSala();
                    fila = Entrada.getFila(sc);
                    columna = Entrada.getColumna(sc);

                    if (!sala[nSala].isLibre(fila, columna))
                        System.out.println("Butaca ocupada. Cancelando reserva.");
                    else
                        sala[nSala].comprarButaca(fila, columna);
                    break;
                //reservar entrada
                case 3:
                    nSala = Entrada.getnSala(sala, sc);

                    sala[nSala].printSala();
                    fila = Entrada.getFila(sc);
                    columna = Entrada.getColumna(sc);

                    if (!sala[nSala].isLibre(fila, columna))
                        System.out.println("Butaca ocupada. Cancelando reserva.");
                    else
                        sala[nSala].reservarButaca(fila, columna);
                    break;
                //confirmar reserva
                case 4:
                    nSala = Entrada.getnSala(sala, sc);

                    fila = Entrada.getFila(sc);
                    System.out.println("Selecciona una columna:");
                    columna = sc.nextInt();


                    sala[nSala].confirmarReserva(fila, columna);

                    break;

                //cancelar reserva
                case 5:
                    nSala = Entrada.getnSala(sala, sc);

                    fila = Entrada.getFila(sc);
                    System.out.println("Selecciona una columna:");
                    columna = sc.nextInt();

                    if (!sala[nSala].isReservada(fila, columna))
                        System.out.println("Butaca no ocupada.");
                    else
                        sala[nSala].liberarButaca(fila, columna);
                    break;

                //anular compra
                case 6:
                    break;
                //Estadisticas de sala
                case 7:
                    nSala = Entrada.getnSala(sala, sc);
                    sala[nSala].estadisticasSala();
                    break;
                default:
                    break;
            }
        }
        while (opt != 0);

    }


}
