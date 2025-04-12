package com.one.conversormoeda.util;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.one.conversormoeda.util.ConsoleUtil.getSeparador;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static BigDecimal lerBigDecimal(final String mensagem) {
        while (true) {
            System.out.print(mensagem);

            try {
                return scanner.nextBigDecimal();
            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número válido. Exemplo: 2,50");
                System.out.println(getSeparador());

                scanner.nextLine();
            }
        }
    }

    public static Integer lerInteger(final String mensagem) {
        while (true) {
            System.out.print(mensagem);

            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número válido. Exemplo: 2");
                System.out.println(getSeparador());

                scanner.nextLine();
            }
        }
    }
}
