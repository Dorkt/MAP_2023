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

    public void removerProduto(int id) {
        Utils utils = new Utils();
        utils.deleteData(id, "Produto");

        System.out.println("Produto removido com sucesso!");
    }

    public void atualizarNomeProduto(int id, String novoNome) {
        Utils utils = new Utils();
        utils.updateData("Produto", id, novoNome);

        System.out.println("Nome da Produto atualizado com sucesso!");
    }
}