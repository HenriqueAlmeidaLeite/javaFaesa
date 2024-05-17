package EdD.U2;

import EdD.U2.Item;
import EdD.U2.LCItem;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        System.out.println("\n\nSeja bem-vindo!\n\nO que voce deseja fazer?");
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        LCItem lista = new LCItem();

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
        switch (opção) {
            case 1:
                int codigo = adicionarCódigo();
                String nome = adicionarNome();
                int posição = adicionarPosição();
                Item item = new Item(codigo, nome);  
                lista.insere(item, posição);
                break;
            
            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:
            System.out.println();
            terminarPrograma();
                return;

            default:
            System.out.println("Opção inválida");
            menu();
                break;
        }


        scanner.close();
    }

    public static int adicionarCódigo(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código que você quer adicionar: ");
        int cod = scanner.nextInt();
        scanner.close();
        return cod;
    }

    public static String adicionarNome(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do item que você quer adicionar: ");
        String nome = scanner.nextLine();
        scanner.close();
        return nome;
    }

    public static int adicionarPosição(){
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a posição em que você quer adicionar esse item: ");
        int posição = scanner.nextInt();
        scanner.close();
        return posição;
    }

    public static void terminarPrograma(){
        System.out.println();
        System.out.println("Obrigado por usar meu programa!\n\n");
    }

}
