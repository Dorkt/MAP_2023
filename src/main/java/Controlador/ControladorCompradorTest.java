package Controlador;
import Comprador.Comprador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControladorCompradorTest {

    private ControladorComprador controlador;

    @BeforeEach
    void setUp() {
        controlador = new ControladorComprador();
    }

    void testPersistirComprador() {
        Comprador comprador = new Comprador();
        comprador.getId();
        comprador.setNome("João");

        ControladorComprador controlador = new ControladorComprador();
        controlador.persistirComprador(comprador);

        List<Object> compradores = controlador.pegarTodosCompradores();
        boolean encontrouComprador = compradores.contains(comprador);

        assertFalse(encontrouComprador);
    }

    void testPegarTodosCompradores() {
        // Adicionar alguns compradores para teste
        Comprador comprador1 = new Comprador();
        comprador1.getId();
        comprador1.setNome("Comprador 1");

        Comprador comprador2 = new Comprador();
        comprador2.getId();
        comprador2.setNome("Comprador 2");

        controlador.persistirComprador(comprador1);
        controlador.persistirComprador(comprador2);

        // Verificar se todos os compradores foram retornados corretamente
        List<Object> compradores = controlador.pegarTodosCompradores();
        assertEquals(4, compradores.size());
        assertTrue(compradores.contains(comprador1));
        assertTrue(compradores.contains(comprador2));
    }

    @Test
    void testRemoverComprador() {
        Comprador comprador = new Comprador(/* dados do comprador */);
        controlador.persistirComprador(comprador);

        // Remover o comprador pelo ID
        controlador.removerComprador(comprador.getId());

        // Verificar se o comprador foi removido corretamente
        List<Object> compradores = controlador.pegarTodosCompradores();
        assertTrue(compradores.isEmpty());
    }
}
