package LPOO;

import java.util.ArrayList;
import java.util.Scanner;

public class unidade2_ex7 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PilhaInt pilha = new PilhaInt();

        System.out.println();
        System.out.println("Seja bem-vindo!");
        System.out.println();

        entradaDeValores(pilha);
        retirarInteiros(pilha);
        mostrarPilha(pilha);
        
        System.out.println();
        System.out.println("Fim do programa.");
        scanner.close();
        }


        public static void entradaDeValores(PilhaInt pilha){       
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
                    pilha.push(esc);
                }
            }        
        }


        public static void retirarInteiros(PilhaInt pilha){
            ArrayList<Integer> lista = new ArrayList<>();
            ArrayList<Integer> lista2 = new ArrayList<>();

            while (!pilha.isEmpty()) {
                lista.add(pilha.pop());
            }

            for (Integer integer : lista) {
                if (!lista2.contains(integer)){
                    lista2.add(integer);
                }
            }

            for (Integer integer : lista2) {      //isso aqui deve dar errado
                pilha.push(integer);
            }
        }

        public static void mostrarPilha(PilhaInt pilha){
            ArrayList<Integer> lista = new ArrayList<>();

            while (!pilha.isEmpty()) {
                lista.add(pilha.pop());
            }
            
            System.out.println("Os valores da pilha são: ");

            for (Integer integer : lista) {
                System.out.println(integer);
            }

            for (Integer integer : lista) {
                pilha.push(integer);
            }
        }
}
