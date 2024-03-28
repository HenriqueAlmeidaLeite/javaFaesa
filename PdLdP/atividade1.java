package PdLdP;

public class atividade1 {
    public static void main(String[] args) {
        System.out.println(somaDeDivisoesPorDois(0));
        System.out.println(somaAlternada(0));
        System.out.println(somaQueVaiAumentandoDois(0));
    }

    public static double somaDeDivisoesPorDois(int n) {
        if (n == 0) return 0;

        double total = 0;
        double contador = 2;

        for (int i = 1; i <= n; i++){
            total += 1/contador;
            contador*=2;
        }

        return total;
    }

    public static double somaAlternada(int n) {
        if (n == 0) return 0;
        
        double resultado = 1;
        int sinal = -1;
        
        for (int i = 2; i <= n; i++) {
            double contador = 2 + (i - 2) * 3.0; 
            resultado += sinal * (1.0 / contador); 
            sinal *= -1; 
        }
        
        return resultado;
    }

    public static int somaQueVaiAumentandoDois(int n) {
        if (n== 0) return 0;
        if (n == 1) return 1;

        int total = 1;
        int contador = 3;

        for (int i = 2; i <= n; i++){
            total += contador;
            contador += 2;
        }

        return total;
    }
            
}
