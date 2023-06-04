package Utils;

import Comprador.Comprador;
import Produto.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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

    public void deleteData(int idToRemove, String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + "/src/database/";

        String caminhoFinal = caminhoArquivo + type + ".json";
        File arquivoJson = new File(caminhoFinal);

        try {
            // Ler os dados existentes do arquivo JSON
            TypeFactory typeFactory = objectMapper.getTypeFactory();

            if (type == "Loja") {
                CollectionType listType = typeFactory.constructCollectionType(List.class, Loja.class);

                List<Loja> objetosExistentes = objectMapper.readValue(arquivoJson, listType);
                // Procurar e remover o item com o ID desejado
                objetosExistentes.removeIf(objeto -> {
                    // Você precisa adaptar essa lógica de acordo com a estrutura do seu JSON
                    return objeto instanceof Loja && objeto.getId() == idToRemove;
                });

                objectMapper.writeValue(arquivoJson, objetosExistentes);
            } else if (type == "Produto") {
                CollectionType listType = typeFactory.constructCollectionType(List.class, Produto.class);

                List<Produto> objetosExistentes = objectMapper.readValue(arquivoJson, listType);
                // Procurar e remover o item com o ID desejado
                objetosExistentes.removeIf(objeto -> {
                    return objeto instanceof Produto && objeto.getId() == idToRemove;
                });

                objectMapper.writeValue(arquivoJson, objetosExistentes);
            } else if (type == "Comprador") {
                CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);

                List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);
                // Procurar e remover o item com o ID desejado
                objetosExistentes.removeIf(objeto -> {
                    return objeto instanceof Comprador && objeto.getId() == idToRemove;
                });

                objectMapper.writeValue(arquivoJson, objetosExistentes);
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao remover o dado do arquivo JSON: " + e.getMessage());
        }
    }

    public void updateData(String type, int idToUpdate, String newName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + "/src/database/";

        String caminhoFinal = caminhoArquivo + type + ".json";
        File arquivoJson = new File(caminhoFinal);

        try {
            // Criar o tipo concreto que representa a lista de objetos esperada
            TypeFactory typeFactory = objectMapper.getTypeFactory();

            if (type == "Loja") {
                CollectionType listType = typeFactory.constructCollectionType(List.class, Loja.class);

                List<Loja> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

                for (Loja objeto : objetosExistentes) {
                    if (objeto.getId() == idToUpdate) {
                        objeto.setNome(newName);
                        break;
                    }
                }
                objectMapper.writeValue(arquivoJson, objetosExistentes);
            } else if (type == "Produto") {
                CollectionType listType = typeFactory.constructCollectionType(List.class, Produto.class);

                List<Produto> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

                // Encontrar o objeto com o ID desejado e atualizar o nome
                for (Produto objeto : objetosExistentes) {
                    if (objeto.getId() == idToUpdate) {
                        objeto.setNome(newName);
                        break;
                    }
                }

                // Salvar os dados atualizados no arquivo JSON
                objectMapper.writeValue(arquivoJson, objetosExistentes);
            } else if (type == "Comprador") {
                CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);

                List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

                // Encontrar o objeto com o ID desejado e atualizar o nome
                for (Comprador objeto : objetosExistentes) {
                    if (objeto.getId() == idToUpdate) {
                        objeto.setNome(newName);
                        break;
                    }
                }

                // Salvar os dados atualizados no arquivo JSON
                objectMapper.writeValue(arquivoJson, objetosExistentes);
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao atualizar o dado no arquivo JSON: " + e.getMessage());
        }
    }
}
