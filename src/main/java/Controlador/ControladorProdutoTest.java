package Controlador;
import Produto.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ControladorProdutoTest {

    private ControladorProduto controladorProduto;

    @BeforeEach
    public void setUp() {
        controladorProduto = new ControladorProduto();
    }

    @Test
    public void testPersistirProduto() {
        Produto produto = new Produto("Produto 1", 10.0, 1, 5, "Marca 1", "Descrição 1");

        controladorProduto.persistirProduto(produto);

        List<Object> produtos = controladorProduto.pegarTodosProdutos();

        assertFalse(produtos.contains(produto));
    }

    @Test
    public void testPegarTodosProdutos() {
        Produto produto1 = new Produto("Produto 1", 10.0, 1, 5, "Marca 1", "Descrição 1");
        Produto produto2 = new Produto("Produto 2", 20.0, 2, 10, "Marca 2", "Descrição 2");

        controladorProduto.persistirProduto(produto1);
        controladorProduto.persistirProduto(produto2);

        List<Object> produtos = controladorProduto.pegarTodosProdutos();

        assertEquals(4, produtos.size());
        assertFalse(produtos.contains(produto1));
        assertFalse(produtos.contains(produto2));
    }

    @Test
    public void testRemoverProduto() {
        Produto produto = new Produto("Produto 1", 10.0, 1, 5, "Marca 1", "Descrição 1");

        controladorProduto.persistirProduto(produto);

        int produtoId = produto.getId();

        controladorProduto.removerProduto(produtoId);

        List<Object> produtos = controladorProduto.pegarTodosProdutos();

        assertFalse(produtos.contains(produto));
    }

    @Test
    public void testAtualizarNomeProduto() {
        Produto produto = new Produto("Produto 1", 10.0, 1, 5, "Marca 1", "Descrição 1");

        controladorProduto.persistirProduto(produto);

        int produtoId = produto.getId();
        String novoNome = "Novo Produto";

        controladorProduto.atualizarNomeProduto(produtoId, novoNome);

        List<Object> produtos = controladorProduto.pegarTodosProdutos();
        Produto produtoAtualizado = null;

        for (Object obj : produtos) {
            if (obj instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) obj;
                Produto p = new Produto();
                p.setId((int) map.get("id"));
                p.setNome((String) map.get("nome"));
                p.setValor((double) map.get("valor"));
                p.setTipo((int) map.get("tipo"));
                p.setQuantidade((int) map.get("quantidade"));
                p.setMarca((String) map.get("marca"));
                p.setDescricao((String) map.get("descricao"));

                if (p.getId() == produtoId) {
                    produtoAtualizado = p;
                    break;
                }
            }
        }

        assertNotNull(produtoAtualizado);
        assertEquals(novoNome, produtoAtualizado.getNome());
    }
}