package com.molina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numero = leerNumeroEAFP();

        System.out.println("El numero es: " + numero);

        try {
            FileReader fr = new FileReader(new File("manolo.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static int leerNumeroEAFP() {
        Scanner input = new Scanner(System.in);
        int num;

        try {
            num = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("No sabes lo que es un número?");
            return 0;
        } catch (NoSuchElementException e) {
            System.out.println("No such");
            return 0;
        } catch (IllegalStateException e) {
            System.out.println("Illegal");
            return 0;
        }


        return num;
    }

    private static int leerNumero() {
        Scanner input = new Scanner(System.in);
        String in;
        boolean isValid = true;

        System.out.println("Dame un numero: ");
        in = input.nextLine();

        for (int i = 0; i < in.length(); i++) {
            if ( !Character.isDigit(in.charAt(i)) ) {
                isValid = false;
                break;
            }
        }

        if ( isValid ) {
            return Integer.parseInt( in );
        }

        return 0;
    }
}
