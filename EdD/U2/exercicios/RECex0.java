package EdD.U2.exercicios;

import java.util.Scanner;

public class RECex0 {
    public static void main(String[] args) {
        menuCaracter();
    }

    public static void menuSomaPositivos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Digite o número que você quer saber a soma de todos os anteriores: ");
        int ultimo = scanner.nextInt();
        System.out.println();
        System.out.println("A soma de todos o valores anteriores ao que você digitou foi " + somaPositivos(ultimo));
        scanner.close();
    }


    public static int somaPositivos(int numeroFinal){
        if (numeroFinal == 0) {
            return 0;
        }
        return numeroFinal + somaPositivos(numeroFinal - 1);
    }

    public static void menuCaracter(){
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Digite o que você quiser: ");
        String str = scanner.nextLine();

        System.out.println();
        System.out.println("Digite o caracter que você quer saber se está presente ou não: ");
        char ch = scanner.next().charAt(0);

        boolean seraQueEh = ehOuNaoEh(str, ch);

        if (seraQueEh == true) {
            System.out.println("O caracter que você digitou está presente na String");
        } else {
            System.out.println("O caracter que você digitou não está presente na String");
        }
    }

    public static boolean ehOuNaoEh(String str, char ch){
        if (str.length() > 0) {
            return roubando(str, ch, 0);
        } else {
            return false;
        }
    }

    public static boolean roubando(String str, char ch, int i) {
        if (i >= str.length()) {
            return false;  // Condição de parada: índice fora do comprimento da string
        } else if (ch == str.charAt(i)) {
            return true;  // Condição de sucesso: caractere encontrado
        } else {
            return roubando(str, ch, i + 1);  // Chamada recursiva: verifica o próximo caractere
        }
    }

}
