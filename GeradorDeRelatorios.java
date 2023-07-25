import java.io.PrintWriter;
import java.util.*;

public class GeradorDeRelatorios implements IGeradorDeRelatorios {

	// public static final String CRIT_DESC_CRESC = "descricao_c";
	// public static final String CRIT_PRECO_CRESC = "preco_c";
	// public static final String CRIT_ESTOQUE_CRESC = "estoque_c";
	// public static final String FILTRO_TODOS = "todos";
	// public static final String FILTRO_ESTOQUE_MENOR_OU_IQUAL_A =
	// "estoque_menor_igual";
	// public static final String FILTRO_CATEGORIA_IGUAL_A = "categoria_igual";
	// // operador bit a bit "ou" pode ser usado para combinar mais de
	// // um estilo de formatacao simultaneamente (veja como no main)
	// public static final int FORMATO_PADRAO = 0b0000;
	// public static final int FORMATO_NEGRITO = 0b0001;
	// public static final int FORMATO_ITALICO = 0b0010;
	// private String algoritmo, filtro, argFiltro;
	// private OrdenationStrategy order_method;

	public void debug(int total, String argFiltro) {

		System.out.println("Gerando relatório para array contendo " + total + " produto(s)");
		System.out.println("parametro filtro = '" + argFiltro + "'");
	}

	public void gerarRelatorioOrdenado(ProdutoCompleto pCompleto, String arquivoSaida) {
		debug(pCompleto.produtos.size(), "meu filtrinho");

		try (PrintWriter out = new PrintWriter(arquivoSaida)) {
			out.println("<!DOCTYPE html><html>");
			out.println("<head><title>Relatório de produtos</title></head>");
			out.println("<body>");
			out.println("Relatório de Produtos:");
			out.println("<ul>");

			int count = 0;
			Iterator<ProdutoPadrao> itP = pCompleto.produtos.iterator();
			Iterator<Formatacao> itF = pCompleto.formatos.iterator();

			while (itP.hasNext() && itF.hasNext()) {
				ProdutoPadrao proxP = itP.next();
				Formatacao proxF = itF.next();

				System.out.println("PRODUTO: " + proxP.formataParaImpressao());
				System.out.println("FORMATAÇÃO:  " + proxF.formataParaImpressao());

				out.print("<li>");
				if (proxF.getItalico() && proxF.getNegrito())
					out.print(
							"<span style=\"font-style:italic;font-weight:bold;color:" + proxF.getCor()
									+ "\">");

				else if (proxF.getItalico())
					out.print("<span style=\"font-style:italic;color:" + proxF.getCor() + "\">");

				else if (proxF.getNegrito())
					out.print("<span style=\"font-weight:bold;color:" + proxF.getCor() + "\">");
				else
					out.print("<span style=\"color: " + proxF.getCor() + "\">");

				out.print(proxP.formataParaImpressao());
				out.print("</span>");

				out.println("</li>");
				count++;
				System.out.println("Linhas geradas até agora: " + count);

				System.out.println("");
				System.out.println("");
				System.out.println("");

			}

			out.println("</ul>");
			out.println(count + " produtos listados, de um total de " + pCompleto.produtos.size() + ".");
			out.println("</body>");
			out.println("</html>");

			out.close();
		} catch (Exception e) {
			System.out.println("ERRRO NO ARQUIVO DE SAÍDA" + e.getMessage());
		}
	}
}
