package PdLdP;

public class atividade1 {
    public static void main(String[] args) {
        System.out.println(somaSerieAlternada(4));
    }
    public static double somaFracaoPotenciaDeDois(int n) {
        if (n == 0) return 0;
        return 1.0 / Math.pow(2, n) + somaFracaoPotenciaDeDois(n - 1);
    }
    public static double somaSerieAlternada(int n) {
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

    public static int somaQuadrados(int n) {
        if (n == 1) return 1;
        return n * n + somaQuadrados(n - 1);
    }
            
}
