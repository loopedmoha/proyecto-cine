package utils;

import models.Sala;

import java.util.Scanner;

public class Entrada {
    private static String FILAS = "ABCDE";

    /**
     * Le muestra al usuario un menu y le pide elegir una opcion
     *
     * @return opcion elegida
     */
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
            System.out.println("6. Anular compra");
            System.out.println("7. Resumen");
            try {
                opt = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Introduce una opcion valida (0-7)");
                sc.next();
            }
        } while (opt < 0 || opt > 7);
        return opt;
    }

    /**
     * Pide por teclado la columna
     *
     * @param sc Scanner de teclado
     * @return columna elegida
     */
    public static int getColumna(Scanner sc) {
        int columna;
        System.out.println("Selecciona un numero de butaca:");

        columna = sc.nextInt();
        return columna -1;
    }

    /**
     * Pide por teclado una fila
     *
     * @param sc Scanner de teclado
     * @return fila elegida
     */
    public static char getFila(Scanner sc) {
        char fila;
        String f;
        do {
            System.out.println("Selecciona una fila:");
            f = sc.next().toUpperCase();
            if (f.length() != 1 && FILAS.indexOf(f.charAt(0)) == -1)
                fila = ' ';
            else
                fila = f.charAt(0);
        } while (fila == ' ');
        return fila;
    }

    public static String getIdTicket(Scanner sc) {
        String id;
        id = sc.next();
        return id.toUpperCase();
    }

    public static int getnSala(int salas, Scanner sc) {
        int nSala = 0;

        System.out.println("Salas disponibles:");
        for (int i = 0; i < salas; i++) {
            System.out.println("Sala " + (i + 1));
        }
        System.out.println("Selecciona numero de sala");
        while (nSala == 0) {
            try {
                nSala = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Introduce un numero entre 1 y 9.");
                sc.next();
            }
        }

        return nSala - 1;
    }
}
