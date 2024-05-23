package EdD.U2.exercicios;

import EdD.U2.bases.FilaItem;
import EdD.U2.bases.Item;
import EdD.U2.bases.PilhaItem;

public class PFex3e4 {

    public static boolean saoPilhasIguais(PilhaItem pilha1, PilhaItem pilha2){
        PilhaItem pilha1Auxiliar = new PilhaItem();
        PilhaItem pilha2Auxiliar = new PilhaItem();

        if (pilha1.sized() != pilha2.sized()) {
            return false;
        }

        while (!pilha1.isEmpty()) {
            if (pilha1.getTop().getItem().getCodigo() != pilha2.getTop().getItem().getCodigo() || !pilha1.getTop().getItem().getNome().equals(pilha2.getTop().getItem().getNome())){
                return false;           
            }

            Item item1 = new Item(pilha1.getTop().getItem().getCodigo(), pilha1.getTop().getItem().getNome());
            Item item2 = new Item(pilha2.getTop().getItem().getCodigo(), pilha2.getTop().getItem().getNome());
            
            pilha1.pop();
            pilha2.pop();

            pilha1Auxiliar.push(item1);
            pilha2Auxiliar.push(item2);
        }

        while (!pilha1Auxiliar.isEmpty()) {
            pilha1.push(pilha1Auxiliar.pop().getItem());
            pilha2.push(pilha2Auxiliar.pop().getItem());
        }

        return true;
    }

    


    public static boolean saoFilasIguais(FilaItem fila1, FilaItem fila2){
        FilaItem fila1Auxiliar = new FilaItem();
        FilaItem fila2Auxiliar = new FilaItem();

        if (fila1.size() != fila2.size()) {
            return false;
        }

        while (!fila1.isEmpty()) {
            if (fila1.getHead().getItem().getCodigo() != fila2.getHead().getItem().getCodigo() || !fila1.getHead().getItem().getNome().equals(fila2.getHead().getItem().getNome())) {
                return false;
            }

            Item item1 = new Item(fila1.getHead().getItem().getCodigo(), fila1.getHead().getItem().getNome());
            Item item2 = new Item(fila2.getHead().getItem().getCodigo(), fila2.getHead().getItem().getNome());

            fila1.dequeue();
            fila2.dequeue();

            fila1Auxiliar.enqueue(item1);
            fila2Auxiliar.enqueue(item2);
        }

        while (!fila1Auxiliar.isEmpty()) {
            fila1.enqueue(fila1Auxiliar.dequeue().getItem());
            fila2.enqueue(fila2Auxiliar.dequeue().getItem());
        }

        return true;
    }


}
