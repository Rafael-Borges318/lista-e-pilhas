import java.util.LinkedList;
import java.util.Queue;

class Cliente {
    String nome;
    int tempo;

    public Cliente(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }
}

public class Exercicio4 {
    public static void main(String[] args) {
        Queue<Cliente> fila = new LinkedList<>();

        fila.add(new Cliente("Ana", 5));
        fila.add(new Cliente("Pedro", 3));
        fila.add(new Cliente("João", 8));

        int totalTempo = 0;
        int totalClientes = 0;

        while (!fila.isEmpty()) {
            Cliente c = fila.poll();
            System.out.println("Atendendo: " + c.nome + " - Tempo: " + c.tempo + " minutos");
            totalTempo += c.tempo;
            totalClientes++;
        }

        System.out.println("\nTotal de tempo gasto: " + totalTempo + " minutos");
        System.out.println("Total de clientes atendidos: " + totalClientes);
    }
}