public class ListaEncadeada<T> {
    Node<T> inicio;
    int tamanho;

    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }

    public void adicionarNoInicio(T valor) {
        Node<T> novo = new Node<>(valor);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    }

    public void adicionarNoFim(T valor) {
        Node<T> novo = new Node<>(valor);
        if (estaVazia()) {
            inicio = novo;
        } else {
            Node<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public void adicionarNaPosicao(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida.");
        }
        if (posicao == 0) {
            adicionarNoInicio(valor);
            return;
        }
        Node<T> novo = new Node<>(valor);
        Node<T> atual = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        tamanho++;
    }

    public T removerDoInicio() {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia.");
        }
        T valor = inicio.valor;
        inicio = inicio.proximo;
        tamanho--;
        return valor;
    }

    public T removerDoFim() {
        if (estaVazia()) {
            throw new RuntimeException("Lista vazia.");
        }
        if (tamanho == 1) {
            return removerDoInicio();
        }
        Node<T> atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        T valor = atual.proximo.valor;
        atual.proximo = null;
        tamanho--;
        return valor;
    }

    public T removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida.");
        }
        if (posicao == 0) {
            return removerDoInicio();
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
        T valor = atual.proximo.valor;
        atual.proximo = atual.proximo.proximo;
        tamanho--;
        return valor;
    }

    public boolean removerPorValor(T elemento) {
        if (estaVazia()) {
            return false;
        }
        if (inicio.valor.equals(elemento)) {
            removerDoInicio();
            return true;
        }
        Node<T> atual = inicio;
        while (atual.proximo != null) {
            if (atual.proximo.valor.equals(elemento)) {
                atual.proximo = atual.proximo.proximo;
                tamanho--;
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public T buscar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida.");
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public int buscarPosicao(T valor) {
        Node<T> atual = inicio;
        int posicao = 0;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        return -1;
    }

    public void atualizar(int posicao, T novoValor) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida.");
        }
        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        atual.valor = novoValor;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void limpar() {
        inicio = null;
        tamanho = 0;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("Lista vazia.");
            return;
        }
        Node<T> atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.proximo != null) {
                System.out.print(" -> ");
            }
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionarNoFim(10);
        lista.adicionarNoFim(20);
        lista.adicionarNoFim(30);
        lista.adicionarNoInicio(5);
        lista.adicionarNaPosicao(2, 15);

        lista.exibir();
        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println("Posicao 2: " + lista.buscar(2));
        System.out.println("Posicao de 20: " + lista.buscarPosicao(20));

        lista.atualizar(1, 99);
        lista.exibir();

        System.out.println("Removido do inicio: " + lista.removerDoInicio());
        System.out.println("Removido do fim: " + lista.removerDoFim());
        lista.exibir();

        lista.removerPorValor(15);
        lista.exibir();

        System.out.println("Removido da posicao 1: " + lista.removerDaPosicao(1));
        lista.exibir();

        lista.limpar();
        lista.exibir();
    }
}
