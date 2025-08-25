import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.json.XML;

public class Adapter {

    // Número de espaços para indentação no JSON
    private static final int INDENT_FACTOR = 4;

    public static void main(String[] args) {
        String inputFileName = "dados.xml";
        String outputFileName = "dados.json";

        try {
            // Lê todo o conteúdo do arquivo XML como uma String
            String xmlContent = new String(Files.readAllBytes(Paths.get(inputFileName)));

            // Converte XML para JSONObject
            JSONObject jsonObject = XML.toJSONObject(xmlContent);

            // Formata o JSON com indentação
            String jsonPretty = jsonObject.toString(INDENT_FACTOR);

            // Escreve o conteúdo no arquivo dados.json (cria ou sobrescreve)
            try (FileWriter fileWriter = new FileWriter(new File(outputFileName))) {
                fileWriter.write(jsonPretty);
                System.out.println("Arquivo '" + outputFileName + "' criado com sucesso!");
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever arquivos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro durante a conversão XML -> JSON: " + e.getMessage());
        }
    }
}
