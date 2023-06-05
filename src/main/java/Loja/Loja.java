package Loja;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String endereco;

    // Lista para armazenar as lojas
    private static List<Loja> lojas = new ArrayList<>();

    public Loja(int id, String nome, String email, String senha, String cpfCnpj, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
    }

    public Loja() {
    }

    // Getters e Setters

    public int getId() {
        return id;
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void exibirLoja() {
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("CPF/CNPJ: " + cpfCnpj);
        System.out.println("Endereço: " + endereco);
    }

    // Função para buscar uma loja pelo ID
    public static Loja buscarPorId(int id) {
        for (Loja loja : lojas) {
            if (loja.getId() == id) {
                return loja;
            }
        }
        return null;
    }

    // Função para buscar todas as lojas
    public static List<Loja> buscarTodasLojas() {
        return lojas;
    }

    // Função para adicionar uma loja à lista de lojas
    public static void adicionarLoja(Loja loja) {
        lojas.add(loja);
    }

    // Função para remover uma loja da lista de lojas
    public static void removerLoja(Loja loja) {
        lojas.remove(loja);
    }

    // Função para atualizar os dados de uma loja
    public static void atualizarLoja(Loja loja) {
        int index = lojas.indexOf(loja);
        if (index != -1) {
            lojas.set(index, loja);
        }
    }
}
