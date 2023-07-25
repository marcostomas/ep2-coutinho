import java.util.*;

public class EstoqueQtdFilterStrategy implements FilteringStrategy {

    public List<ProdutoPadrao> filter(List<ProdutoPadrao> produtos, String filtro, String argFiltro) {
        int maxStock;
        List<ProdutoPadrao> filteredList = new ArrayList<>();

        try {
            maxStock = Integer.parseInt(argFiltro);
            for (ProdutoPadrao p : produtos) {
                if (p.getQtdEstoque() <= maxStock) {
                    filteredList.add(p);
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }

        return filteredList;
    }
}