package Menus;
import java.util.Scanner;

public class MenuLogin{
    private boolean opcao = true;
    private String usuario;
    private String senha;
    private int tipoDeUsuario;
    private Scanner entrada = new Scanner(System.in);

    public MenuLogin(){
        this.textoInicialMenuLogin();

        do{
            System.out.print("Digite seu email: ");
            this.usuario = this.entrada.nextLine();

            System.out.print("Digite sua senha: ");
            this.senha = this.entrada.nextLine();

            this.tipoDeUsuario = this.verificaLogin(this.usuario, this.senha);

            this.chamaMenuDeAcordoComUsuario(this.tipoDeUsuario);

        }
        while(this.opcao);
    }

    //Method created just to show the initial text
    private void textoInicialMenuLogin(){
        System.out.println("\n\n--------------------------------------------------------------------");
        System.out.println("|********************* Digite Seu email e senha *******************|");
        System.out.println("--------------------------------------------------------------------\n");
    }

    private int verificaLogin(String usuario, String senha){

        int valor = 0;
        
        /*
         * Criar a condição de verificação
         * 
         * Se as informações de acesso forem de um comprador
         * valor = 1;
         * 
         * Se as informações de uma Loja
         * valor = 2;
         * 
         * Se não for de comprador e nem de loja
         * valor = 0;
         * 
         */

        return valor;
    }

    private void chamaMenuDeAcordoComUsuario(int valor){

        switch(valor){
            case 1:
                MenuCompradores menuCompradores = new MenuCompradores();
                break;
            
            case 2:
                MenuLoja mLoja = new MenuLoja();
                break;
            
            default:
                System.out.println("Usuário não cadastrado.");
            
        }
    }

}