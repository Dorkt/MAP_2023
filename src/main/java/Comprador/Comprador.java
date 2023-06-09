package Comprador;
import java.util.ArrayList;
import java.util.List;

public class Comprador {
    private int id = 0;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String endereco;
    private List<String> carrinhoDeCompras;

    public Comprador(String nome, String email, String senha, String cpf, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.carrinhoDeCompras = new ArrayList<>();
    }

    // Adicionando construtor vazio para que a biblioteca que lê os dados persistidos conseguir converter os tipos para
    // o dessa classe
    public Comprador() {
        this.carrinhoDeCompras = new ArrayList<>();
    }

    // Getters e Setters

    public int getId() {
        return this.id;
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Adicionar um item ao carrinho de compras
    public void adicionarAoCarrinho(String item) {
        carrinhoDeCompras.add(item);
    }

    // Remover um item do carrinho de compras
    public void removerDoCarrinho(String item) {
        carrinhoDeCompras.remove(item);
    }

    public List<String> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    // Limpar o carrinho de compras
    public void limparCarrinho() {
        carrinhoDeCompras.clear();
    }

    // Exibir os itens no carrinho de compras
    public void exibirCarrinhoDeCompras() {
        System.out.println("Itens no Carrinho de Compras:");
        for (String item : carrinhoDeCompras) {
            System.out.println(item);
        }
    }

    // Método para exibir os dados do comprador
    public void exibirComprador() {
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
    }
}