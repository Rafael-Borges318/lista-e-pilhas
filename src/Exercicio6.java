public class Exercicio6 {
    static class FilaCircular {
        private int[] fila;
        private int inicio;
        private int fim;
        private int quantidade;

        public FilaCircular(int tamanho) {
            fila = new int[tamanho];
            inicio = 0;
            fim = 0;
            quantidade = 0;
        }

        public boolean estaCheia() {
            return quantidade == fila.length;
        }

        public boolean estaVazia() {
            return quantidade == 0;
        }

        public void enfileirar(int valor) {
            if (estaCheia()) {
                System.out.println("Fila cheia. Não é possível inserir " + valor);
                return;
            }

            fila[fim] = valor;
            fim = (fim + 1) % fila.length;
            quantidade++;
        }

        public int desenfileirar() {
            if (estaVazia()) {
                System.out.println("Fila vazia.");
                return -1;
            }

            int valor = fila[inicio];
            inicio = (inicio + 1) % fila.length;
            quantidade--;
            return valor;
        }

        public int espiar() {
            if (estaVazia()) {
                System.out.println("Fila vazia.");
                return -1;
            }

            return fila[inicio];
        }

        public void mostrar() {
            if (estaVazia()) {
                System.out.println("Fila vazia.");
                return;
            }

            System.out.print("Fila: ");
            for (int i = 0; i < quantidade; i++) {
                int indice = (inicio + i) % fila.length;
                System.out.print(fila[indice] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(5);

        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        fila.enfileirar(40);
        fila.enfileirar(50);

        fila.mostrar();

        System.out.println("Removido: " + fila.desenfileirar());
        System.out.println("Removido: " + fila.desenfileirar());

        fila.mostrar();

        fila.enfileirar(60);
        fila.enfileirar(70);

        fila.mostrar();

        System.out.println("Primeiro da fila: " + fila.espiar());
    }
}