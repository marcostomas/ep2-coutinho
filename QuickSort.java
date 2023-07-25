import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    // public <K, V> void order(int ini, int fim, List<ProdutoPadrao> produtos,
    // String criterio) {
    // if (ini < fim) {
    // int q = Particionamento.particiona(ini, fim, produtos, criterio);
    // order(ini, q, produtos, criterio);
    // order(q + 1, fim, produtos, criterio);
    // }
    // }

    public QuickSort() {

    }

    public <K, V> void ordena(Map<K, V> produtos, int ini, int fim) {
        List<K> produtosArr = new ArrayList<>();

        if (ini < fim) {

            produtos.
            int q = Particionamento.particiona(ini, fim, produtos, criterio);
            ordena(produtos, ini, q);
            ordena(produtos, q + 1, fim);
        }
    }

}