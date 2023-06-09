package Comprador;

import Compra.Compra;
import Controlador.Controlador;
import Loja.ControladorLoja;
import Produto.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.naming.ldap.Control;
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

    public void adicionarProdutoAoHistorico(Compra prod, Comprador comp) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoFinal = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator + "Comprador.json";
        File arquivoJson = new File(caminhoFinal);

        // Criar o tipo concreto que representa a lista de objetos esperada
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        try {
            CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);

            List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

            // Encontrar o objeto com o ID desejado e atualizar o nome
            for (Comprador comprador : objetosExistentes) {
                if (comprador.getId() == comp.getId()) {
                    comprador.adicionarCompra(prod);
                    comprador.adicionarMaisPonto();
                    break;
                }
            }
            // Salvar os dados atualizados no arquivo JSON
            objectMapper.writeValue(arquivoJson, objetosExistentes);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao adicionar um produto ao historico: " + e.getMessage());
        }
    }

    public void mostrarHistoricoDeCompras(Comprador comp) {
        int contador = 1;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoFinal = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator + "Comprador.json";
        File arquivoJson = new File(caminhoFinal);

        // Criar o tipo concreto que representa a lista de objetos esperada
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        try {
            CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);

            List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);
            List<Compra> produtos = new ArrayList<>();

            // Encontrar o objeto com o ID desejado e atualizar o nome
            for (Comprador comprador : objetosExistentes) {
                if (comprador.getId() == comp.getId()) {
                    produtos = comprador.getHistoricoComprasDeCompras();
                }
            }

            for (Produto prod : produtos) {
                System.out.println("Histórico de compras");
                System.out.println("Compra " + contador);
                prod.exibirProduto();
                System.out.println("--------------------------------");
                contador++;
            }
            // Salvar os dados atualizados no arquivo JSON
            objectMapper.writeValue(arquivoJson, objetosExistentes);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao atualizar o dado no arquivo JSON: " + e.getMessage());
        }
    }

    public void avaliarCompra(Integer prodId, Comprador comp, double nota, String comentario) {
        ControladorLoja controladorLoja = new ControladorLoja();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String diretorioProjeto = System.getProperty("user.dir");
        String caminhoFinal = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator + "Comprador.json";
        File arquivoJson = new File(caminhoFinal);

        // Criar o tipo concreto que representa a lista de objetos esperada
        TypeFactory typeFactory = objectMapper.getTypeFactory();

        try {
            CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);

            List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

            // Encontrar o objeto com o ID desejado e atualizar a avaliação da compra
            for (Comprador comprador : objetosExistentes) {
                if (comprador.getId() == comp.getId()) {
                    List<Compra> compras = comprador.getHistoricoComprasDeCompras();
                    for (Compra comprasFeitas: compras) {
                        if (comprasFeitas.getId() == prodId) {
                            System.out.println("Aaaaa 2" + nota);
                            comprasFeitas.setAvaliacao(nota);
                            comprasFeitas.setComentario(comentario);
                            comprador.adicionarMaisPonto();
                            controladorLoja.updateAvaliacaoLoja(comprasFeitas.getIdLoja(), nota);
                            break;
                        }
                    }
                    break;
                }
            }
            // Salvar os dados atualizados no arquivo JSON
            objectMapper.writeValue(arquivoJson, objetosExistentes);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao adicionar uma avaliação à compra: " + e.getMessage());
        }
    }

    public Integer getTotalComprasNoSistema() {
        Integer size = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String diretorioProjeto = System.getProperty("user.dir");
            String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;
            List<Comprador> produtosExistentes = new ArrayList<>();

            String caminhoFinal = caminhoArquivo + "Comprador.json";
            File arquivoJson = new File(caminhoFinal);
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);
            List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

            for (Comprador comprador : objetosExistentes) {
                // Suponha que cada objeto tenha um método getId() que retorna o ID
                size += comprador.totalCompras();
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
        }
        return size;
    }

    public Integer getPontuacaoDoUsuarioLogado(Integer id) {
        Integer pontuacao = 0;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String diretorioProjeto = System.getProperty("user.dir");
            String caminhoArquivo = diretorioProjeto + File.separator + "src" + File.separator + "database" + File.separator;
            List<Comprador> produtosExistentes = new ArrayList<>();

            String caminhoFinal = caminhoArquivo + "Comprador.json";
            File arquivoJson = new File(caminhoFinal);
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType listType = typeFactory.constructCollectionType(List.class, Comprador.class);
            List<Comprador> objetosExistentes = objectMapper.readValue(arquivoJson, listType);

            for (Comprador comprador : objetosExistentes) {
                if (comprador.getId() == id) {
                    pontuacao = comprador.getPontuacao();
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao salvar os dados no arquivo JSON: " + e.getMessage());
        }
        return pontuacao;
    }
}
