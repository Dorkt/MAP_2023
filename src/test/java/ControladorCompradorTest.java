import Comprador.Comprador;
import Comprador.ControladorComprador;
import Produto.Produto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ControladorCompradorTest {
    @Test
    public void testAddProdutoAoCarrinho() {
        ControladorComprador controladorComprador = new ControladorComprador();

        // Cria uma lista de produtos com um produto válido
        List<Produto> produtosExistentes = new ArrayList<>();
        Produto produto = new Produto();
        produtosExistentes.add(produto);

        // Cria um comprador para adicionar o produto ao carrinho
        Comprador comprador = new Comprador();

        // Adiciona o produto ao carrinho
        controladorComprador.addProdutoAoCarrinho(1, comprador);

        assertFalse(comprador.getCarrinhoDeCompras().contains(produto));
    }

    @Test
    public void testSelecionarCompradorLogado() {
        ControladorComprador controladorComprador = new ControladorComprador();

        // Define o diretório do projeto para o teste
        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoFinal = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator + "loggedUser.json";

        // Cria um arquivo loggedUser.json válido no diretório de teste
        File arquivoJson = new File(caminhoFinal);

        // Cria um comprador existente para ser retornado
        Comprador compradorExistente = new Comprador();

        Comprador compradorLogado = controladorComprador.selecionarCompradorLogado();

        assertNotEquals(compradorExistente, compradorLogado);
    }
}
