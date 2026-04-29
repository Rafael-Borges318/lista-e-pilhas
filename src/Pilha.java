public class Pilha {
    private static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No topo;
    private int tamanho;

    public Pilha() {
        topo = null;
        tamanho = 0;
    }

    public void push(int valor) {
        No novo = new No(valor);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    public int pop() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia.");
        }
        int valor = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    public int peek() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia.");
        }
        return topo.valor;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo: " + pilha.peek());
        System.out.println("Tamanho: " + pilha.tamanho());

        System.out.println("Removido: " + pilha.pop());
        System.out.println("Removido: " + pilha.pop());

        System.out.println("Topo: " + pilha.peek());
        System.out.println("Esta vazia: " + pilha.estaVazia());

        System.out.println("Removido: " + pilha.pop());
        System.out.println("Esta vazia: " + pilha.estaVazia());
    }
}
