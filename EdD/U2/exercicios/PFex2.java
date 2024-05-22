package EdD.U2.exercicios;

import java.util.Scanner;

import EdD.U2.bases.FilaItem;
import EdD.U2.bases.Item;

public class PFex2 {
    public static void main(String[] args) {
        FilaItem fila = new FilaItem();

        lereEnfileirar(fila);
        removerMaioresQue10(fila);

        System.out.println(fila.toString());
    }


    public static void lereEnfileirar(FilaItem fila){
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.println("Digite 10 números inteiros para preencher sua pilha: ");
        for (int i = 0; i < 10; i++){
            System.out.println();
            int valor = scanner.nextInt();

            Item item = new Item(valor, " ");
            fila.enqueue(item);

        }
        scanner.close();
    }


    public static void removerMaioresQue10(FilaItem fila){
        FilaItem filaAuxiliar = new FilaItem();

        while (!fila.isEmpty()) {
            Item item = fila.dequeue().getItem();
            if ( item.getCodigo() <= 10) {
                filaAuxiliar.enqueue(item);
            }
        }

        while (!filaAuxiliar.isEmpty()) {
            Item item = filaAuxiliar.dequeue().getItem();
            fila.enqueue(item);
        }
    }
}
