package Menus;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.tools.JavaFileObject;

import Loja.ControladorLoja;
import Loja.Loja;
import Produto.ControladorProduto;
import Produto.Produto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import com.fasterxml.jackson.core.JsonProcessingException;
import Comprador.ControladorComprador;

public class MenuProduto {
    // Creation of variables/attributes
    private boolean controlador = true;
    private Scanner entrada = new Scanner(System.in);
    private String escolha;
    private ControladorProduto controladorProduto = new ControladorProduto();
    private ControladorLoja controladorLoja = new ControladorLoja();
    private Loja lojaLogada = controladorLoja.selecionarLojaLogada();

    public MenuProduto(){
        this.textoInicialMenuProduto();

        do {
            this.textoSelecaoDaEntradaMenuProduto();
            this.escolha = this.entrada.nextLine();
            System.out.println("\n");
            this.verificaEscolhaMenuProduto(this.escolha);
            System.out.println("\n\n");
        }
        while(this.controlador);
    }

    //Method created just to show the initial text
    private void textoInicialMenuProduto(){
        System.out.println("\n\n--------------------------------------------------------------------");
        System.out.println("|************* Bem Vindo ao seu Sistema de Produtos ************|");
        System.out.println("--------------------------------------------------------------------\n");
    }

    //Method created to show choice information
    private void textoSelecaoDaEntradaMenuProduto(){
        System.out.println("Escolha Uma Opção abaixo.");
        System.out.println("1 - Criar produtos.");
        System.out.println("2 - Atualizar um produto.");
        System.out.println("3 - Remover produto.");
        System.out.println("4 - Listar todos os Produtos.");
        System.out.println("0 - Sair do Sistema de Produtos.\n");
        System.out.print("Digite a sua Opção: ");
    }

    private void cadastrarNovoProduto(){
        System.out.println("\n");

        System.out.println("Digite o nome do novo produto: ");
        String name = this.entrada.nextLine();
        System.out.println("Digite o valor do produto: ");
        String valor = this.entrada.nextLine();
        System.out.println("Digite o tipo do produto: ");
        String tipo = this.entrada.nextLine();
        System.out.println("Digite a quantidade de produtos: ");
        String quantidade = this.entrada.nextLine();
        System.out.println("Digite a marca do produto: ");
        String marca = this.entrada.nextLine();
        System.out.println("Digite a descrição do produto: ");
        String description = this.entrada.nextLine();
        Produto insertProduto = new Produto(name, Double.parseDouble(valor), tipo, Integer.parseInt(quantidade), marca, description, lojaLogada.getId());
        controladorProduto.insertData(insertProduto);
    }

    private void excluirDadosPorId(){
        System.out.print("\nDigite o id do Comprador para excluir :");
        int id = entrada.nextInt();
        this.excluirDados(id, controladorProduto.readData("Produto"));
    }

    //Method created to check which option was chosen
    private void verificaEscolhaMenuProduto(String opcao){
        //Falta implementar os sub-menus
        switch(opcao){
            case "1":
                this.cadastrarNovoProduto();
                break;

            case "2":
                this.atualizarInformacaoDoNome();
                break;

            case "3":
                this.excluirDadosPorId();
                break;

            case "4":
                this.imprimirDadosDeTodosOsProdutos(controladorProduto.readData("Produto"));
                break;

            case "0":
                System.out.println("Saindo do Sistema");
                this.controlador = false;
                break;

            default:
                System.out.println("Digite uma Opção válida....");
        }
    }

    private void mostrarDadosPorId(String id, List<Object> listaDeDados) {
        for (Object objeto : listaDeDados) {
            // Verifica se o objeto possui um campo "id" e se o valor é igual ao ID desejado
            if (objeto instanceof Map) {
                Map<?, ?> mapa = (Map<?, ?>) objeto;
                Object valorId = mapa.get("id");
                if (valorId != null && valorId.toString().equals(id)) {
                    // Mostra os campos desejados
                    System.out.println("ID: " + mapa.get("id"));
                    System.out.println("Nome: " + mapa.get("nome"));
                    System.out.println("Email: " + mapa.get("email"));
                    System.out.println("Endereço: " + mapa.get("endereco"));
                    return;
                }
            }
        }

        System.out.println("Objeto com o ID " + id + " não encontrado.");
    }

    private void imprimirDadosDeTodosOsProdutos(List<Object> listaDeDados) {
        System.out.println(controladorProduto.readData("Produto"));
    }

    private void excluirDados(int id, List<Object> jsonData) {
        controladorProduto.deleteData(id, "Produto");
    }

    private String obterValor(Map<?, ?> mapa, String chave) {
        Object valor = mapa.get(chave);
        if (valor != null) {
            return valor.toString();
        } else {
            return "";
        }
    }

    private void atualizarInformacaoDoNome(){
        System.out.print("\nDigite o id para atualizar o nome: ");
        String input = entrada.nextLine();
        int id = Integer.parseInt(input);
        System.out.print("\nDigite o novo nome do produto: ");
        String nome = entrada.nextLine();
        controladorProduto.updateData("Produto", id, nome);
    }
}
