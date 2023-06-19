package Produto;
public class Produto{
    // Variables Declaration
    private int id;
    private int idDaLoja;
    private String nome;
    private double valor;    
    private String tipo;
    private int quantidade;
    private String marca;
    private String descricao; 
   //private Loja loja = controladorProduto.   

    // Generic Constructor
    public Produto(String nome, int idDaLoja, double valor, String tipo, int quantidade, String marca, String descricao){
        ControladorProduto controller = new ControladorProduto();
        int size = controller.readData("Produto").size();

        this.id = size + 1;
        this.idDaLoja = idDaLoja;
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.marca = marca;
        this.descricao = descricao;
        this.id ++;
    }

    public Produto() {

    }
    
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

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
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

    public void setIdDaLoja(int id){
        this.idDaLoja = id;
    }

    public int getIdDaLoja(){
        return this.idDaLoja;
    }

    // Método para exibir os dados da loja
    public void exibirProduto() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Valor: R$" + this.valor);
        System.out.println("Tipo de produto " + this.tipo);
        System.out.println("Quantidade: " + this.quantidade);
        System.out.println("Marca: " + this.marca);
        System.out.println("Descrição: " + this.descricao);
    }
}