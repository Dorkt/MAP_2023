import Comprador.Comprador;
import Produto.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {

    @Test
    void testAdicionarRemoverDoCarrinho() {
        // Preparação
        Comprador comprador = new Comprador();
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        // Caso em que adiciona um produto ao carrinho de compras
        comprador.adicionarAoCarrinho(produto1);
        // Verificar se o produto foi adicionado corretamente ao carrinho de compras
        assertTrue(comprador.getCarrinhoDeCompras().contains(produto1));
        // Caso em que remove um produto do carrinho de compras
        comprador.removerDoCarrinho(produto1);
        // Verificar se o produto foi removido corretamente do carrinho de compras
        assertFalse(comprador.getCarrinhoDeCompras().contains(produto1));
    }

    @Test
    void testEsvaziarCarrinhoDeCompras() {
        // Preparação
        Comprador comprador = new Comprador();
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        // Adicionar produtos ao carrinho de compras
        comprador.adicionarAoCarrinho(produto1);
        comprador.adicionarAoCarrinho(produto2);

        // Esvaziar o carrinho de compras
        comprador.esvaziarCarrinhoDeCompras();

        // Verificar se o carrinho de compras está vazio
        assertTrue(comprador.getCarrinhoDeCompras().isEmpty());
    }
}