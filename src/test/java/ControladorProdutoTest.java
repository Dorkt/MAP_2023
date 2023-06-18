import Produto.ControladorProduto;
import org.junit.jupiter.api.Test;

class ControladorProdutoTest {

    @Test
    void testComprarProduto() {
        // Preparação
        ControladorProduto controlador = new ControladorProduto();
        int idOfProduct = 1; // ID do produto para teste

        // Caso em que há quantidade disponível
        controlador.comprarProduto(idOfProduct);
        // Caso em que não há quantidade disponível
        controlador.comprarProduto(idOfProduct);
    }
}