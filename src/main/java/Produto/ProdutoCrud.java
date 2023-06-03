package main.java.Produto;
public class ProdutoCrud{


    private Utils utils;

    public ProdutoCRUD() {
        this.utils = new Utils();
    }

    public void criarProduto(String nome, double valor, int tipo, int quantidade, String marca, String descricao) {
        Produto produto = new Produto(nome, valor, tipo, quantidade, marca, descricao);
        utils.insertData(produto);
        System.out.println("Produto inserido com sucesso");
    }

    public List<Object> lerProdutos() {
        return utils.readData("Produto");
    }

}