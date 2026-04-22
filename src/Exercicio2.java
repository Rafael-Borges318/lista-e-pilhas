import java.util.Scanner;
import java.util.Stack;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String texto = sc.nextLine();

        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < texto.length(); i++) {
            pilha.push(texto.charAt(i));
        }

        String invertida = "";
        while (!pilha.isEmpty()) {
            invertida += pilha.pop();
        }

        if (texto.equals(invertida)) {
            System.out.println("É palíndromo.");
        } else {
            System.out.println("Não é palíndromo.");
        }

        sc.close();
    }
}