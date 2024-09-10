package LPOO;

import java.util.Scanner;
import java.util.ArrayList;
public class Cinema{ 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Vender ");
            System.out.println("3 - Sair");
            System.out.println();
            int esc = scanner.nextInt();

            switch (esc) {
                case 1:
                    cadastrar();
                    break;
                
                case 2:
                    vender();
                    break;
                
                case 3:
                    System.out.println("Obrigado por usar nosso programa! Volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente outra vez.");
                    break;
            }

            if (esc == 3) {
                break;
            }
        }
        scanner.close();
    }

    static ArrayList<Sessão> Sessões = new ArrayList<>();
    public static void cadastrar(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i< Sessões.size(); i++){
            Sessão sessão1 = new Sessão();

            System.out.println();
            System.out.println("Cadastro da sessão "+ i);
            System.out.println();

            System.out.println("Digite o nome do filme: ");
            sessão1.nomeFilme = scanner.nextLine();

            System.out.println("Digite o horário do filme: ");
            sessão1.horario = scanner.nextLine();

            Sessões.add(sessão1);
        }
        scanner.close();


    }

    public static void vender(){

    }

    class Assento{
        static boolean disponivel[][] = new boolean[5][4];

        public void mostrarLugares(){
            for (int i = 0; i <=4; i++){
                for (int b = 0; b <=3; b++){
                    if (disponivel[i][b] == true) {
                        System.out.print(" | X | ");
                    } else {
                        System.out.print(" |   | ");
                    }
                }
                System.out.println();
            }
        }
    }

    class Sessão{
        String nomeFilme;
        String horario;
        static double preço = 50.00;

        public boolean venda(int fila, int assento){
            if (Assento.disponivel[fila][assento] == true) {                
                return false;
            } else {
                Assento.disponivel[fila][assento] = true;
                return true;
            }
        }
    }
}
