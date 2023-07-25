import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        if (args.length < 4) {

            System.out.println("Uso:");
            System.out.println("\tjava " + Main.class.getName()
                    + " <caminho do arquivo> <algoritmo> <critério de ordenação> <critério de filtragem> '<parâmetro de filtragem>' (utilizar aspas)");
            System.out.println("Onde:");
            System.out.println("\tcaminho para o arquivo: o caminho completo do arquivo-fonte no seu sistema");
            System.out.println("\talgoritmo: 'quick' ou 'insertion'");
            System.out.println(
                    "\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c' ou 'preco_d' ou 'descricao_d' ou 'estoque_d'");
            System.out.println(
                    "\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou 'entre' ou 'substring'");
            System.out.println(
                    "\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem. Para intervalo, usar a notação '10-15'");

            System.out.println();
            System.exit(1);
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println("Argumento {" + i + "}: " + args[i]);
        }

        CarregaProdutos cProdutos = new CarregaProdutos(args[0]);
        ProdutoCompleto produtos = cProdutos.carregarProdutos();
        GeradorDeRelatorios gdr = new GeradorDeRelatorios();

        // args[1] == 'quick' ou 'insertion'
        // args[2] == 'preco_c' ou 'descricao_c' ou 'estoque_c' ou 'preco_d' ou
        // 'descricao_d' ou 'estoque_d'
        // args[3] == 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou 'entre'
        // ou 'substring'
        // args[4] (opcional, depende do escolhido em args[3]) == '5' ou 'Livros' ou
        // '10-15' ou 'N-Gage'
        if (args[1] == "quick") {
        } else if (args[1] == "insertion") {
        }

        // GeradorDeRelatorios gdr = new GeradorDeRelatorios(produtos, args[1], args[2],
        // args[3], args[4], formato);

        // Map<ProdutoPadrao, Formatacao> produtosOrdenados =
        // cProdutos.carregarProdutos();

        gdr.gerarRelatorioOrdenado(produtos, "saida.html");
    }
}