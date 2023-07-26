import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // if (args.length < 4) {

        // System.out.println("Uso:");
        // System.out.println("\tjava " + Main.class.getName()
        // + " <caminho do arquivo> <algoritmo> <critério de ordenação> <critério de
        // filtragem> '<parâmetro de filtragem>' (utilizar aspas)");
        // System.out.println("Onde:");
        // System.out.println("\tcaminho para o arquivo: o caminho completo do
        // arquivo-fonte no seu sistema");
        // System.out.println("\talgoritmo: 'quick' ou 'insertion'");
        // System.out.println(
        // "\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c' ou
        // 'preco_d' ou 'descricao_d' ou 'estoque_d'");
        // System.out.println(
        // "\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou
        // 'categoria_igual' ou 'entre' ou 'substring'");
        // System.out.println(
        // "\tparâmetro de filtragem: argumentos adicionais necessários para a
        // filtragem. Para intervalo, usar a notação '10-15'");

        // System.out.println();
        // System.exit(1);
        // }

        String ava[] = new String[4];
        ava[0] = "/home/marcos/Desktop/ep2-coutinho/produtos.csv";
        ava[1] = "insertion";
        ava[2] = "descricao_c";
        ava[3] = "todos";

        CarregaProdutos cProdutos = new CarregaProdutos(ava[0]);
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

        if (ava[2].contains("preco")) {
            criterio = new Preco();
        } else if (ava[2].contains("estoque")) {
            criterio = new QuantidadeEstoque();
        } else {
            criterio = new Descricao();
        }

        if (ava[2].contains("_c")) {
            ordem = new Crescente(criterio);
        } else {
            ordem = new Decrescente(criterio);
        }

        if (ava[1] == "quick") {
            algoritmo = new QuickSort(ordem);
        } else {
            algoritmo = new InsertionSort(ordem);
        }

        algoritmo.ordena(0, produtos.produtos.size() - 1, produtos);

        gdr.gerarRelatorioOrdenado(produtos, "saida.html");
    }
}