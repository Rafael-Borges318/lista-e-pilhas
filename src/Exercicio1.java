import java.util.Scanner;
import java.util.Stack;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> par = new Stack<>();
        Stack<Integer> impar = new Stack<>();

        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o " + i + "º número: ");
            int num = sc.nextInt();

            if (num == 0) {
                if (par.isEmpty()) {
                    System.out.println("Erro: pilha par vazia.");
                } else {
                    System.out.println("Desempilhando da pilha par: " + par.pop());
                }

                if (impar.isEmpty()) {
                    System.out.println("Erro: pilha ímpar vazia.");
                } else {
                    System.out.println("Desempilhando da pilha ímpar: " + impar.pop());
                }
            } else if (num % 2 == 0) {
                par.push(num);
            } else {
                impar.push(num);
            }
        }

        System.out.println("\nElementos restantes na pilha par:");
        while (!par.isEmpty()) {
            System.out.println(par.pop());
        }

        System.out.println("\nElementos restantes na pilha ímpar:");
        while (!impar.isEmpty()) {
            System.out.println(impar.pop());
        }

        sc.close();
    }
}