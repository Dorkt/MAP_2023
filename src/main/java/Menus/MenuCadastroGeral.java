package Menus;

import java.util.Scanner;

public class MenuCadastroGeral {
    private boolean continuar = true;
    private String tipoDeCadastro;
    private int ateOndePreencheuOsDados = 0;
    private String nome;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String endereco;
    private Scanner entrada = new Scanner(System.in);


    public MenuCadastroGeral(){
        
        this.textoMenuPrincipal();

        do {

            this.escolheTipoDeCadastro();
            this.verificaOpcao(this.entrada.nextLine());

        }
        while(this.continuar);        
        
    }

    private void textoMenuPrincipal(){
        System.out.println("\n\n--------------------------------------------------------------------");
        System.out.println("|****************** Menu Cadastro Comprador/Loja ******************|");
        System.out.println("--------------------------------------------------------------------");
    }

    private void escolheTipoDeCadastro(){
        System.out.println("\nEscolha uma opção abaixo...");
        System.out.println("1 - Cadastrar Loja/Comprador.");
        System.out.println("0 - Voltar ao Menu Principal.");
        System.out.print("Digite a sua Opção: ");
    }

    private void verificaOpcao(String valor){

        switch(valor){
            
            case "1":
                this.cadastrarInformacoes();
            break;

            case "0":
                System.out.println("Voltando Ao Menu Principal.");
                this.continuar = false;
            break;

            default:
                System.out.println("Digite uma Opção Válida....\n");

        }
    }

    private void cadastrarInformacoes(){
        String sair = "a";

        while(!sair.equals("0")){

            System.out.println("\n");

            if(this.ateOndePreencheuOsDados == 0){                
                System.out.println("Digite 1 para Loja, 2 para Comprador ou 0 para cancelar: ");                
                sair = this.entrada.nextLine();
                this.validaDados(sair, "tipoDeCadastro");
            }
            else if(this.ateOndePreencheuOsDados == 1){
                System.out.println("Digite o seu nome ou o da Loja ou 0 para cancelar: ");
                sair = this.entrada.nextLine();
                this.validaDados(sair, "nome");                 
            }
            else if(this.ateOndePreencheuOsDados == 2){
                System.out.println("Digite o seu email ou 0 para cancelar: ");
                sair = this.entrada.nextLine();
                this.validaDados(sair, "email");
            }
            else if(this.ateOndePreencheuOsDados == 3){
                System.out.println("Digite o sua senha ou 0 para cancelar: ");
                sair = this.entrada.nextLine();
                this.validaDados(sair, "senha");
            }
            else if(this.ateOndePreencheuOsDados == 4){
                System.out.println("Digite o seu cpf ou cnpj ou 0 para cancelar: ");
                sair = this.entrada.nextLine();
                this.validaDados(sair, "cpfCnpj");
            }
            else if(this.ateOndePreencheuOsDados == 5){
                System.out.println("Digite o seu endereço ou 0 para cancelar: ");
                sair = this.entrada.nextLine();
                this.validaDados(sair, "endereco");
                sair = this.cadastrarOutraVez();
            }     

        }  
    }

    private void validaDados(String dado, String tipoDeDado){
        
        if(dado.equals("") || dado.equals(" ") || dado.equals("  ") || dado.equals("0") ){

            if(dado.equals("0")){
                this.ateOndePreencheuOsDados = 0;
                this.tipoDeCadastro = "0";
                System.out.println("\nCancelando Cadastro.\n");
            }
            else{
                System.out.println("\nDigite algum dado para o campo : " + tipoDeDado +"\n");
            }                                    
        }
        
        else{

            if(tipoDeDado.equals("tipoDeCadastro")){
                if((dado.equals("1") || dado.equals("2")) && this.ateOndePreencheuOsDados == 0){
                    this.tipoDeCadastro = dado;
                    this.ateOndePreencheuOsDados++;
                }
                else{
                    System.out.println("Digite se você é Comprador ou loja...");
                }
            }
            else if(tipoDeDado.equals("nome")){
                this.nome = dado;
                this.ateOndePreencheuOsDados++;
            }
            else if(tipoDeDado.equals("email")){
                this.email = dado;
                this.ateOndePreencheuOsDados++;
            }
            else if(tipoDeDado.equals("senha")){
                this.senha = dado;
                this.ateOndePreencheuOsDados++;
            }
            else if(tipoDeDado.equals("cpfCnpj")){
                this.cpfCnpj = dado;
                this.ateOndePreencheuOsDados++;
            }
            else if(tipoDeDado.equals("endereco")){
                this.endereco = dado;
                this.ateOndePreencheuOsDados = 0;
                this.salvarDados();
            }
        }
    }
    
    private String cadastrarOutraVez(){

        System.out.println("\nDeseja realizar outro Cadastro?");
        System.out.println("0 - Não.");
        System.out.println("Qualquer outra Entrada - Sim.");
        System.out.print("Digite : ");

        return this.entrada.nextLine();
    }

    private void salvarDados(){

        if(this.tipoDeCadastro.equals("1")){
            System.out.println("\nInserir os dados no arquivo Comprador\n");
        }
        else{
            System.out.println("\nInserir os dados no arquivo Loja\n");
        }
        
    }
}
