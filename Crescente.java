public class Crescente implements IOrdenacao {
    private ICriterio ic;

    public Crescente(ICriterio ic) {
        this.ic = ic;
    }

    public void ordena(ProdutoCompleto pCompleto, int pos1, int pos2) {
        if (ic.compara(pCompleto.produtos.get(pos1), pCompleto.produtos.get(pos2)) > 0)
            pCompleto.avancaPosicao(pos1, pos2);
    }

    public int particiona(int ini, int fim, ProdutoCompleto pCompleto) {
        ProdutoPadrao x = pCompleto.produtos.get(ini);
        int i = (ini - 1);
        int j = (fim + 1);

        while (true) {

            if (ic instanceof Descricao) {
                do {
                    j--;
                    ic.getValor(x);
                } while (ic.getValor(pCompleto.produtos.get(j)).toString()
                        .compareToIgnoreCase(ic.getValor(x).toString()) > 0);

                do {
                    i++;
                } while (ic.getValor(pCompleto.produtos.get(i)).toString()
                        .compareToIgnoreCase(ic.getValor(x).toString()) < 0);

            } else {
                double z;
                double y;
                do {
                    j--;
                    z = Double.parseDouble(ic.getValor(pCompleto.produtos.get(j)).toString());
                    y = Double.parseDouble(ic.getValor(x).toString());
                } while (z > y);

                do {
                    i++;
                    z = Double.parseDouble(ic.getValor(pCompleto.produtos.get(i)).toString());
                    y = Double.parseDouble(ic.getValor(x).toString());
                } while (z < y);
            }

            if (i < j) {
                pCompleto.trocaPosicao(i, j);
            } else
                return j;
        }
    }
}
