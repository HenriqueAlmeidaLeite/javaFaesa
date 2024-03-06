package exercicios;
import java.util.Scanner;
public class ex1 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[10];
        int cont = 0;
        while(cont < 10){
            System.out.println("Digite um número inteiro: ");
            vetor[cont] = scanner.nextInt(); 
            cont++;
        }
        System.out.println("Os números digitados foram:");
        for (int c:vetor){
            System.out.println(c);
        }
        scanner.close();
    }
    
}