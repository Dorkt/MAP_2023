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

    public List<Object> lerComprador() {
        return utils.readData("Comprador");
    }

}
