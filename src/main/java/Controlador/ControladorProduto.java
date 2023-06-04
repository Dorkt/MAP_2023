package Controlador;
import Produto.Produto;
import Utils.Utils;
import java.util.List;

public class ControladorProduto {

    public void persistirProduto(Produto produto) {

        Utils utils = new Utils();
        utils.insertData(produto);

        System.out.println("Produto inserido com sucesso!");
    }

    public List<Object> pegarTodosProdutos() {

        Utils utils = new Utils();

        List<Object> produtos = utils.readData("Produto");
        return produtos;
    }
}