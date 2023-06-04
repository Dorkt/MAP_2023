package Controlador;
import Comprador.Comprador;
import Utils.Utils;
import java.util.List;

public class ControladorComprador {

    public void persistirComprador(Comprador comprador) {

        Utils utils = new Utils();
        utils.insertData(comprador);

        System.out.println("Comprador inserido com sucesso!");
    }

    public List<Comprador> pegarTodosCompradores() {

        Utils utils = new Utils();

        List<Comprador> compradores = utils.readData("Comprador");
        return compradores;
    }

    public void removerComprador(int id) {
        Utils utils = new Utils();
        utils.deleteData(id, "Comprador");

        System.out.println("Comprador removido com sucesso!");
    }

    public void atualizarNomeComprador(int id, String novoNome) {
        Utils utils = new Utils();
        utils.updateData("Comprador", id, novoNome);

        System.out.println("Comprador atualizado com sucesso!");
    }
}