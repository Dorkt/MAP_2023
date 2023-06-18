package Comprador;

import Controlador.Controlador;
import Produto.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorComprador extends Controlador {
    public void addProdutoAoCarrinho(int idProduto, Comprador compradorLogado) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String diretorioProjeto = System.getProperty("user.dir");
            String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;
            List<Produto> produtosExistentes = new ArrayList<>();

            String caminhoFinal = caminhoArquivo + "Produto.json";
            File arquivoJson = new File(caminhoFinal);
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType listType = typeFactory.constructCollectionType(List.class, Produto.class);
            List<Produto> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

            for (Produto objeto : objetosExistentes) {
                // Suponha que cada objeto tenha um método getId() que retorna o ID
                if (objeto.getId() == idProduto) {
                    objeto.exibirProduto();
                    compradorLogado.adicionarAoCarrinho(objeto);

                }
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
        }
        System.out.println("Produto encontrado e adicionado ao carrinho");
    }

    public Comprador selecionarCompradorLogado() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String diretorioProjeto = System.getProperty("user.dir");
            String caminhoFinal = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator + "loggedUser.json";

            File arquivoJson = new File(caminhoFinal);
            Comprador compradorExistente = objectMapper.readValue(arquivoJson, Comprador.class);
            return compradorExistente;
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao selecionar o comprador logado: " + e.getMessage());
        }

        return new Comprador();
    }
}
