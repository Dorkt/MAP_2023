import Comprador.Comprador;
import Loja.Loja;
import Produto.Produto;

import Controlador.ControladorLoja;
import Controlador.ControladorComprador;
import Controlador.ControladorProduto;

import Menus.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        // Criando uma loja
        //Loja loja = new Loja("Minha Loja", "loja@email.com", "senha123", "123456789", "Rua A");
        // Exibindo os dados da loja
        //loja.exibirLoja();
        //Comprador comprador = new Comprador("João", "joao@email.com", "senha456", "987654321", "Rua B");
        //comprador.exibirComprador();

        //MenuPrincipal mp = new MenuPrincipal();

        ControladorLoja controle1 = new ControladorLoja();
        Loja loja = new Loja("Lojão 10", "lojao10@gmail.com", "101010", "001.234.0005-67", "Rua do Bar, 10");
        controle1.persistirLoja(loja);
        System.out.println(controle1.pegarTodasLojas());

        ControladorComprador controle2 = new ControladorComprador();
        Comprador comprador = new Comprador("José", "jose@gmail.com", "123456", "123.456.789-10", "Avenida Vazia, 50");
        controle2.persistirComprador(comprador);
        System.out.println(controle2.pegarTodosCompradores());

        ControladorProduto controle3 = new ControladorProduto();
        Produto produto = new Produto("Borracha", 5.99, 5, 1, "Toque Mágico", "Borracha Branca Macia");
        controle3.persistirProduto(produto);
        System.out.println(controle3.pegarTodosProdutos());
    }
}