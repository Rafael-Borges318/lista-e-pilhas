import java.util.LinkedList;
import java.util.Queue;

class Documento {
    String nome;
    int paginas;

    public Documento(String nome, int paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }
}

public class Exercicio5 {
    public static void main(String[] args) {
        Queue<Documento> fila = new LinkedList<>();

        fila.add(new Documento("Trabalho.pdf", 10));
        fila.add(new Documento("Relatorio.docx", 5));
        fila.add(new Documento("Livro.pdf", 20));
        fila.add(new Documento("Lista.txt", 2));

        int totalPaginas = 0;
        int contador = 0;
        Documento maior = null;

        for (Documento d : fila) {
            if (maior == null || d.paginas > maior.paginas) {
                maior = d;
            }
        }

        while (!fila.isEmpty()) {
            Documento doc = fila.poll();
            System.out.println("Imprimindo: " + doc.nome + " - " + doc.paginas + " páginas");

            totalPaginas += doc.paginas;
            contador++;

            if (contador % 2 == 0 && !fila.isEmpty()) {
                Documento prox = fila.peek();
                System.out.println("Próximo documento: " + prox.nome + " - " + prox.paginas + " páginas");
            }
        }

        System.out.println("\nDocumento com maior número de páginas: " + maior.nome + " - " + maior.paginas + " páginas");
        System.out.println("Total de páginas impressas: " + totalPaginas);
    }
}