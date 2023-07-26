public class QuickSort implements IAlgoritmo {
    private IOrdenacao tipoOrdem;

    public QuickSort(IOrdenacao tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public void atribui(IOrdenacao tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public void ordena(int ini, int fim, ProdutoCompleto pCompleto) {

        if (ini < fim) {
            // int q = Particionamento.particiona(ini, fim, produtos, criterio);
            int q = tipoOrdem.particiona(ini, fim, pCompleto);
            ordena(ini, q, pCompleto);
            ordena(q + 1, fim, pCompleto);
        }
    }

}