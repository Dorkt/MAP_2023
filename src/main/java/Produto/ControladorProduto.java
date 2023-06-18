package Produto;

import Controlador.Controlador;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ControladorProduto extends Controlador {

    public void comprarProduto(int idOfProduct) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoFinal = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator + "Produto.json";
        File arquivoJson = new File(caminhoFinal);

        // Criar o tipo concreto que representa a lista de objetos esperada
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        try {
            CollectionType listType = typeFactory.constructCollectionType(List.class, Produto.class);

            List<Produto> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

            // Encontrar o objeto com o ID desejado e atualizar o nome
            for (Produto objeto : objetosExistentes) {
                if (objeto.getId() == idOfProduct) {
                    int quantidadeDeProdutos = objeto.getQuantidade();
                    if (quantidadeDeProdutos == 0) {
                        System.out.println(objeto.getNome());
                        throw new IllegalArgumentException("Não existem quantidade em estoque desse produto.");
                    } else {
                        objeto.setQuantidade(quantidadeDeProdutos - 1);
                        System.out.println(objeto.getNome());
                        break;
                    }
                }
            }
            // Salvar os dados atualizados no arquivo JSON
            objectMapper.writeValue(arquivoJson, objetosExistentes);
            System.out.println("Produto comprado com sucesso!");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao atualizar o dado no arquivo JSON: " + e.getMessage());
        }
    }
}
