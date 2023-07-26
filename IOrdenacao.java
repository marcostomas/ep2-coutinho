public interface IOrdenacao {
    public void ordena(ProdutoCompleto pCompleto, int pos1, int pos2);

    public int particiona(int ini, int fim, ProdutoCompleto pCompleto);

}