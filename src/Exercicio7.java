public class Exercicio7 {
    static class Deque {
        private int[] dados;
        private int inicio;
        private int fim;
        private int quantidade;

        public Deque(int tamanho) {
            dados = new int[tamanho];
            inicio = 0;
            fim = -1;
            quantidade = 0;
        }

        public boolean estaVazio() {
            return quantidade == 0;
        }

        public boolean estaCheio() {
            return quantidade == dados.length;
        }

        public int tamanho() {
            return quantidade;
        }

        public void inserirNoInicio(int valor) {
            if (estaCheio()) {
                System.out.println("Deque cheio.");
                return;
            }

            inicio = (inicio - 1 + dados.length) % dados.length;
            dados[inicio] = valor;

            if (quantidade == 0) {
                fim = inicio;
            }

            quantidade++;
        }

        public void inserirNoFim(int valor) {
            if (estaCheio()) {
                System.out.println("Deque cheio.");
                return;
            }

            fim = (fim + 1) % dados.length;
            dados[fim] = valor;

            if (quantidade == 0) {
                inicio = fim;
            }

            quantidade++;
        }

        public int removerDoInicio() {
            if (estaVazio()) {
                System.out.println("Deque vazio.");
                return -1;
            }

            int valor = dados[inicio];
            inicio = (inicio + 1) % dados.length;
            quantidade--;

            return valor;
        }

        public int removerDoFim() {
            if (estaVazio()) {
                System.out.println("Deque vazio.");
                return -1;
            }

            int valor = dados[fim];
            fim = (fim - 1 + dados.length) % dados.length;
            quantidade--;

            return valor;
        }

        public int consultarInicio() {
            if (estaVazio()) {
                System.out.println("Deque vazio.");
                return -1;
            }

            return dados[inicio];
        }

        public int consultarFim() {
            if (estaVazio()) {
                System.out.println("Deque vazio.");
                return -1;
            }

            return dados[fim];
        }

        public void limpar() {
            inicio = 0;
            fim = -1;
            quantidade = 0;
        }

        public void mostrar() {
            if (estaVazio()) {
                System.out.println("Deque vazio.");
                return;
            }

            System.out.print("Deque: ");
            for (int i = 0; i < quantidade; i++) {
                int indice = (inicio + i) % dados.length;
                System.out.print(dados[indice] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.inserirNoFim(10);
        deque.inserirNoFim(20);
        deque.inserirNoInicio(5);
        deque.inserirNoInicio(1);

        deque.mostrar();

        System.out.println("Início: " + deque.consultarInicio());
        System.out.println("Fim: " + deque.consultarFim());

        System.out.println("Removido do início: " + deque.removerDoInicio());
        System.out.println("Removido do fim: " + deque.removerDoFim());

        deque.mostrar();

        System.out.println("Tamanho: " + deque.tamanho());

        deque.limpar();
        deque.mostrar();
    }
}