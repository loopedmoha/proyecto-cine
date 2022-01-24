import models.Sala;

import java.util.Scanner;

public class Main {
    private static final int NUM_SALAS = 3;

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
                case 0:
                    System.out.println("Hasta luego");
                    break;
                case 1:
                    nSala = getnSala(sala, sc);
                    sala[nSala - 1].printSala();
                    break;
                case 2:
                    nSala = getnSala(sala, sc);
                    sala[nSala].printSala();
                    System.out.println("Selecciona una fila:");
                    fila = sc.next().charAt(0);
                    System.out.println("Selecciona un numero de butaca:");
                    columna = sc.nextInt();

                    if (!sala[nSala].isLibre(fila, columna))
                        System.out.println("Butaca ocupada. Cancelando reserva.");
                    else
                        sala[nSala] = sala[nSala].reservarButaca(fila, columna);
                    break;
            }
        }
        while (opt != 0);

    }

    private static int getnSala(Sala[] sala, Scanner sc) {
        System.out.println("Salas disponibles:");
        for (int i = 0; i < sala.length; i++) {
            System.out.println("Sala " + (i + 1));
        }
        System.out.println("Selecciona numero de sala");
        int nSala = sc.nextInt();
        return nSala;
    }

    public static int menu() {
        int opt = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige una opción:");
        do {
            System.out.println("0. Salir");
            System.out.println("1. Ver Sala");
            System.out.println("2. Reservar");
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
