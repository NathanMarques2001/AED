import java.io.*;
import java.util.*;

public class huffman {

    private static class No implements Comparable<No> {
        char ch;
        int freq;
        No esquerda, direita;

        No(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            esquerda = direita = null;
        }

        @Override
        public int compareTo(No o) {
            return freq - o.freq;
        }
    }

    private static String NOME_ARQUIVO_A_SER_CODIFICADO;
    private static String NOME_ARQUIVO_CODIFICADO;
    private static String NOME_ARQUIVO_DECODIFICADO;
    public huffman(String pathArquivo, String pathArquivoComprimido, String pathArquivoDescomprimido){
        this.NOME_ARQUIVO_A_SER_CODIFICADO = pathArquivo;
        this.NOME_ARQUIVO_CODIFICADO = pathArquivoComprimido;
        this.NOME_ARQUIVO_DECODIFICADO = pathArquivoDescomprimido;
    }

    public void comprime() throws IOException {

        FileInputStream in = new FileInputStream(NOME_ARQUIVO_A_SER_CODIFICADO);
        byte[] data = new byte[in.available()];
        in.read(data);
        in.close();

        // Criar uma tabela de frequência para o arquivo de entrada .pgm
        Map<Byte, Integer> tabelaFrequencia = new HashMap<>();
        for (byte b : data) {
            tabelaFrequencia.put(b, tabelaFrequencia.getOrDefault(b, 0) + 1);
        }

        // Criar uma árvore de Huffman a partir da tabela de frequência
        List<No> nos = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : tabelaFrequencia.entrySet()) {
            nos.add(new No((char) (entry.getKey() & 0xFF), entry.getValue()));
        }
        Collections.sort(nos);

        while (nos.size() > 1) {
            No esquerda = nos.remove(0);
            No direita = nos.remove(0);
            No pai = new No('\0', esquerda.freq + direita.freq);
            pai.esquerda = esquerda;
            pai.direita = direita;
            nos.add(pai);
            Collections.sort(nos);
        }

        // Criar um código Huffman para cada caractere no arquivo de entrada .pgm
        Map<Byte, String> codigosHuffman = new HashMap<>();
        percorrer(nos.get(0), "", codigosHuffman);

        // Comprimir o arquivo de entrada .pgm usando os códigos Huffman
        byte[] comprimido = comprimir(data, codigosHuffman);

        // Escrever o arquivo comprimido .pgm no arquivo de saída
        FileOutputStream out = new FileOutputStream(NOME_ARQUIVO_CODIFICADO);
        out.write(comprimido);
        out.close();

        // Decodificar os dados comprimidos
        byte[] dadosDecodificados = decodificar(comprimido, nos.get(0));

        // Escrever os dados decodificados no arquivo de saída
        FileOutputStream decodedOutput = new FileOutputStream(NOME_ARQUIVO_DECODIFICADO);
        decodedOutput.write(dadosDecodificados);
        decodedOutput.close();
    }

    private static void percorrer(No no, String codigo, Map<Byte, String> codigosHuffman) {
        if (no.esquerda == null && no.direita == null) {
            codigosHuffman.put((byte) (no.ch & 0xFF), codigo);
        } else {
            percorrer(no.esquerda, codigo + "0", codigosHuffman);
            percorrer(no.direita, codigo + "1", codigosHuffman);
        }
    }

    private static byte[] comprimir(byte[] input, Map<Byte, String> codigosHuffman) {
        StringBuilder comprimido = new StringBuilder();
        for (byte b : input) {
            comprimido.append(codigosHuffman.get(b));
        }
        String stringComprimida = comprimido.toString();
        byte[] bytesComprimidos = new byte[(stringComprimida.length() + 7) / 8];
        for (int i = 0; i < stringComprimida.length(); i += 8) {
            String byteString = stringComprimida.substring(i, Math.min(i + 8, stringComprimida.length()));
            bytesComprimidos[i / 8] = (byte) Integer.parseInt(byteString, 2);
        }
        System.out.println("ARQUIVO COMPRIMIDO!");
        return bytesComprimidos;
    }

    private static byte[] decodificar(byte[] dadosComprimidos, No raiz) {
        StringBuilder stringDecodificada = new StringBuilder();
        No atual = raiz;
        for (byte dadoComprimido : dadosComprimidos) {
            String stringBinaria = String.format("%8s", Integer.toBinaryString(dadoComprimido & 0xFF)).replace(' ',
                    '0');
            for (int i = 0; i < 8; i++) {
                char bit = stringBinaria.charAt(i);
                if (bit == '0') {
                    atual = atual.esquerda;
                } else {
                    atual = atual.direita;
                }
                if (atual.esquerda == null && atual.direita == null) {
                    stringDecodificada.append(atual.ch);
                    atual = raiz;
                }
            }
        }
        System.out.println("ARQUIVO DESCOMPRIMIDO!");
        return stringDecodificada.toString().getBytes();
    }
}
