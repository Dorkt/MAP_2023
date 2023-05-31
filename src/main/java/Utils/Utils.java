package Utils;

import Comprador.Comprador;
import Produto.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Loja.Loja;

public class Utils {
    public void insertData(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + "/src/database/";

        if (obj instanceof Loja) {
            try {
                String caminhoFinal = caminhoArquivo + "Loja.json";
                File arquivoJson = new File(caminhoFinal);

                List<Object> objetosExistentes = objectMapper.readValue(arquivoJson, List.class);

                List<Object> objetosAtualizados = new ArrayList<>(objetosExistentes);
                objetosAtualizados.add(obj);

                objectMapper.writeValue(arquivoJson, objetosAtualizados);
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        } else if (obj instanceof Comprador) {
            try {
                String caminhoFinal = caminhoArquivo + "Comprador.json";
                File arquivoJson = new File(caminhoFinal);

                List<Object> objetosExistentes = objectMapper.readValue(arquivoJson, List.class);

                List<Object> objetosAtualizados = new ArrayList<>(objetosExistentes);
                objetosAtualizados.add(obj);

                objectMapper.writeValue(arquivoJson, objetosAtualizados);
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        } else if (obj instanceof Produto) {
            try {
                String caminhoFinal = caminhoArquivo + "Produto.json";
                File arquivoJson = new File(caminhoFinal);

                List<Object> objetosExistentes = objectMapper.readValue(arquivoJson, List.class);

                List<Object> objetosAtualizados = new ArrayList<>(objetosExistentes);
                objetosAtualizados.add(obj);

                objectMapper.writeValue(arquivoJson, objetosAtualizados);
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        }

        System.out.println("Dados inseridos com sucesso");
    }

    public List<Object> readData(String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + "/src/database/";
        List<Object> objetosExistentes = new ArrayList<>();

        if (type == "Loja") {
            String caminhoFinal = caminhoArquivo + "Loja.json";
            File arquivoJson = new File(caminhoFinal);
            try {
                objetosExistentes = objectMapper.readValue(arquivoJson, List.class);
                return objetosExistentes;
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        } else if (type == "Comprador") {
            String caminhoFinal = caminhoArquivo + "Comprador.json";
            File arquivoJson = new File(caminhoFinal);
            try {
                objetosExistentes = objectMapper.readValue(arquivoJson, List.class);
                return objetosExistentes;
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        } else if (type == "Produto") {
            String caminhoFinal = caminhoArquivo + "Produto.json";
            File arquivoJson = new File(caminhoFinal);
            try {
                objetosExistentes = objectMapper.readValue(arquivoJson, List.class);
                return objetosExistentes;
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        }
        return objetosExistentes;
    }
}
