package Comprador;

import Produto.Produto;

import java.util.List;
import java.util.ArrayList;

public class Comprador {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String endereco;
    private List<Produto> carrinhoDeCompras;
    private List<Produto> historicoCompras;

    public Comprador(String nome, String email, String senha, String cpf, String endereco) {
        ControladorComprador t = new ControladorComprador();
        this.id = id;
        int size = t.readData("Comprador").size();

        this.id = size + 1;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.carrinhoDeCompras = new ArrayList<Produto>();
        this.historicoCompras = new ArrayList<Produto>();
    }

    // Adicionando construtor vazio para que a biblioteca que lê os dados persistidos conseguir converter os tipos para
    // o dessa classe
    public Comprador() {
        this.carrinhoDeCompras = new ArrayList<Produto>();
        this.historicoCompras = new ArrayList<Produto>();
    }

    // Getters e Setters

    public int getId() {
        return this.id;
    }

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
    public void adicionarAoCarrinho(Produto produto) {
        carrinhoDeCompras.add(produto);
    }

    // Remover um item do carrinho de compras
    public void removerDoCarrinho(Produto produto) {
        carrinhoDeCompras.remove(produto);
    }

    public List<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void esvaziarCarrinhoDeCompras() {
        this.carrinhoDeCompras = new ArrayList<Produto>();
    }

    // Limpar o carrinho de compras
    public void limparCarrinho() {
        carrinhoDeCompras.clear();
    }

    // Exibir os itens no carrinho de compras
    public void exibirCarrinhoDeCompras() {
        System.out.println("Itens no Carrinho de Compras:");
        for (Produto produto : carrinhoDeCompras) {
            System.out.println(produto);
        }
    }

    // Método para exibir os dados do comprador
    public void exibirComprador() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
    }

    // Método para adicionar uma compra ao histórico
    public void adicionarCompra(List<Produto> produtos) {
        historicoCompras.addAll(produtos);
    }

    // Método para exibir o histórico de compras
    public void exibirHistoricoCompras() {
        for (Produto produto : historicoCompras) {
            System.out.println(produto);
        }
    }
}
