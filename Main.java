import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        if (args.length < 4) {

            System.out.println("Uso:");
            System.out.println("\tjava " + Main.class.getName()
                    + " <caminho do arquivo> <algoritmo> <criterio de ordenação> <criterio de filtragem> '<parametro de filtragem>' (utilizar aspas)");
            System.out.println("Onde:");
            System.out.println("\tcaminho para o arquivo: o caminho completo do arquivo-fonte no seu sistema");
            System.out.println("\talgoritmo: 'quick' ou 'insertion'");
            System.out.println(
                    "\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c' ou'preco_d' ou 'descricao_d' ou 'estoque_d'");
            System.out.println(
                    "\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou 'entre' ou 'substring'");
            System.out.println(
                    "\tparametro de filtragem: argumentos adicionais necessários para a filtragem. Para intervalo, usar a notação '10-15'");

            System.out.println();
            System.exit(1);
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
        IAlgoritmo algoritmo;
        IOrdenacao ordem;
        ICriterio criterio;

        if (args[2].contains("preco")) {
            criterio = new Preco();
        } else if (args[2].contains("estoque")) {
            criterio = new QuantidadeEstoque();
        } else {
            criterio = new Descricao();
        }

        if (args[2].contains("_c")) {
            ordem = new Crescente(criterio);
        } else {
            ordem = new Decrescente(criterio);
        }

        if (args[1] == "quick") {
            algoritmo = new QuickSort(ordem);
        } else {
            algoritmo = new InsertionSort(ordem);
        }

        algoritmo.ordena(0, produtos.produtos.size() - 1, produtos);

        gdr.gerarRelatorioOrdenado(produtos, "saida.html");
    }
}