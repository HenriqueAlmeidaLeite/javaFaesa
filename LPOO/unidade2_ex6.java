package LPOO;

import java.util.ArrayList;
import java.util.Scanner;

public class unidade2_ex6 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        FilaInt fila = new FilaInt();

        System.out.println();
        System.out.println("Seja bem-vindo!");
        System.out.println();

        entradaDeValores(fila);
        retirarInteiros(fila);
        mostrarFila(fila);
        
        System.out.println();
        System.out.println("Fim do programa.");
        scanner.close();
        }


        public static void entradaDeValores(FilaInt fila){       
            while(true){
                System.out.println();
                System.out.println("Qual número você quer adicionar? Digite 0 para sair.");
                int esc = scanner.nextInt();
                if (esc == 0) {
                    System.out.println();
                    System.out.println("Entrada de valores encerrada."); 
                    System.out.println();
                    return;
                } else {
                    fila.enqueue(esc);
                }
            }        
        }


        public static void retirarInteiros(FilaInt fila){
            ArrayList<Integer> lista = new ArrayList<>();
            ArrayList<Integer> lista2 = new ArrayList<>();

            while (!fila.isEmpty()) {
                lista.add(fila.dequeue());
            }

            for (Integer integer : lista) {
                if (!lista2.contains(integer)){
                    lista2.add(integer);
                }
            }

            for (Integer integer : lista2) {
                fila.enqueue(integer);
            }
        }

        public static void mostrarFila(FilaInt fila){
            ArrayList<Integer> lista = new ArrayList<>();

            while (!fila.isEmpty()) {
                lista.add(fila.dequeue());
            }
            
            System.out.println("Os valores da fila são: ");

            for (Integer integer : lista) {
                System.out.println(integer);
            }

            for (Integer integer : lista) {
                fila.enqueue(integer);
            }
        }
    }
