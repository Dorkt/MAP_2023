import Loja.Loja;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LojaTest {

    @Test
    public void testConstructorAndGetters() {
        Loja loja = new Loja("Nome da Loja", "loja@example.com", "senha123", "123456789", "Rua A, 123");
        assertEquals("Nome da Loja", loja.getNome());
        assertEquals("loja@example.com", loja.getEmail());
        assertEquals("senha123", loja.getSenha());
        assertEquals("123456789", loja.getCpfCnpj());
        assertEquals("Rua A, 123", loja.getEndereco());
    }

    @Test
    public void testSetters() {
        Loja loja = new Loja();
        loja.setNome("Nome da Loja");
        loja.setEmail("loja@example.com");
        loja.setSenha("senha123");
        loja.setCpfCnpj("123456789");
        loja.setEndereco("Rua A, 123");

        assertEquals("Nome da Loja", loja.getNome());
        assertEquals("loja@example.com", loja.getEmail());
        assertEquals("senha123", loja.getSenha());
        assertEquals("123456789", loja.getCpfCnpj());
        assertEquals("Rua A, 123", loja.getEndereco());
    }

    @Test
    public void testExibirLoja() {
        Loja loja = new Loja("Nome da Loja", "loja@example.com", "senha123", "123456789", "Rua A, 123");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        loja.exibirLoja();

        System.setOut(System.out);

        String expectedOutput = "ID: 1" + System.lineSeparator() +
                "Nome: Nome da Loja" + System.lineSeparator() +
                "E-mail: loja@example.com" + System.lineSeparator() +
                "CPF/CNPJ: 123456789" + System.lineSeparator() +
                "Endereço: Rua A, 123" + System.lineSeparator();
        assertNotEquals(expectedOutput, outContent.toString());
    }
}