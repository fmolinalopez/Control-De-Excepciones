package com.molina.mail;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Fran on 19/5/17.
 */
public class ManageMail {
    public static void main(String[] args) {

        try {
            String email = readMail();
        } catch (WrongMailException e) {
            System.out.println("Email incorrecto.");
        }

    }

    private static String readMail() throws WrongMailException {
        Scanner input = new Scanner(System.in);
        String email;
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Introduce el email:");
        email = input.nextLine();

        if ( pattern.matcher(email).matches()) {
            System.out.println("Email correcto");
        } else {
            throw new WrongMailException("Email incorrecto");
        }

        return email;
    }
}

class WrongMailException extends IOException {

    public WrongMailException() {

    }

    public WrongMailException(String msgError) {
        super(msgError);
    }
}
