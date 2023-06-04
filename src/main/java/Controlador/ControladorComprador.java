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

    public List<Object> pegarTodosCompradores() {

        Utils utils = new Utils();

        List<Object> compradores = utils.readData("Comprador");
        return compradores;
    }
}