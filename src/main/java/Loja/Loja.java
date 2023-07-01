package Loja;

public class Loja {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String endereco;
    private Integer avaliacoes;

    public Loja(String nome, String email, String senha, String cpfCnpj, String endereco) {
        ControladorLoja controller = new ControladorLoja();
        int size = controller.readData("Loja").size();

        this.id = size + 1;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.avaliacoes = avaliacoes;
    }

    // Adicionando construtor vazio para que a biblioteca que lê os dados persistidos conseguir converter os tipos para
    // o dessa classe
    public Loja() {

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

    public int getAvaliacoes() {return this.avaliacoes; }
    public void setAvaliacoes(){ this.avaliacoes = avaliacoes; }

    // Método para exibir os dados da loja
    public void exibirLoja() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("CPF/CNPJ: " + cpfCnpj);
        System.out.println("Endereço: " + endereco);
    }
}