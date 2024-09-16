package LPOO;

import java.util.Scanner;

public class pilhaExB {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    PilhaInt pilha = new PilhaInt();

    System.out.println();
    System.out.println("Seja bem-vindo!");
    System.out.println();

    entradaDeValores(pilha);
    desempilhar(pilha);
    
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


    public static void desempilhar(PilhaInt pilha){
        System.out.println();
        System.out.println("Valores desempilhados: ");
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }

    }
}
