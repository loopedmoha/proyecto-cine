import models.Sala;

import java.util.Locale;
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
            opt = menu();
            switch (opt) {
                //Salir
                case 0:
                    System.out.println("Hasta luego");
                    break;
                //mostrar sala
                case 1:
                    nSala = getnSala(sala, sc);
                    sala[nSala].printSala();
                    break;
                //comprar entrada
                case 2:
                    nSala = getnSala(sala, sc);

                    sala[nSala].printSala();
                    fila = getFila(sc);
                    columna = getColumna(sc);

                    if (!sala[nSala].isLibre(fila, columna))
                        System.out.println("Butaca ocupada. Cancelando reserva.");
                    else
                        sala[nSala].comprarButaca(fila, columna);
                    break;
                //reservar entrada
                case 3:
                    nSala = getnSala(sala, sc);

                    sala[nSala].printSala();
                    fila = getFila(sc);
                    columna = getColumna(sc);

                    if (!sala[nSala].isLibre(fila, columna))
                        System.out.println("Butaca ocupada. Cancelando reserva.");
                    else
                        sala[nSala].reservarButaca(fila, columna);
                    break;
                //confirmar reserva
                case 4:
                    nSala = getnSala(sala, sc);

                    fila = getFila(sc);
                    System.out.println("Selecciona una columna:");
                    columna = sc.nextInt();


                    sala[nSala].confirmarReserva(fila, columna);

                    break;

                //cancelar reserva
                case 5:
                    nSala = getnSala(sala, sc);

                    fila = getFila(sc);
                    System.out.println("Selecciona una columna:");
                    columna = sc.nextInt();

                    if (!sala[nSala].isReservada(fila, columna))
                        System.out.println("Butaca no ocupada.");
                    else
                        sala[nSala].liberarButaca(fila, columna);
                    break;

                //Estadisticas de sala
                case 6:
                    nSala = getnSala(sala, sc);
                    sala[nSala].estadisticasSala();
                    break;
            }
        }
        while (opt != 0);

    }

    private static int getColumna(Scanner sc) {
        int columna;
        System.out.println("Selecciona un numero de butaca:");
        columna = sc.nextInt();
        return columna;
    }

    private static char getFila(Scanner sc) {
        char fila;
        String f;
        System.out.println("Selecciona una fila:");
        f = sc.next().toUpperCase();
        fila = f.charAt(0);
        return fila;
    }

    private static int getnSala(Sala[] sala, Scanner sc) {
        System.out.println("Salas disponibles:");
        for (int i = 0; i < sala.length; i++) {
            System.out.println("Sala " + (i + 1));
        }
        System.out.println("Selecciona numero de sala");
        int nSala = sc.nextInt();
        return nSala - 1;
    }

    public static int menu() {
        int opt = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige una opción:");
        do {
            System.out.println("0. Salir");
            System.out.println("1. Ver Sala");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Reservar");
            System.out.println("4. Confirmar Reserva");
            System.out.println("5. Anular reserva");
            System.out.println("6. Resumen");
            try {
                opt = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Introduce una opcion valida (0-6)");
                sc.next();
            }
        } while (opt < 0 || opt > 6);
        return opt;
    }
}
