import java.util.Scanner;
import java.util.Stack;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a expressão: ");
        String expr = sc.nextLine();

        Stack<Character> pilha = new Stack<>();
        boolean balanceado = true;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.isEmpty()) {
                    balanceado = false;
                    break;
                }

                char topo = pilha.pop();

                if ((c == ')' && topo != '(') ||
                        (c == ']' && topo != '[') ||
                        (c == '}' && topo != '{')) {
                    balanceado = false;
                    break;
                }
            }
        }

        if (!pilha.isEmpty()) {
            balanceado = false;
        }

        if (balanceado) {
            System.out.println("Balanceado");
        } else {
            System.out.println("Não balanceado");
        }

        sc.close();
    }
}