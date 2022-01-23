import models.*;
import utils.*;

import java.util.Scanner;

public class Main {
    private static final int NUM_SALAS = 3;

    public static void main(String[] args) {
        Sala[] sala = new Sala[NUM_SALAS];
        for (int i = 0; i < NUM_SALAS; i++) {
            sala[i] = new Sala(i+1);

        }
        Scanner sc = new Scanner(System.in);

        int opt = menu();
        char fila = ' ';
        int columna = 0;
        int numSala = 0;


        switch (opt) {
            case 0:
                System.out.println("Hasta luego");
                break;
            case 1:
                System.out.println("Selecciona numero de sala");
                int nSala = sc.nextInt();
                sala[nSala].printSala();
                break;
            case 2:

                System.out.println("Selecciona una fila:");
                fila = sc.next().charAt(0);
                System.out.println("Selecciona un numero de butaca:");
                columna = sc.nextInt();

                if (!sala[numSala].reservarButaca(fila, columna))
                    System.out.println("Butaca ocupada. Cancelando reserva.");
                break;


        }
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
