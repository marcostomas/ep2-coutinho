import java.util.*;

public class CategoryFilterStrategy implements FilteringStrategy {

    public List<ProdutoPadrao> filter(List<ProdutoPadrao> produtos, String filtro, String argFiltro) {

        String targetCategory = argFiltro.toLowerCase();
        List<ProdutoPadrao> filteredList = new ArrayList<>();

        for (ProdutoPadrao p : produtos) {
            if (p.getCategoria().toLowerCase().equals(targetCategory)) {
                filteredList.add(p);
            }
        }
        return filteredList;
    }

}