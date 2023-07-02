package Compra;

import Comprador.Comprador;
import Produto.Produto;
import Comprador.ControladorComprador;

import java.util.List;

public class Compra extends Produto {
    private String comentario;
    private double notaAvaliacao;

    public Compra(String nome, double valor, String tipo, int quantidade, String marca, String descricao, int idLoja) {
        super(nome, valor, tipo, quantidade, marca, descricao, idLoja);
        ControladorComprador controladorComprador = new ControladorComprador();
        Integer size = controladorComprador.getTotalComprasNoSistema();
        this.id = size + 1;
        this.comentario = null;
        this.notaAvaliacao = 0;
    }
    public Compra() {}

    public void setAvaliacao(double avaliacao) {
        this.notaAvaliacao = avaliacao;
    }

    public double getNotaAvaliacao() {
        return this.notaAvaliacao;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void avaliarCompra(double nota, String comentario) {
        this.notaAvaliacao = nota;
        this.comentario = comentario;
    }
}
