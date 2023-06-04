package Menus;
import java.util.Scanner;

public class MenuPrincipal {
    // Creation of variables/attributes
    private boolean opcao = true;
    private String escolha;
    private Scanner entrada = new Scanner(System.in);   

    public MenuPrincipal(){

        do {
            this.textoMenuPrincipal();
            
            this.menuPrincipal();
            this.escolha = entrada.nextLine();
            this.verificaEscolha(this.escolha);
            System.out.println("\n");
        }
        while(this.opcao);
    }

    private void textoMenuPrincipal(){
        System.out.println("\n\n--------------------------------------------------------------------");
        System.out.println("|************* Bem Vindo ao Menu Principal do Sistema *************|");
        System.out.println("--------------------------------------------------------------------\n");
    }

    private void menuPrincipal(){
        System.out.println("\nEscolha Uma Opção abaixo.");
        System.out.println("1 - Cadastrar Comprador/Loja.");
        System.out.println("2 - Realizar login.");                 
        System.out.println("0 - Sair do Sistema.\n");
        System.out.print("Digite a sua Opção: ");
    }

    private void verificaEscolha(String valor){
        switch(valor){
            case "1":
                MenuCadastroGeral mcg = new MenuCadastroGeral();
            break;

            case "2":
                MenuLogin ml = new MenuLogin();
            break;

            case "0":
                this.opcao = false;
            break;

            default:
            System.out.println("Digite uma opção válida....");
        }
    }
}