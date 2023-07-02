import Produto.Produto;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProdutoTest {

    @Test
    public void testConstructorAndGetters() {
        Produto produto = new Produto("Nome do Produto", 10.0, "Tipo do Produto", 5, "Marca", "Descrição", null);
        assertEquals("Nome do Produto", produto.getNome());
        assertEquals(10.0, produto.getValor());
        assertEquals("Tipo do Produto", produto.getTipo());
        assertEquals(5, produto.getQuantidade());
        assertEquals("Marca", produto.getMarca());
        assertEquals("Descrição", produto.getDescricao());
    }

    @Test
    public void testSetters() {
        Produto produto = new Produto();
        produto.setNome("Nome do Produto");
        produto.setValor(10.0);
        produto.setTipo("Tipo do Produto");
        produto.setQuantidade(5);
        produto.setMarca("Marca");
        produto.setDescricao("Descrição");

        assertEquals(0, produto.getId());
        assertEquals("Nome do Produto", produto.getNome());
        assertEquals(10.0, produto.getValor());
        assertEquals("Tipo do Produto", produto.getTipo());
        assertEquals(5, produto.getQuantidade());
        assertEquals("Marca", produto.getMarca());
        assertEquals("Descrição", produto.getDescricao());
    }

    @Test
    public void testExibirProduto() {
        Produto produto = new Produto("Nome do Produto", 10.0, "Tipo do Produto", 5, "Marca", "Descrição", null);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        produto.exibirProduto();

        System.setOut(System.out);

        String expectedOutput = "ID: 1\nNome: Nome do Produto\nValor: R$10.0\nTipo de produto Tipo do Produto\nQuantidade: 5\nMarca: Marca\nDescrição: Descrição\n";
        assertNotEquals(expectedOutput, outContent.toString());
    }
}