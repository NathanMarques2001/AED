package Trabalho;
import java.io.*;
import java.util.*;

public class LZW {

    private static final String NOME_ARQUIVO_A_SER_CODIFICADO = "C:/Users/processos03/Desktop/AED/AEDIII/src/Trabalho/imagens/venus.pgm";
    private static final String NOME_ARQUIVO_CODIFICADO = "C:/Users/processos03/Desktop/AED/AEDIII/src/Trabalho/imagens/venus-comp-lzw.pgm";
    private static final String NOME_ARQUIVO_DECODIFICADO = "C:/Users/processos03/Desktop/AED/AEDIII/src/Trabalho/imagens/venus-desc-lzw.pgm";

    public static void main(String[] args) throws IOException {

        encode();
        decode();

    }

    private static void decode() throws IOException {

        Map<Integer, String> dicionario = new HashMap<>();
        final List<Integer> SC;
        final List<String> sequencia = new ArrayList<>();
        int cont = 256;

        // inicializa o dicionário com os símbolos ASCII
        for (int i = 0; i < 256; i++) {
            dicionario.put(i, "" + (char) i);
        }

        SC = leArquivoCodificado();

        // imprime sequencia codificada
        for (Integer codigo : SC) {
            System.out.print(codigo + " ");
        }
        System.out.println();

        // decodificação
        int cW, pW;
        String P = "";
        char C;

        cW = SC.remove(0);
        sequencia.add(dicionario.get(cW));

        for (Integer codigo : SC) {
            pW = cW;
            cW = codigo;
            if (dicionario.containsKey(cW)) {
                String stringCw = dicionario.get(cW);
                sequencia.add(stringCw);
                P = dicionario.get(pW);
                C = stringCw.charAt(0);
                dicionario.put(cont, P + C);
                cont++;
            } else {
                String stringPw = dicionario.get(pW);
                P = stringPw;
                C = stringPw.charAt(0);
                sequencia.add(P + C);
                dicionario.put(cont, P + C);
                cont++;
            }
        }

        for (String caractere : sequencia) {
            System.out.print(caractere);
        }
        System.out.println();

        escreveNoArquivoEmTexto(sequencia, NOME_ARQUIVO_DECODIFICADO);
    }

    private static void encode() throws IOException {

        Map<String, Integer> dicionario = new HashMap<>();
        final List<String> sequencia;
        final List<Integer> SC = new ArrayList<>();
        int cont = 256;

        // inicializa o dicionário com os símbolos ASCII
        for (int i = 0; i < 256; i++) {
            System.out.println(i + "=" + (char) i);
            dicionario.put("" + (char) i, i);
        }

        // imprime dicionario criado chave = valor
        for (String key : dicionario.keySet()) {
            int value = dicionario.get(key);
            System.out.println(key + " = " + value);
        }

        // codificação
        sequencia = leArquivoASerCodificado();
        String C, P = "";

        for (String caractere : sequencia) {

            C = caractere;
            if (dicionario.containsKey(P + C)) {
                P = P + C;
            } else {
                SC.add(dicionario.get(P));
                dicionario.put(P + C, cont);
                P = C;
                cont++;
            }
        }
        SC.add(dicionario.get(P));

        // imprime a sequência de letras do arquivo
        for (String letra : sequencia) {
            System.out.print(letra);
        }
        System.out.println();

        // imprime a sequencia codificada
        for (Integer codigo : SC) {
            System.out.print(codigo + ",");
        }
        System.out.println();

        escreveNoArquivoEmBinario(SC, NOME_ARQUIVO_CODIFICADO);
    }

    private static void escreveNoArquivoEmTexto(List<String> Lista, String nomeArquivo) throws IOException {

        FileWriter fw = new FileWriter(nomeArquivo);
        PrintWriter out = new PrintWriter(fw);

        for (String codigo : Lista) {
            out.print(codigo);
        }
        out.close();
    }

    private static void escreveNoArquivoEmBinario(List<Integer> Lista, String nomeArquivo) throws IOException {

        FileOutputStream fout = new FileOutputStream(nomeArquivo);
        DataOutputStream out = new DataOutputStream(fout);

        out.writeInt(Lista.size());

        for (Integer codigo : Lista) {
            if (codigo != null)
                out.writeInt(codigo);
        }
        out.close();
    }

    public static List<Integer> leArquivoCodificado() throws IOException {

        final List<Integer> SC = new ArrayList<>();

        FileInputStream fin = new FileInputStream(NOME_ARQUIVO_CODIFICADO);
        DataInputStream in = new DataInputStream(fin);

        int tamanhoSequencia = in.readInt();
        for (int i = 0; i < tamanhoSequencia; i++) {
            int codigo = in.readInt();
            SC.add(codigo);
        }

        return SC;
    }

    public static List<String> leArquivoASerCodificado() throws IOException {

        final List<String> sequencia = new ArrayList<>();

        BufferedReader arq = new BufferedReader(new FileReader(NOME_ARQUIVO_A_SER_CODIFICADO));
        String linha = arq.readLine();

        while (linha != null) {
            String[] letras = linha.split("");
            Collections.addAll(sequencia, letras);
            sequencia.add("\n");
            linha = arq.readLine();
        }

        return sequencia;
    }

}
