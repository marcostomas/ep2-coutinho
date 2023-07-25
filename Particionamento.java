import java.util.*;

public class Particionamento {
    public static <T> int particiona(int ini, int fim, List<ProdutoPadrao> produtos, String criterio) {

        Produto x = produtos.get(ini);
        int i = (ini - 1);
        int j = (fim + 1);

        while (true) {

            if (criterio.equals(GeradorDeRelatorios.CRIT_DESC_CRESC)) {

                do {
                    j--;

                } while (produtos.get(j).getDescricao().compareToIgnoreCase(x.getDescricao()) > 0);

                do {
                    i++;

                } while (produtos.get(i).getDescricao().compareToIgnoreCase(x.getDescricao()) < 0);
            } else if (criterio.equals(GeradorDeRelatorios.CRIT_PRECO_CRESC)) {

                do {
                    j--;

                } while (produtos.get(j).getPreco() > x.getPreco());

                do {
                    i++;

                } while (produtos.get(i).getPreco() < x.getPreco());
            }

            else if (criterio.equals(GeradorDeRelatorios.CRIT_ESTOQUE_CRESC)) {

                do {
                    j--;

                } while (produtos.get(j).getQtdEstoque() > x.getQtdEstoque());

                do {
                    i++;

                } while (produtos.get(i).getQtdEstoque() < x.getQtdEstoque());

            } else {

                throw new RuntimeException("Criterio invalido!");
            }

            if (i < j) {
                ProdutoPadrao temp = produtos.get(i);
                produtos.set(i, produtos.get(j));
                produtos.set(j, temp);
            } else
                return j;
        }
    }
}
