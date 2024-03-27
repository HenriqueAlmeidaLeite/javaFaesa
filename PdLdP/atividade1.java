package PdLdP;

public class atividade1 {
    public static void main(String[] args) {
        System.out.println(somaSerieAlternada(0));
    }
    public static double somaFracaoPotenciaDeDois(int n) {
        if (n == 0) return 0;
        return 1.0 / Math.pow(2, n) + somaFracaoPotenciaDeDois(n - 1);
    }
    public static double somaSerieAlternada(int n) {
        if (n == 0) return 0;
        int numero_divisao = 2 + n*3;
        float soma = 0;
        for (int i = 1; i <= n; i++){
            
        }
        
    }

    public static int somaQuadrados(int n) {
        if (n == 1) return 1;
        return n * n + somaQuadrados(n - 1);
    }
            
}
