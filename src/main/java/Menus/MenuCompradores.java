package Menus;
import java.util.Scanner;

public class MenuCompradores {
    // Criação das variáveis/atributos
    private boolean controlador = true;
    private Scanner entrada = new Scanner(System.in);
    private String escolha;

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
        System.out.println("1 - Cadastrar Comprador.");
        System.out.println("2 - Buscar Comprador.");
        System.out.println("3 - Atualizar Comprador.");        
        System.out.println("4 - Remover Comprador.");        
        System.out.println("5 - Listar todos os Compradores.");        
        System.out.println("0 - Sair do Sistema de Compradores.\n");
        System.out.print("Digite a sua Opção: ");
    }

    //Method created to check which option was chosen
    private void verificaEscolhaMenuComprador(String opcao){
        //Falta implementar os sub-menus
        switch(opcao){
            case "1":            
                System.out.println("Falta Implementar essa parte...");                
                break;

            case "2":
                System.out.println("Falta Implementar essa parte...");                
                break;

            case "3":
                System.out.println("Falta Implementar essa parte...");
                break;

            case "4":
                System.out.println("Falta Implementar essa parte...");                
                break;

            case "5":
                System.out.println("Falta Implementar essa parte...");                
                break;

            case "0":
                System.out.println("Saindo do Sistema");
                this.controlador = false;
                break;

            default:
                System.out.println("Digite uma Opção válida....");
        }
    }
}
