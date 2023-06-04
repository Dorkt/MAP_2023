package main.java.Comprador;

public class CompradorCrud {

    private Utils utils;

    public CompradorCRUD() {
        this.utils = new Utils();
    }

    public void criarComprador(String nome, String email, String senha, String cpf, String endereco) {
        Comprador comprador = new Comprador(nome, email, senha, cpf, endereco);
        utils.insertData(comprador);
        System.out.println("Comprador criado com sucesso");
    }

    public List<Comprador> lerComprador() {
        return utils.readData("Comprador");
    }

    public void atualizarComprador(int id, String novoNome) {
        utils.updateData("Comprador", id, novoNome);
        System.out.println("Comprador atualizado com sucesso");
    }

    public void removerComprador(int id) {
        utils.deleteData(id, "Comprador");
        System.out.println("Comprador removido com sucesso");
    }

}