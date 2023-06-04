package Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {

    @Test
    public void testSetAndGetNome() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");

        assertEquals("Produto Teste", produto.getNome());
    }

    @Test
    public void testSetAndGetValor() {
        Produto produto = new Produto();
        produto.setValor(10.5);

        assertEquals(10.5, produto.getValor(), 0.0001);
    }

    @Test
    public void testSetAndGetTipo() {
        Produto produto = new Produto();
        produto.setTipo(1);

        assertEquals(1, produto.getTipo());
    }

    @Test
    public void testSetAndGetQuantidade() {
        Produto produto = new Produto();
        produto.setQuantidade(5);

        assertEquals(5, produto.getQuantidade());
    }

    @Test
    public void testSetAndGetMarca() {
        Produto produto = new Produto();
        produto.setMarca("Marca Teste");

        assertEquals("Marca Teste", produto.getMarca());
    }

    @Test
    public void testSetAndGetDescricao() {
        Produto produto = new Produto();
        produto.setDescricao("Descrição do produto");

        assertEquals("Descrição do produto", produto.getDescricao());
    }

    @Test
    public void testSetAndGetId() {
        Produto produto = new Produto();
        produto.setId(1);

        assertEquals(1, produto.getId());
    }
}
