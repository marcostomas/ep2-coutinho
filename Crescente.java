public class Crescente implements IOrdenacao {
    private ICriterio ic;

    public Crescente(ICriterio ic) {
        this.ic = ic;
    }

    public void troca(ProdutoCompleto pCompleto, int pos1, int pos2) {
        if (ic.compara(pCompleto.produtos.get(pos1),
                pCompleto.produtos.get(pos2)) > 0)
            pCompleto.trocaPosicao(pos1, pos2);
    }
}
