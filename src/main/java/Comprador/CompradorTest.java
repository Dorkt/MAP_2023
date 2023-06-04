package Comprador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompradorTest {

    @Test
    public void testSetAndGetNome() {
        Comprador comprador = new Comprador();
        comprador.setNome("João");

        assertEquals("João", comprador.getNome());
    }

    @Test
    public void testSetAndGetEmail() {
        Comprador comprador = new Comprador();
        comprador.setEmail("joao@example.com");

        assertEquals("joao@example.com", comprador.getEmail());
    }

    @Test
    public void testSetAndGetSenha() {
        Comprador comprador = new Comprador();
        comprador.setSenha("password");

        assertEquals("password", comprador.getSenha());
    }

    @Test
    public void testSetAndGetCpf() {
        Comprador comprador = new Comprador();
        comprador.setCpf("123456789");

        assertEquals("123456789", comprador.getCpf());
    }

    @Test
    public void testSetAndGetEndereco() {
        Comprador comprador = new Comprador();
        comprador.setEndereco("Rua A, 123");

        assertEquals("Rua A, 123", comprador.getEndereco());
    }

    @Test
    public void testExibirComprador() {
        Comprador comprador = new Comprador("João", "joao@example.com", "password", "123456789", "Rua A, 123");

        // Mock System.out.println()
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            @Override
            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        }));

        comprador.exibirComprador();
        System.setOut(System.out);

        String expectedOutput = "Nome: João" + System.lineSeparator() +
                "E-mail: joao@example.com" + System.lineSeparator() +
                "CPF: 123456789" + System.lineSeparator() +
                "Endereço: Rua A, 123" + System.lineSeparator();

        assertEquals(expectedOutput, output.toString(), "A saída não corresponde ao valor esperado.");
    }
}
