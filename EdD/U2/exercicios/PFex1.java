package EdD.U2.exercicios;

import EdD.U2.bases.*;
import java.util.Scanner;

public class PFex1 {
    public static void main(String[] args) {
        PilhaItem pilha = new PilhaItem();
        lereEmpilhar(pilha);
        removerMenoresQue10(pilha);
    }

    public static void lereEmpilhar(PilhaItem pilha){
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.println("Digite 10 números inteiros para preencher sua pilha: ");
        for (int i = 0; i < 10; i++){
            System.out.println();
            int valor = scanner.nextInt();

            Item item = new Item(valor, " ");
            pilha.push(item);

        }
        scanner.close();
    }

    public static void removerMenoresQue10(PilhaItem pilha){
        
    }
}
