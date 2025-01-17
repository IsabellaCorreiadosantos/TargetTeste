package tarefa1e2;

import java.util.Scanner;

public class Teste2Fibonacci {

	public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite um número: ");
        int numero = leia.nextInt();
        
        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }

    public static boolean isFibonacci(int n) {
        if (n < 0) {
            return false;
        }
        
        int a = 0, b = 1;
        
        while (a < n) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        
        return a == n;
    }
}