class Node<T> {
    T valor;
    Node<T> proximo;

    Node(T valor) {
        this.valor = valor;
        this.proximo = null;
    }
}
