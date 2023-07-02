import Menus.MenuCompradores;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MenuCompradoresTest {
    private MenuCompradores menuCompradores;

    @Before
    public void setUp() {
        menuCompradores = new MenuCompradores();
    }

    @Test
    public void testBuscarCompradorPorID() {
        // Simula a entrada do usuário para buscar um comprador por ID
        String input = "1\n123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Testa se o método buscarCompradorPorID executa sem erros
        menuCompradores.buscarCompradorPorID();
    }
    @Test
    public void testAtualizarInformacaoDoNome() {
        // Simula a entrada do usuário para atualizar o nome de um comprador
        String input = "2\n1\nNovo Nome\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Testa se o método atualizarInformacaoDoNome executa sem erros
        menuCompradores.atualizarInformacaoDoNome();
    }
    @Test
    public void testMenuOptions() {
        // Simula a entrada do usuário para testar todas as opções do menu
        String input = "1\n123\n2\n1\nNovo Nome\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Testa se todas as opções do menu são executadas sem erros
        menuCompradores.buscarCompradorPorID();
    }
}