package PdLdP;

public class atividade1 {
    public static void main(String[] args) {
        System.out.println(somaSerieAlternada(3));
    }
    public static double somaFracaoPotenciaDeDois(int n) {
        if (n == 0) return 0;
        return 1.0 / Math.pow(2, n) + somaFracaoPotenciaDeDois(n - 1);
    }
    public static double somaSerieAlternada(int n) {
        if (n==0) return 0; 
        
        int it = 1;      
        float contador = 2 + ((it-2) *3);
        float resultado = 0;

        for (int i = 1; i <= n; i++){
            if (i == 1 ){
                resultado ++;               
            } else {
                if (i%2 == 0){
                    resultado -= 1.0/contador;
                } else {
                    resultado +=1.0/contador;   
                }
            }
            it++;
        }
        return resultado;        
    }

    public static int somaQuadrados(int n) {
        if (n == 1) return 1;
        return n * n + somaQuadrados(n - 1);
    }
            
}
