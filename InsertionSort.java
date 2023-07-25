import java.util.List;
import java.util.Map;

public class InsertionSort {
    private IOrdenacao tipoOrdem;

    public InsertionSort(IOrdenacao tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public <T> void order(int ini, int fim, ProdutoCompleto pCompleto) {
        for (int i = ini; i <= fim; i++) {
            ProdutoPadrao x = pCompleto.produtos.get(i);
            int j = (i - 1);
            while (j >= ini) {
                tipoOrdem.troca(pCompleto, i, j);
                j--;
            }
        }
    }
}
