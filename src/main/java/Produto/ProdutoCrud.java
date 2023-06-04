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

    public void atualizarProduto(int id, String novoNome) {
        utils.updateData("Produto", id, novoNome);
        System.out.println("Produto atualizado com sucesso");
    }

    public void deletarProduto(int id) {
        utils.deleteData(id, "Produto");
        System.out.println("Produto deletado com sucesso");
    }

}