package LPOO;

import java.util.Scanner;
import java.util.ArrayList;

public class Cinema{ 
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Sessão> Sessões = new ArrayList<>();
    public static void main(String[] args) {
        int cont = 0;

        System.out.println();
        System.out.println("Seja bem-vindo!");

        while(true){
            System.out.println();
            System.out.println("O que você quer fazer?");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Vender ");
            System.out.println("3 - Sair");
            System.out.println();
            int esc = scanner.nextInt();

            switch (esc) {
                case 1:
                    cadastrar();
                    cont++;
                    break;
                
                case 2:
                    vender(cont);
                    break;
                
                case 3:
                    System.out.println();
                    System.out.println("Obrigado por usar nosso programa! Volte sempre!");
                    System.out.println();
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

    public static void cadastrar(){
        scanner.nextLine();
        for (int i = 0; i<=4; i++){
            Sessão sessão1 = new Sessão();

            System.out.println();
            System.out.println();
            System.out.println("Cadastro da sessão "+ (i+1));
            System.out.println();

            System.out.println("Digite o nome do filme: ");
            sessão1.nomeFilme = scanner.nextLine();
            System.out.println();

            System.out.println("Digite o horário do filme: ");
            sessão1.horario = scanner.nextLine();
            

            Sessões.add(sessão1);
        }
        System.out.println();
        System.out.println();
        System.out.println("Concluído com sucesso!");
        System.out.println();
        System.out.println();
    }

    public static void vender(int cont){
        if (cont == 0) {
            System.out.println();
            System.out.println("Você precisar fazer cadastros antes de vender ingressos.");
            return;
        }
        System.out.println();
        for (int i=0; i<=Sessões.size()-1; i++){
            System.out.println("Filme " + (i+1) + ": " + Sessões.get(i).getNomeFilme());
            System.out.println("Horário: " + Sessões.get(i).getHorario() + "horas");
            System.out.println();
        }

        System.out.println("Escolha o número de um dos filmes: ");
        int esc = scanner.nextInt()-1;

        System.out.println();
        Sessões.get(esc).assento1.mostrarLugares();

        System.out.println();
        System.out.println("Diga o número da fila que você quer sentar: ");
        int fila = scanner.nextInt();

        System.out.println();
        System.out.println("Diga o número do assento que você quer: ");
        int cadeira = scanner.nextInt();

        boolean val = Sessões.get(esc).venda(fila, cadeira);
        if (val == true) {
            System.out.println();
            System.out.println("Assento escolhido com sucesso!");
        } else {
            System.out.println();
            System.out.println("Esse assento já foi escolhido por outra pessoa. ");
        }
    }

}
class Assento{
    boolean disponivel[][] = new boolean[5][4];

    public void mostrarLugares(){
        for (int i = 0; i <=4; i++){
            for (int b = 0; b <=3; b++){
                if (disponivel[i][b] == true) {
                    System.out.print("| X  ");
                } else {
                    System.out.print("|    ");
                }
                if (b == 3) {
                    System.out.print("|");
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

    Assento assento1 = new Assento();

    public boolean venda(int fila, int assento){
        if (assento1.disponivel[fila][assento] == true) {                
            return false;
        } else {
            assento1.disponivel[fila][assento] = true;
            return true;
        }
    }

    public String getNomeFilme(){
        return nomeFilme;
    }

    public String getHorario(){
        return horario;
    }
}
