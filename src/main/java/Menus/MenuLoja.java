package Menus;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Loja.ControladorLoja;

public class MenuLoja {
    // Creation of variables/attributes
    private boolean controlador = true;
    private Scanner entrada = new Scanner(System.in);
    private String escolha;
    private ControladorLoja controladorLoja = new ControladorLoja();

    public MenuLoja(){
        this.textoInicialMenuLoja();

        do {
            this.textoSelecaoDaEntradaMenuLoja();
            this.escolha = this.entrada.nextLine();
            System.out.println("\n");
            this.verificaEscolhaMenuLoja(this.escolha);
            System.out.println("\n\n");
        }
        while(this.controlador);
    }

    private void textoInicialMenuLoja(){
        System.out.println("\n\n--------------------------------------------------------------------");
        System.out.println("|**************** Bem Vindo ao seu Sistema de Lojas ***************|");
        System.out.println("--------------------------------------------------------------------\n");
    }

    private void textoSelecaoDaEntradaMenuLoja(){
        System.out.println("Escolha Uma Opção abaixo.");
        System.out.println("1 - Buscar Loja.");
        System.out.println("2 - Atualizar Loja.");        
        System.out.println("3 - Remover Loja.");        
        System.out.println("4 - Listar todas as Lojas.");        
        System.out.println("0 - Sair do Sistema de Lojas.\n");
        System.out.print("Digite a sua Opção: ");
    }

    private void verificaEscolhaMenuLoja(String opcao){
        //Falta implementar os sub-menus
        switch(opcao){
            case "1":            
                this.buscarLojaPorID();               
                break;

            case "2":
                this.atualizarInformacaoDoNome();               
                break;

            case "3":
                this.excluirDadosPorId();
                break;

            case "4":
                this.imprimirDadosDeTodasLojas(controladorLoja.readData("Loja"));                
                break;

            case "0":
                System.out.println("Saindo do Sistema...");
                this.controlador = false;
                break;

            default:
                System.out.println("Digite uma Opção válida....");
        }
    }

    private void excluirDadosPorId(){
        System.out.print("\nDigite o id do Comprador para excluir :");
        int id = entrada.nextInt();
        controladorLoja.deleteData(id, "Loja");        
    }

    private void buscarLojaPorID(){
        System.out.print("\nDigite o id da Loja para buscar os dados :");
        String id = entrada.nextLine();
        this.mostrarDadosPorId(id, controladorLoja.readData("Loja"));
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

    private void imprimirDadosDeTodasLojas(List<Object> listaDeDados) {
        for (Object objeto : listaDeDados) {
            if (objeto instanceof Map) {
                Map<?, ?> mapa = (Map<?, ?>) objeto;
                
                String id = obterValor(mapa, "id");
                String nome = obterValor(mapa, "nome");
                String email = obterValor(mapa, "email");
                String endereco = obterValor(mapa, "endereco");
    
                System.out.println("Id: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);
                System.out.println("Endereço: " + endereco);
                System.out.println("-------------------------");
            }
        }
    }

    private void atualizarInformacaoDoNome(){
        System.out.print("\nDigite o id para atualizar o nome da Loja: ");
        String input = entrada.nextLine();
        int id = Integer.parseInt(input);
        System.out.print("\nDigite o novo nome: ");
        String nome = entrada.nextLine();
        controladorLoja.updateData("Loja", id, nome);        

    }

    private String obterValor(Map<?, ?> mapa, String chave) {
        Object valor = mapa.get(chave);
        if (valor != null) {
            return valor.toString();
        } else {
            return "";
        }
    }
}
