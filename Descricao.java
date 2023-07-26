public class Descricao implements ICriterio {
    public int compara(ProdutoPadrao pUm, ProdutoPadrao pDois) {
        return pUm.getDescricao().compareTo(pDois.getDescricao());
    }

    public Object getValor(ProdutoPadrao i) {
        return i.getDescricao();
    }
}