package Menus;
import java.util.Scanner;

public class MenuLoja {
    // Creation of variables/attributes
    private boolean controlador = true;
    private Scanner entrada = new Scanner(System.in);
    private String escolha;

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
                System.out.println("Saindo do Sistema...");
                this.controlador = false;
                break;

            default:
                System.out.println("Digite uma Opção válida....");
        }
    }

}
