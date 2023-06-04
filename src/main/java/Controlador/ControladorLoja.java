package Controlador;
import Utils.Utils;
import Loja.Loja;
import java.util.List;

public class ControladorLoja {

    public void persistirLoja(Loja loja) {

        Utils utils = new Utils();
        utils.insertData(loja);

        System.out.println("Loja inserida com sucesso!");
    }

    public List<Object> pegarTodasLojas() {

        Utils utils = new Utils();

        List<Object> lojas = utils.readData("Loja");
        return lojas;
    }
}