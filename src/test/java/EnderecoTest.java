import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class EnderecoTest {
    @Test
    public void testConstrutor() {
        String rua = "Rua A";
        String bairro = "Bairro B";
        String numero = "123";
        Endereco endereco = new Endereco(rua, bairro, numero);

        assertEquals(rua, endereco.getRua());
        assertEquals(bairro, endereco.getBairro());
        assertEquals(numero, endereco.getNumero());
    }

    @Test
    public void testSettersAndGetters() {
        Endereco endereco = new Endereco("Rua A", "Bairro B", "123");

        String novaRua = "Nova Rua";
        endereco.setRua(novaRua);
        assertEquals(novaRua, endereco.getRua());

        String novoBairro = "Novo Bairro";
        endereco.setBairro(novoBairro);
        assertEquals(novoBairro, endereco.getBairro());

        String novoNumero = "456";
        endereco.setNumero(novoNumero);
        assertEquals(novoNumero, endereco.getNumero());
    }

    @Test
    public void testToString() {
        String rua = "Rua A";
        String bairro = "Bairro B";
        String numero = "123";
        Endereco endereco = new Endereco(rua, bairro, numero);

        String expected = "Rua: " + rua + ", Bairro: " + bairro + ", Número: " + numero;
        assertEquals(expected, endereco.toString());
    }
}


