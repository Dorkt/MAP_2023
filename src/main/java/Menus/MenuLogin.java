package Menus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Comprador.ControladorComprador;
import Loja.ControladorLoja;

public class MenuLogin{
    // Creation of variables/attributes
    private boolean opcao = true;
    private String usuario;
    private String senha;
    private int tipoDeUsuario;
    private Scanner entrada = new Scanner(System.in);
    private ControladorLoja controladorLoja = new ControladorLoja();
    private ControladorComprador controladorComprador = new ControladorComprador();

    public MenuLogin(){
        this.textoInicialMenuLogin();
        int verifica = 1;

        System.out.println("Você possue 3 tentativas para logar....\n");

        do {
            System.out.println("Tentativa de login nº: " + verifica);
            System.out.print("\nDigite seu email: ");
            this.usuario = this.entrada.nextLine();

            System.out.print("Digite sua senha: ");
            this.senha = this.entrada.nextLine();

            if(this.verificaLogin(this.usuario, this.senha) == 1){
                this.chamaMenuDeAcordoComUsuario(1);
                verifica = 7;
            }
            else if(this.verificaLogin(this.usuario, this.senha) == 2){
                this.chamaMenuDeAcordoComUsuario(2);
                verifica = 6;
            }
                       
            verifica++;

        }
        while(verifica < 4);
    }

    //Method created just to show the initial text
    private void textoInicialMenuLogin(){
        System.out.println("\n\n--------------------------------------------------------------------");
        System.out.println("|********************* Digite Seu email e senha *******************|");
        System.out.println("--------------------------------------------------------------------\n");
    }

    //Method created to check which type of user logged into the system
    private int verificaLogin(String email, String senha) {
        List<Object> listaLoja = controladorLoja.readData("Loja");
        List<Object> listaComprador = controladorComprador.readData("Comprador");
    
        int resultado = 0;
    
        resultado = buscaCredenciais(email, senha, listaLoja);
        if (resultado != 0) {
            return resultado; // Encontrou email e senha na lista ControladorLoja, retorna o resultado
        }
    
        resultado = buscaCredenciais(email, senha, listaComprador);
        if (resultado != 0) {
            return resultado+1; // Encontrou email e senha na lista ControladorComprador, retorna o resultado
        }
    
        return 0; // Não encontrou email e senha em nenhuma das listas, retorna 0
    }
    
    private int buscaCredenciais(String email, String senha, List<Object> listaDeDados) {
        for (Object elemento : listaDeDados) {
            String linha = elemento.toString();
            linha = linha.replaceAll("[{}\\s]", "");
    
            String[] pares = linha.split(",");
    
            boolean encontrouEmail = false;
            boolean encontrouSenha = false;
    
            for (String par : pares) {
                String[] partes = par.split("=");
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();
    
                    if (chave.equals("email") && valor.equals(email)) {
                        encontrouEmail = true;
                    }
    
                    if (chave.equals("senha") && valor.equals(senha)) {
                        encontrouSenha = true;
                    }
                }
            }
    
            if (encontrouEmail && encontrouSenha) {
                return 1; // Encontrou email e senha correspondentes na lista de dados
            }
        }
    
        return 0; // Não encontrou email e senha correspondentes na lista de dados
    }

    //Method created to call the menu according to the user logged in the system
    private void chamaMenuDeAcordoComUsuario(int valor){

        switch(valor){
            case 1:
                MenuLoja mLoja = new MenuLoja();                
                break;
            
            case 2:
                MenuCompradores menuCompradores = new MenuCompradores();
                break;
            
            default:
                System.out.println("Usuário não cadastrado.");
            
        }
    }

}