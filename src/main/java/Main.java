import Comprador.Comprador;
import Loja.Loja;

public class Main {
    public static void main(String[] args) {
        // Criando uma loja
        Loja loja = new Loja("Minha Loja", "loja@email.com", "senha123", "123456789", "Rua A");
        // Exibindo os dados da loja
        loja.exibirLoja();
        Comprador comprador = new Comprador("João", "joao@email.com", "senha456", "987654321", "Rua B");
        comprador.exibirComprador();
    }
}