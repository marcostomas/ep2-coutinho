import java.util.List;

public interface FilteringStrategy {
    List<ProdutoPadrao> filter(List<ProdutoPadrao> produtos, String filtro, String argFiltro);
}
