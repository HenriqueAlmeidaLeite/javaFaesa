package EdD.U2.exercicios;

import java.util.Scanner;

import EdD.U2.bases.Item;
import EdD.U2.bases.LCItem;

public class ex1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("\n\nSeja bem-vindo!\n\nO que voce deseja fazer?");
        menu();
    }

    public static void menu(){
        LCItem lista = new LCItem();
        boolean stop = true;

        while (stop == true) {
            System.out.println();
            System.out.println();
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Pesquisa");
            System.out.println("3 - Modificar o nome de um Item");
            System.out.println("4 - Remove o último Item da lista");
            System.out.println("5 - Remove um Item da lista");
            System.out.println("6 - Imprimir na tela todos os Itens da lista");
            System.out.println("7 - Terminar o programa");
            System.out.println();
            System.out.println("Digite o número do que voce quer fazer: ");

            int opção = scanner.nextInt();
            scanner.nextLine();

            switch (opção) {
                case 1:
                    int codigo = adicionarCódigo();
                    String nome = adicionarNome();
                    scanner.nextLine();
                    int posição = adicionarPosição();
                    Item item = new Item(codigo, nome);  
                    lista.insere(item, posição);
                    break;
                
                case 2:
                    System.out.println("Você quer saber a posição de qual código?");
                    int posi = lista.pesquisa(scanner.nextInt());
                    if (posi == -1) {
                        System.out.println("Não encontrei esse código");
                        break;
                    } else{
                        System.out.println("O item que você digitou está na posição " + posi);
                        break;
                    }

                case 3:
                    System.out.println("Digite o código do item que você quer modificar o nome: ");
                    int modifica = scanner.nextInt();
                    int posiçãoPraModificar = lista.pesquisa(modifica);
                    Item itemPraModificar = lista.getItem(posiçãoPraModificar);

                    System.out.println("Qual nome você quer dar para esse item?");
                    itemPraModificar.setNome(scanner.next());
                    break;

                case 4:
                    lista.removePos(lista.getQuant());
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Digite o código do elemento que você quer remover: ");
                    lista.remove(scanner.nextInt());
                    break;

                case 6:
                if (lista.toString() == "") {
                    System.out.println("Nenhum cadastro foi feito");
                    break;
                }
                System.out.println(lista.toString());
                break;

                case 7:
                System.out.println();
                terminarPrograma();
                scanner.close();
                    return;

                default:
                System.out.println();
                System.out.println("Opção inválida");
                menu();
                    break;
            }
        }
        
    }

    public static int adicionarCódigo(){
        System.out.println();       
        System.out.println("Digite o código que você quer adicionar: ");
        return scanner.nextInt();
    }

    public static String adicionarNome(){
        System.out.println();
        System.out.println("Digite o nome do item que você quer adicionar: ");    
        return scanner.nextLine();
    }

    public static int adicionarPosição(){
        System.out.println();
        System.out.println("Digite a posição em que você quer adicionar esse item: ");        
        return scanner.nextInt();
    }

    public static void terminarPrograma(){
        System.out.println();
        System.out.println("Obrigado por usar meu programa!\n\n");
        return;
    }

}
