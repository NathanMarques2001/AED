import java.io.*;
import java.util.*;

public class rle {

    private static String NOME_ARQUIVO_A_SER_CODIFICADO;
    private static String NOME_ARQUIVO_CODIFICADO;
    private static String NOME_ARQUIVO_DECODIFICADO;

    public rle(String pathArquivo, String pathArquivoComprimido, String pathArquivoDescomprimido) {
        this.NOME_ARQUIVO_A_SER_CODIFICADO = pathArquivo;
        this.NOME_ARQUIVO_CODIFICADO = pathArquivoComprimido;
        this.NOME_ARQUIVO_DECODIFICADO = pathArquivoDescomprimido;
    }

    public void comprime() throws IOException {
        compressao();
        descompressao();
    }

    private static void compressao() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(NOME_ARQUIVO_A_SER_CODIFICADO));
        BufferedWriter out = new BufferedWriter(new FileWriter(NOME_ARQUIVO_CODIFICADO));

        // Cabeçalho
        for (int i = 0; i < 4; i++) {
            out.write(in.readLine());
            out.newLine();
        }

        List<Integer> pgmProcessado = new ArrayList<>();

        String linha;
        while ((linha = in.readLine()) != null) {
            String[] valores = linha.split("\\s+");
            for (String valor : valores) {
                if (!valor.isEmpty()) {
                    pgmProcessado.add(Integer.parseInt(valor));
                }
            }
        }
        int count = 1;

        for (int i = 0; i < pgmProcessado.size() - 1; i++) {
            if (pgmProcessado.get(i).intValue() == pgmProcessado.get(i + 1).intValue()) {
                count++;
                if (i == pgmProcessado.size() - 2) {
                    out.write(count + "@" + pgmProcessado.get(i) + " ");
                }
            } else {
                out.write(count + "@" + pgmProcessado.get(i) + " ");
                if (count > 1) {
                    count = 1;
                }
            }
        }
        System.out.println("ARQUIVO COMPRIMIDO!");
        in.close();
        out.close();
    }

    private static void descompressao()
            throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(NOME_ARQUIVO_CODIFICADO));
        BufferedWriter out = new BufferedWriter(new FileWriter(NOME_ARQUIVO_DECODIFICADO));

        String linha;

        for (int i = 0; i < 4; i++) {
            out.write(in.readLine());
            out.newLine();
        }

        linha = in.readLine();
        String[] valores = linha.split(" ");

        for (int i = 0; i < valores.length; i++) {
            int indexArroba = valores[i].indexOf("@");
            if (indexArroba >= 0 && indexArroba < valores[i].length() - 1) {
                int quantidade = Integer.parseInt(valores[i].substring(0, indexArroba));
                int atual = Integer.parseInt(valores[i].substring(indexArroba + 1));
                for (int j = 0; j < quantidade; j++) {
                    if ((i == valores.length - 1) && (j == quantidade - 1)) {
                        // Último pixel descomprimido, não escrever nova linha
                        out.write(atual + " ");
                    } else {
                        out.write(atual + " ");
                    }
                }
            }
        }
        System.out.println("ARQUIVO DESCOMPRIMIDO!");
        in.close();
        out.close();
    }
}
