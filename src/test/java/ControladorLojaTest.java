import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import Loja.Loja;
import Loja.ControladorLoja;

import java.util.List;


public class ControladorLojaTest {
    private ControladorLoja controlador;

    @BeforeEach
    void setUp() {
        controlador = new ControladorLoja();
    }

    @Test
    void testPersistirControlador() {
        Loja loja = new Loja("Loja nova 1", "loja1@mail.com", "loja1", "111111", "Rua 1");

        ControladorLoja controlador = new ControladorLoja();
        controlador.insertData(loja);

        List<Object> lojas = controlador.readData("Loja");
        boolean encontrouComprador = lojas.contains(loja);

        assertFalse(encontrouComprador);
    }

    @Test
    void testPegarTodosAsLojas() {
        // Adicionar alguns compradores para teste
        Loja loja2 = new Loja("Loja nova 2", "loja2@mail.com", "loja2", "222222", "Rua 2");
        controlador.insertData(loja2);
        Loja loja3 = new Loja("Loja nova 3", "loja3@mail.com", "loja3", "333333", "Rua 3");
        controlador.insertData(loja3);

        // Verificar se todos os compradores foram retornados corretamente
        List<Object> lojas = controlador.readData("Loja");
        assertEquals(3, lojas.size());
    }

    @Test
    void testRemoverLoja() {
        Loja loja4 = new Loja("Loja nova 4", "loja4@mail.com", "loja4", "4444444", "Rua 4");
        controlador.insertData(loja4);

        // Remover o comprador pelo ID
        controlador.deleteData(loja4.getId(), "Loja");

        // Verificar se o comprador foi removido corretamente
        List<Object> lojas = controlador.readData("Loja");
        assertFalse(lojas.contains(loja4));
        }
    }
