import models.*;
import utils.*;

import java.util.Scanner;

public class Main {
    private static final int NUM_SALAS = 3;

    public static void main(String[] args) {
        Sala[] sala = new Sala[NUM_SALAS];
        int opt = menu();
    }

    public static int menu(){
        int opt = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige una opción:");
        do{
            System.out.println("0. Salir");
            System.out.println("1. Ver Sala");
            System.out.println("2. Reservar");
            System.out.println("4. Confirmar Reserva");
            System.out.println("5. Anular reserva");
            System.out.println("6. Resumen");
            try{
                opt = sc.nextInt();
            }catch (Exception e){
                System.out.println("Introduce una opcion valida (0-6)");
                sc.next();
            }
        }while(opt <0 || opt > 6);
        return opt;
    }
}
