package Menus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Comprador.ControladorComprador;
import Comprador.Comprador;
import Produto.Produto;
import Produto.ControladorProduto;

public class MenuCompradores {
    // Creation of variables/attributes
    private boolean controlador = true;
    private Scanner entrada = new Scanner(System.in);
    private String escolha;
    private ControladorComprador controladorComprador = new ControladorComprador();
    private ControladorProduto controladorProduto = new ControladorProduto();

    private Comprador compradorLogado = controladorComprador.selecionarCompradorLogado();

    public MenuCompradores(){
        this.textoInicialMenuComprador();

        do{
            this.textoSelecaoDaEntradaMenuComprador();
            this.escolha = this.entrada.nextLine();
            System.out.println("\n");
            this.verificaEscolhaMenuComprador(this.escolha);
            System.out.println("\n\n");
        }
        while(this.controlador);
    }

    //Method created just to show the initial text
    private void textoInicialMenuComprador(){
        System.out.println("\n\n--------------------------------------------------------------------");
        System.out.println("|************* Bem Vindo ao seu Sistema de Compradores ************|");
        System.out.println("--------------------------------------------------------------------\n");
    }

    //Method created to show choice information
    private void textoSelecaoDaEntradaMenuComprador(){
        System.out.println("Escolha Uma Opção abaixo.");
        System.out.println("1 - Buscar Comprador.");
        System.out.println("2 - Atualizar Seus dados.");
        System.out.println("3 - Remover conta Comprador.");
        System.out.println("4 - Listar todos os Compradores.");
        System.out.println("5 - Adicionar produto ao carrinho.");
        System.out.println("6 - Listar produtos no carrinho.");
        System.out.println("7 - Remover produto do carrinho");
        System.out.println("8 - Finalizar compra do carrinho");
        System.out.println("9 - Listar todos os Produtos.");
        System.out.println("0 - Sair do Sistema de Compradores.\n");
        System.out.print("Digite a sua Opção: ");
    }

    private void buscarCompradorPorID(){
        System.out.print("\nDigite o id do Comprador para buscar os dados :");
        String id = entrada.nextLine();
        this.mostrarDadosPorId(id, controladorComprador.readData("Comprador"));
    }

    private void excluirDadosPorId(){
        System.out.print("\nDigite o id do Comprador para excluir :");
        int id = entrada.nextInt();
        controladorComprador.deleteData(id, "Comprador");
    }

    //Method created to check which option was chosen
    private void verificaEscolhaMenuComprador(String opcao){
        //Falta implementar os sub-menus
        switch(opcao){
            case "1":
                this.buscarCompradorPorID();
                break;

            case "2":
                     this.atualizarInformacaoDoNome();
                break;

            case "3":
                    this.excluirDadosPorId();
                break;

            case "4":
                    this.imprimirDadosDeTodosOsCompradores(controladorComprador.readData("Comprador"));
                break;

            case "5":
                this.adicionarProdutoAoCarrinho();
                break;

            case "6":
                this.listarProdutosNoCarrinho();
                break;

            case "7":
                this.removerProdutoDoCarrinho();
                break;

            case "8":
                this.finalizarCompraDoCarrinho();
                break;

            case "9":
                this.listarTodosProdutos(controladorProduto.readData("Produto"));
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

    private void imprimirDadosDeTodosOsCompradores(List<Object> listaDeDados) {
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
        System.out.print("\nDigite o novo nome: ");
        String nome = entrada.nextLine();
        controladorComprador.updateData("Comprador", id, nome);
    }

    private void adicionarProdutoAoCarrinho() {
        System.out.print("\nDigite o id do produto que deseja adicionar ao carrinho: ");
        String input = entrada.nextLine();
        int id = Integer.parseInt(input);
        controladorComprador.addProdutoAoCarrinho(id, compradorLogado);
    }

    private void listarProdutosNoCarrinho() {
        System.out.println("Produtos no carrinho");
        System.out.println("--------------------");

        List<Produto> produtosCarrinho = compradorLogado.getCarrinhoDeCompras();

        for (Produto produto: produtosCarrinho) {
            produto.exibirProduto();
        }
    }

    private void finalizarCompraDoCarrinho() {
        List<Produto> produtosCarrinho = compradorLogado.getCarrinhoDeCompras();
        List<Produto> produtosComprados = new ArrayList<>();

        for (Produto produto : produtosCarrinho) {
            try {
                controladorProduto.comprarProduto(produto.getId());
                produtosComprados.add(produto);
            } catch (IllegalArgumentException e) {
                System.out.println("Não foi possível comprar o produto: " + e.getMessage());
            }
        }

        compradorLogado.adicionarCompra(produtosComprados);
        compradorLogado.esvaziarCarrinhoDeCompras();

        System.out.println("Produtos comprados:");
        System.out.println("--------------------");

        for (Produto produto : produtosComprados) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("--------------------");
        }

        // Verificar se o usuário deseja visualizar o histórico de compras
        String resposta = entrada.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            compradorLogado.exibirHistoricoCompras();
        }
    }

    private void removerProdutoDoCarrinho() {
        System.out.print("\nDigite o id do produto que deseja retirar do carrinho: ");
        String input = entrada.nextLine();
        int idProduto = Integer.parseInt(input);
        List<Produto> produtosCarrinho = compradorLogado.getCarrinhoDeCompras();

        for (Produto produto: produtosCarrinho) {
            if (produto.getId() == idProduto) {
                compradorLogado.removerDoCarrinho(produto);
                break;
            }
        }
    }

    private void listarTodosProdutos(List<Object> listaDeDados) {
        for (Object objeto : listaDeDados) {
            if (objeto instanceof Map) {
                Map<?, ?> mapa = (Map<?, ?>) objeto;

                String id = obterValor(mapa, "id");
                String nome = obterValor(mapa, "nome");
                String valor = obterValor(mapa, "valor");
                String tipo = obterValor(mapa, "tipo");
                String quantidade = obterValor(mapa, "quantidade");
                String marca = obterValor(mapa, "marca");
                String descricao = obterValor(mapa, "descricao");

                System.out.println("Id: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Valor: " + valor);
                System.out.println("Tipo: " + tipo);
                System.out.println("Quantidade: " + quantidade);
                System.out.println("Marca: " + marca);
                System.out.println("Descrição: " + descricao);
                System.out.println("-------------------------");
            }
        }
    }
}
