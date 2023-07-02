package Loja;
import Comprador.Comprador;
import Controlador.Controlador;
import Produto.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ControladorLoja extends Controlador {

    public Loja selecionarLojaLogada() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String diretorioProjeto = System.getProperty("user.dir");
            String caminhoFinal = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator + "loggedUser.json";

            File arquivoJson = new File(caminhoFinal);
            Loja lojaExistente = objectMapper.readValue(arquivoJson, Loja.class);
            return lojaExistente;
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao selecionar a Loja logada: " + e.getMessage());
        }

        return new Loja();
    }

    public void updateAvaliacaoLoja(int idLojaToUpdate, double newAvaliacao) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;

        String caminhoFinal = caminhoArquivo + "Loja.json";
        File arquivoJson = new File(caminhoFinal);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAa" + newAvaliacao);

        try {
            // Criar o tipo concreto que representa a lista de objetos esperada
            TypeFactory typeFactory = objectMapper.getTypeFactory();

            CollectionType listType = typeFactory.constructCollectionType(List.class, Loja.class);

            List<Loja> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

            for (Loja objeto : objetosExistentes) {
                if (objeto.getId() == idLojaToUpdate) {
                    objeto.setAvaliacoes(newAvaliacao);
                    break;
                }
            }
            objectMapper.writeValue(arquivoJson, objetosExistentes);
            System.out.println("Avaliação da loja vendedora atualizada com sucesso!");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao atualizar o dado da loja: " + e.getMessage());
        }
    }
}
