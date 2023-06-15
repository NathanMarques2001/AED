import java.io.*;
import java.util.*;

public class lzw {

    private static String NOME_ARQUIVO_A_SER_CODIFICADO;
    private static String NOME_ARQUIVO_CODIFICADO;
    private static String NOME_ARQUIVO_DECODIFICADO;

    public lzw(String pathArquivo, String pathArquivoComprimido, String pathArquivoDescomprimido){
        this.NOME_ARQUIVO_A_SER_CODIFICADO = pathArquivo;
        this.NOME_ARQUIVO_CODIFICADO = pathArquivoComprimido;
        this.NOME_ARQUIVO_DECODIFICADO = pathArquivoDescomprimido;
    }

    public void comprime() throws IOException{
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

        System.out.println("ARQUIVO DESCOMPRIMIDO!");

        escreveNoArquivoEmTexto(sequencia, NOME_ARQUIVO_DECODIFICADO);
    }

    private static void encode() throws IOException {

        Map<String, Integer> dicionario = new HashMap<>();
        final List<String> sequencia;
        final List<Integer> SC = new ArrayList<>();
        int cont = 256;

        // inicializa o dicionário com os símbolos ASCII
        for (int i = 0; i < 256; i++) {
            dicionario.put("" + (char) i, i);
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

        System.out.println("ARQUIVO COMPRIMIDO!");

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
