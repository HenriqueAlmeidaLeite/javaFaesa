package EdD.U2.exercicios;

import EdD.U2.bases.Item;
import EdD.U2.bases.PilhaItem;

public class PFex3 {
    public static void main(String[] args) {
        
    }

    public static boolean saoIguais(PilhaItem pilha1, PilhaItem pilha2){
        boolean teste = true;
        PilhaItem pilha1Auxiliar = new PilhaItem();
        PilhaItem pilha2Auxiliar = new PilhaItem();

        if (pilha1.sized() != pilha2.sized()) {
            teste = false;
            return teste;
        }

        while (!pilha1.isEmpty()) {
            if (pilha1.getTop() != pilha2.getTop()) {
                teste = false;           
            }

            Item item1 = new Item(pilha1.pop().getItem().getCodigo(), pilha1.pop().getItem().getNome());
            pilha1Auxiliar.push(item1);

            Item item2 = new Item(pilha2.pop().getItem().getCodigo(), pilha2.pop().getItem().getNome());
            pilha2Auxiliar.push(item2);
        }

        while (!pilha1Auxiliar.isEmpty()) {
            Item item1 = new Item(pilha1Auxiliar.pop().getItem().getCodigo(), pilha1Auxiliar.pop().getItem().getNome());
            pilha1.push(item1);

            Item item2 = new Item(pilha2Auxiliar.pop().getItem().getCodigo(), pilha2Auxiliar.pop().getItem().getNome());
            pilha2.push(item2);
        }

        return teste;
    }
}
