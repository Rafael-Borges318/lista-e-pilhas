public class Fila {
    private static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public Fila() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void enqueue(int valor) {
        No novo = new No(valor);
        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
        tamanho++;
    }

    public int dequeue() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia.");
        }
        int valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return valor;
    }

    public int peek() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia.");
        }
        return inicio.valor;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Primeiro: " + fila.peek());
        System.out.println("Tamanho: " + fila.tamanho());

        System.out.println("Removido: " + fila.dequeue());
        System.out.println("Removido: " + fila.dequeue());

        System.out.println("Primeiro: " + fila.peek());
        System.out.println("Esta vazia: " + fila.estaVazia());

        System.out.println("Removido: " + fila.dequeue());
        System.out.println("Esta vazia: " + fila.estaVazia());
    }
}
