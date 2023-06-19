package Controlador;

import Comprador.Comprador;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Loja.Loja;
import Produto.Produto;

public class Controlador {
    
    public void insertData(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;

        if (obj instanceof Loja) {
            try {
                String caminhoFinal = caminhoArquivo + "Loja.json";
                File arquivoJson = new File(caminhoFinal);

                List<Object> objetosExistentes = objectMapper.readValue(arquivoJson, List.class);

                List<Object> objetosAtualizados = new ArrayList<>(objetosExistentes);
                objetosAtualizados.add(obj);

                objectMapper.writeValue(arquivoJson, objetosAtualizados);
                System.out.println("Loja inserida com sucesso!");
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        } else if (obj instanceof Comprador) {
            try {
                String caminhoFinal = caminhoArquivo + "Comprador.json";
                File arquivoJson = new File(caminhoFinal);

                List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, List.class);

                List<Comprador> objetosAtualizados = new ArrayList<>(objetosExistentes);
                System.out.println("AAAAAAAAAAAAAAAAAAAA" + obj);
                objetosAtualizados.add((Comprador)obj);

                objectMapper.writeValue(arquivoJson, objetosAtualizados);
                System.out.println("Comprador inserido com sucesso!");
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
                System.out.println("Produto inserida com sucesso!");
            } catch (IOException e) {
                System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
            }
        }
    }

    public List<Object> readData(String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;
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
        String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;
        
        

        try {
            // Ler os dados existentes do arquivo JSON
            TypeFactory typeFactory = objectMapper.getTypeFactory();

            if (type == "Loja") {
                String caminhoFinal = caminhoArquivo + "Loja.json";
                File arquivoJson = new File(caminhoFinal);
                CollectionType listType = typeFactory.constructCollectionType(List.class, Loja.class);

                List<Loja> objetosExistentes = objectMapper.readValue(arquivoJson, listType);
                // Procurar e remover o item com o ID desejado
                objetosExistentes.removeIf(objeto -> {
                    // Você precisa adaptar essa lógica de acordo com a estrutura do seu JSON
                    return objeto instanceof Loja && objeto.getId() == idToRemove;
                });

                objectMapper.writeValue(arquivoJson, objetosExistentes);
                System.out.println("Loja removido com sucesso!");
            } else if (type == "Produto") {
                String caminhoFinal = caminhoArquivo + "Produto.json";
                File arquivoJson = new File(caminhoFinal);
                CollectionType listType = typeFactory.constructCollectionType(List.class, Produto.class);

                List<Produto> objetosExistentes = objectMapper.readValue(arquivoJson, listType);
                // Procurar e remover o item com o ID desejado
                objetosExistentes.removeIf(objeto -> {
                    return objeto instanceof Produto && objeto.getId() == idToRemove;
                });

                objectMapper.writeValue(arquivoJson, objetosExistentes);
                System.out.println("Produto removido com sucesso!");
            } else if (type == "Comprador") {
                String caminhoFinal = caminhoArquivo + "Comprador.json";
                File arquivoJson = new File(caminhoFinal);
                CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);

                List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);
                // Procurar e remover o item com o ID desejado
                objetosExistentes.removeIf(objeto -> {
                    return objeto instanceof Comprador && objeto.getId() == idToRemove;
                });

                objectMapper.writeValue(arquivoJson, objetosExistentes);
                System.out.println("Comprador removido com sucesso!");
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao remover o dado do arquivo JSON: " + e.getMessage());
        }
    }

    public void updateData(String type, int idToUpdate, String newName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;

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
                System.out.println("Loja atualizada com sucesso!");
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
                System.out.println("Produto atualizado com sucesso!");
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
                System.out.println("Comprador atualizado com sucesso!");
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao atualizar o dado no arquivo JSON: " + e.getMessage());
        }
    }
}
