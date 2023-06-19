package Menus;

import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Loja.ControladorLoja;
import Loja.Loja;
import Produto.ControladorProduto;
import Produto.Produto;

public class MenuProduto {

    // Creation of variables/attributes
    private boolean controlador = true;
    private Scanner entrada = new Scanner(System.in);
    private String escolha;
    private ControladorProduto controladorProduto = new ControladorProduto();
    private ControladorLoja controlLoja = new ControladorLoja();
    private Loja lojaLogada = controlLoja.selecionarLojaLogada();

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

    //Method created to check which option was chosen
    private void verificaEscolhaMenuProduto(String opcao){
        
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
        Produto insertProduto = new Produto(name, lojaLogada.getId(), Double.parseDouble(valor), tipo, Integer.parseInt(quantidade), marca, description);
        controladorProduto.insertData(insertProduto);
    }

    private void excluirDadosPorId(){
        System.out.print("\nDigite o id do Comprador para excluir :");
        int id = entrada.nextInt();
        this.excluirDados(id, controladorProduto.readData("Produto"));
    }

    private void imprimirDadosDeTodosOsProdutos(List<Object> listaDeDados) {
        this.exibirInformacoesPorId(lojaLogada.getId(), listaDeDados);
    }

    private void exibirInformacoesPorId(int id, List<Object> lista) {
       ObjectMapper mapper = new ObjectMapper();
        boolean correspondenciaEncontrada = false; // Variável para verificar se houve correspondência

        for (Object obj : lista) {
            try {
                String jsonString = mapper.writeValueAsString(obj);
                JsonNode node = mapper.readTree(jsonString);

                int jsonIdDaLoja = node.get("idDaLoja").asInt();

                if (jsonIdDaLoja == id) {
                    correspondenciaEncontrada = true; // Definir a correspondência como verdadeira

                    int jsonId = node.get("id").asInt();
                    String nome = node.get("nome").asText();
                    double valor = node.get("valor").asDouble();
                    String tipo = node.get("tipo").asText();
                    int quantidade = node.get("quantidade").asInt();
                    String marca = node.get("marca").asText();
                    String descricao = node.get("descricao").asText();

                    System.out.println("ID: " + jsonId);
                    System.out.println("Nome: " + nome);
                    System.out.println("Valor: " + valor);
                    System.out.println("Tipo: " + tipo);
                    System.out.println("Quantidade: " + quantidade);
                    System.out.println("Marca: " + marca);
                    System.out.println("Descrição: " + descricao);
                    System.out.println();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!correspondenciaEncontrada) {
            System.out.println("Nenhuma correspondência encontrada para o ID: " + id);
        }
    }

    private void excluirDados(int id, List<Object> jsonData) {
        controladorProduto.deleteData(id, "Produto");
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
