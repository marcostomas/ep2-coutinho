public class Descricao implements ICriterio {
    public int compara(ProdutoPadrao pUm, ProdutoPadrao pDois) {
        return pUm.getDescricao().compareTo(pDois.getDescricao());
    }
}