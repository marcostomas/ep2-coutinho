public class InsertionSort implements IAlgoritmo {
    private IOrdenacao tipoOrdem;

    public InsertionSort(IOrdenacao tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public void ordena(int ini, int fim, ProdutoCompleto pCompleto) {
        for (int i = ini; i <= fim; i++) {
            ProdutoPadrao x = pCompleto.produtos.get(i);
            Formatacao y = pCompleto.formatos.get(i);

            int j = (i - 1);

            while (j >= ini) {
                tipoOrdem.ordena(pCompleto, i, j);
                j--;
            }
            pCompleto.set(j + 1, x, y);
        }
    }
}
