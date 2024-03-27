package EdD;
import java.util.Scanner;

public class ex1_unidade1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] nomes = new String[5];
        float [] medias = new float[5];
        int [] faltas =  new int[5];
        int cont = 0;
        int cont2 = 0;
        float mm = 0;
        String ma = "";

        while (cont < 5) {
            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.println();

            System.out.println("Digite sua média: ");
            float media = scanner.nextFloat();
            scanner.nextLine();
            System.out.println();

            System.out.println("Digite o seu número de faltas: ");
            int falta = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            nomes[cont] = nome;
            medias[cont] = media;
            faltas[cont] = falta;
            cont++;
        }

        while (cont2 < 5) {
            if(medias[cont2] >= 5 ){
                if (faltas[cont2] < 20) {
                    System.out.println("O aluno " + nomes[cont2] + " foi aprovado");
                    System.out.println();
                }else{
                    System.out.println("O aluno " + nomes[cont2] + " foi reprovado por faltar de mais");
                    System.out.println();
                }
            }else{
                System.out.println("O aluno " + nomes[cont2] + " foi reprovado por ter notas baixas de mais");
                System.out.println();
            }

            if (medias[cont2] > mm) {
                mm = medias[cont2];
                ma = nomes[cont2];
            }

            cont2++;
        }
        System.out.println("O aluno que obteve a maior nota foi "+ ma);
        scanner.close();
    }
}
