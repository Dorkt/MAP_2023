package Loja;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import Controlador.Controlador;

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

}
