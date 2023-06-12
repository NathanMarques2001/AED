package Trabalho;

import java.io.*;
import java.util.*;

public class RLE {
    public static void main(String[] args) throws IOException {
        // Pega o path do diretório pai
        String pathSrc = System.getProperty("user.dir") + "/AEDIII/src/Trabalho/imagens/";

        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o nome da imagem -> ");
        String nomeArquivo = sc.nextLine();
        sc.close();

        String pathArquivoPrincipal = pathSrc + nomeArquivo + ".pgm";
        String pathArquivoComprimido = pathSrc + nomeArquivo + "-comp-RLE.pgm";
        String pathArquivoDescomprimido = pathSrc + nomeArquivo + "-desc-RLE.pgm";

        Comprime(pathArquivoPrincipal, pathArquivoComprimido);
        Descomprime(pathArquivoComprimido, pathArquivoDescomprimido);
    }

    private static void Comprime(String pathArquivoPrincipal, String pathArquivoComprimido) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(pathArquivoPrincipal));
        BufferedWriter out = new BufferedWriter(new FileWriter(pathArquivoComprimido));

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
        in.close();
        out.close();
        System.out.println("Arquivo comprimido!");
    }

    private static void Descomprime(String pathArquivoPrincipal, String pathArquivoDescomprimido)
            throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(pathArquivoPrincipal));
        BufferedWriter out = new BufferedWriter(new FileWriter(pathArquivoDescomprimido));

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
        in.close();
        out.close();
        System.out.println("Arquivo descomprimido!");
    }
}
