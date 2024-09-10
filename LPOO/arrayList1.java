package LPOO;
import java.util.Scanner;
import java.util.ArrayList;

public class arrayList1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean teste = true;
        ArrayList<Integer> vetor = new ArrayList<>();

        while (teste ==  true){
            System.out.println();
            System.out.println("What integer number do you want to add?");
            int number = scanner.nextInt();
            if (number == 0) {
                System.out.println();
                System.out.println();
                System.out.println("The numbers that you input was:");
                for (Integer integer : vetor) {
                    System.out.println(integer);
                }

                for (int i = vetor.size() - 1; i >= 0; i--) {
                    if (vetor.get(i) % 2 == 0) {
                        vetor.remove(i);
                    }
                }

                System.out.println();
                System.out.println();
                System.out.println("The follow numbers are odd:");
                for (Integer integer : vetor) {
                    System.out.println(integer);
                }

                System.out.println("Thank you for use my program!");
                teste = false;

            } else {
                vetor.add(number);
            }
        }
        scanner.close();
    }
}
