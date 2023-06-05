package Loja;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LojaTest {

    private List<Loja> lojas;

    @BeforeEach
    public void setUp() {
        lojas = new ArrayList<>();
    }

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

    @Test
    public void testAdicionarLoja() {
        Loja loja = new Loja(1, "Minha Loja", "minhaloja@example.com", "senha123", "987654321", "Rua A, 123");

        Loja.adicionarLoja(loja);

        Assertions.assertFalse(lojas.contains(loja), "A loja não foi adicionada corretamente à lista de lojas");
    }

    @Test
    public void testRemoverLoja() {
        Loja loja = new Loja(1, "Minha Loja", "minhaloja@example.com", "senha123", "987654321", "Rua A, 123");

        lojas.add(loja);
        Loja.removerLoja(loja);

        Assertions.assertTrue(lojas.contains(loja), "A loja não foi removida corretamente da lista de lojas");
    }

    @Test
    public void testAtualizarLoja() {
        Loja loja = new Loja(1, "Minha Loja", "minhaloja@example.com", "senha123", "987654321", "Rua A, 123");

        lojas.add(loja);

        // Atualiza o nome da loja
        loja.setNome("Nova Loja");
        Loja.atualizarLoja(loja);

        // Verifica se a atualização foi realizada corretamente
        Loja lojaAtualizada = lojas.get(0);
        Assertions.assertEquals("Nova Loja", lojaAtualizada.getNome(), "O nome da loja não foi atualizado corretamente");
    }
}