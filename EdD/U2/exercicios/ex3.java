package EdD.U2.exercicios;

import java.util.Scanner;

import EdD.U2.bases.Item;
import EdD.U2.bases.LSEItem;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LSEItem lista = new LSEItem();
        int valor = 1;
        double total = 0;
        double repetições = 0;

        while (valor != 0) {
            System.out.println();
            System.out.println("Digite o valor que você quer adicionar. Se não quiser adicionar nenhum, digite 0:");
            valor = scanner.nextInt();
            if (valor != 0) {
                total += valor;
                repetições++;
                preencher(lista, valor);
            }
        }

        double med = media(total, repetições);

        Imprimir(lista, med);
        scanner.close();
    }

    public static void preencher(LSEItem lista, int valor){
        Item item = new Item(valor, "");
        lista.insereFinal(item);
    }

    public static double media(double total, double repetições){
        if (total == 0) {
            System.out.println("Nenhum valor adicionado.");
            return 0;
        }
        double media = total/repetições;
        return media;
    }

    public static void Imprimir(LSEItem lista, double media){
        System.out.println();
        System.out.println(lista.toString());
        System.out.println();
        System.out.println();
        System.out.println("A média dos valores digitados foi " + media);
        System.out.println();
        System.out.println();
    }
}
