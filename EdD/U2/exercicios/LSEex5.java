package EdD.U2.exercicios;

import java.util.Scanner;

import EdD.U2.bases.Item;
import EdD.U2.bases.LSEItem;
import EdD.U2.bases.NoItem;

public class LSEex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LSEItem lista = new LSEItem();
        int valor = 1;

        while (valor != 0) {
            System.out.println();
            System.out.println("Digite o valor que você quer adicionar. Se não quiser adicionar nenhum, digite 0:");
            valor = scanner.nextInt();
            if (valor != 0) {
                preencher(lista, valor);
            }
        }
        int val = valor();
        verificarMenoresQue(lista, val);
        scanner.close();
    }

    public static void verificarMenoresQue(LSEItem lista, int valor) {
        NoItem atual = lista.getPrim();  // Usando o método getPrim() para obter o primeiro nó
        System.out.println();
        System.out.println();
        System.out.println("Os valores menores que " + valor + " são: ");
        while (atual != null) {
            if (atual.getItem().getCodigo() < valor) {
                System.out.println(atual.getItem().getCodigo());
            }
            atual = atual.getProx();
        }
    }

    public static int valor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Digite o valor que você quer verificar quais são menores: ");
        int valor = scanner.nextInt();
        scanner.close();
        return valor;
    }


    public static void preencher(LSEItem lista, int valor){
        Item item = new Item(valor, "");
        lista.insereFinal(item);
    }
}
