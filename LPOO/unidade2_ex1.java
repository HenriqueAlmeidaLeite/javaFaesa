package LPOO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class unidade2_ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Integer> lista1 = new ArrayList<>();
        ArrayList <Integer> lista2 = new ArrayList<>();
        ArrayList <Integer> lista3 = new ArrayList<>();
        int cont1 = 1;
        int cont2 = 1;

        System.out.println();
        System.out.println("Preencha a lista 1 com números inteiros. Digite 0 para parar.");
        while (true) {
            System.out.println();
            System.out.print("Número " + cont1 + ": ");
            int esc = scanner.nextInt();
            if (esc == 0) {
                break;
            } else {
                lista1.add(esc);
                cont1++;
            }
        }

        System.out.println();
        System.out.println("Agora preencha a lista 2. Digite 0 para parar.");
        while (true) {
            System.out.println();
            System.out.print("Número " + cont2 + ": ");
            int esc = scanner.nextInt();
            if (esc == 0) {
                break;
            } else {
                lista2.add(esc);
                cont2++;
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("Lista 1: ");
        for (Integer integer : lista1) {
            System.out.print(integer + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Lista 2: ");
        for (Integer integer : lista2) {
            System.out.print(integer + " ");
        }

        for (Integer integer : lista1) {
            if (!lista3.contains(integer)) {
                lista3.add(integer);
            }
        }

        for (Integer integer : lista2) {
            if (!lista3.contains(integer)) {
                lista3.add(integer);
            }
        }

        Collections.sort(lista3);

        System.out.println();
        System.out.println();
        System.out.println("Lista 3: ");
        for (Integer integer : lista3) {
            System.out.print(integer + " ");
        }

        scanner.close();
    }
}
