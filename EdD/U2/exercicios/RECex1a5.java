package EdD.U2.exercicios;

public class RECex1a5 {
    public static void main(String[] args) {       
        somaDosDigitos(2024);
    }



    public static void contagemRegressiva(int num){
        if (num < 0) {
            return;
        } else {
            System.out.println();
            System.out.println(num);
            contagemRegressiva(num -1);
        }
    }



    public static void somaNoVetor(int [] vetor, int contador, int soma){
        if (contador >= vetor.length) {
            System.out.println();
            System.out.println();
            System.out.println("A soma dos valores no vetor é "+ soma);
            System.out.println();
            System.out.println();
            return;
        } else {
            soma += vetor[contador];
            somaNoVetor(vetor, contador + 1, soma);
        }
    }



    public static void inverterString(String str, String strInvertida, int tamanho){
        tamanho--;
        if (tamanho < 0) {
            System.out.println();
            System.out.println();
            System.out.println("A String invertida é: " + strInvertida);
            System.out.println();
            System.out.println();
        } else {
            strInvertida += str.charAt(tamanho);
            inverterString(str, strInvertida, tamanho);
        }
    }



    public static void potencia(int numero, int elevado ){
        int copiaNumero = numero;
        int copiaElevado = elevado;
        valores(numero, elevado, copiaNumero, copiaElevado);
    }



    public static void valores(int numero, int elevado, int copiaNumero, int copiaElevado){
        if (elevado == 1) {
            System.out.println();
            System.out.println();
            System.out.println(copiaNumero + " elevado a " + copiaElevado + " é igual a " + numero);
            System.out.println();
            System.out.println();
        } else {
            numero *= copiaNumero;
            elevado--;
            valores(numero, elevado, copiaNumero, copiaElevado);
        }
    }



    public static void somaDosDigitos(int numero){
        String str = String.valueOf(numero);
        int tamanho = str.length();
        int total = 0;

        digitos(str, tamanho, total);       
    }



    public static void digitos(String str, int tamanho, int total){
        tamanho--;
        if (tamanho < 0 ) {
            System.out.println();
            System.out.println();
            System.out.println("A soma de todos os digitos de "+ str + " é " + total);            
            System.out.println();
            System.out.println();

        } else {
        String umaString = "";
        umaString += str.charAt(tamanho);
        int numero = Integer.parseInt(umaString);
        total += numero;

        digitos(str, tamanho, total);
        }
    }
}
