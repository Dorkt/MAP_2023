package Loja;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LojaTest {

    @Test
    public void testSetAndGetNome() {
        Loja loja = new Loja();
        loja.setNome("Minha Loja");

        assertEquals("Minha Loja", loja.getNome());
    }

    @Test
    public void testSetAndGetEmail() {
        Loja loja = new Loja();
        loja.setEmail("loja@example.com");

        assertEquals("loja@example.com", loja.getEmail());
    }

    @Test
    public void testSetAndGetSenha() {
        Loja loja = new Loja();
        loja.setSenha("password");

        assertEquals("password", loja.getSenha());
    }

    @Test
    public void testSetAndGetCpfCnpj() {
        Loja loja = new Loja();
        loja.setCpfCnpj("123456789");

        assertEquals("123456789", loja.getCpfCnpj());
    }

    @Test
    public void testSetAndGetEndereco() {
        Loja loja = new Loja();
        loja.setEndereco("Rua A, 123");

        assertEquals("Rua A, 123", loja.getEndereco());
    }

    @Test
    public void testExibirLoja() {
        Loja loja = new Loja(1, "Minha Loja", "loja@example.com", "password", "123456789", "Rua A, 123");

        // Mock System.out.println()
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            @Override
            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        }));

        loja.exibirLoja();
        System.setOut(System.out);

        String expectedOutput = "Nome: Minha Loja" + System.lineSeparator() +
                "E-mail: loja@example.com" + System.lineSeparator() +
                "CPF/CNPJ: 123456789" + System.lineSeparator() +
                "Endereço: Rua A, 123" + System.lineSeparator();

        assertEquals(expectedOutput, output.toString(), "A saída não corresponde ao valor esperado.");
    }
}