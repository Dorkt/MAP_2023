package Produto;
public class Produto{
    // Variables Declaration
    private int id = 0;
    private String nome;
    private double valor;
    private int tipo;
    private int quantidade;
    private String marca;
    private String descricao;    

    // Generic Constructor
    public Produto(String nome, double valor, int tipo, int quantidade, String marca, String descricao){
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.marca = marca;
        this.descricao = descricao;
        this.id ++;
    }

    // Adicionando construtor vazio para que a biblioteca que lê os dados persistidos conseguir converter os tipos para
    // o dessa classe
    public Produto() {}
    
    // Gets and Sets
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public int getTipo(){
        return this.tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
}