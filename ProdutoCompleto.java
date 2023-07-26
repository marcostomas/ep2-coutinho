import java.util.ArrayList;

public class ProdutoCompleto {

    ArrayList<ProdutoPadrao> produtos = new ArrayList<>();
    ArrayList<Formatacao> formatos = new ArrayList<>();

    public void trocaPosicao(int posOrigem, int posDestino) {
        ProdutoPadrao auxP = produtos.get(posDestino);
        Formatacao auxF = formatos.get(posDestino);

        produtos.set(posDestino, produtos.get(posOrigem));
        produtos.set(posOrigem, auxP);

        formatos.set(posDestino, formatos.get(posOrigem));
        formatos.set(posOrigem, auxF);
    }

    public void adiciona(ProdutoPadrao produto, Formatacao formato) {
        produtos.add(produto);
        formatos.add(formato);
    }

    public void avancaPosicao(int posOrigem, int posDestino) {
        produtos.set(posDestino, produtos.get(posOrigem));
        formatos.set(posDestino, formatos.get(posOrigem));

    }

    public void set(int posDestino, ProdutoPadrao p, Formatacao f) {
        produtos.set(posDestino, p);
        formatos.set(posDestino, f);
    }
}
