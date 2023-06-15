import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o nome da imagem -> ");
        String nomeArquivo = sc.nextLine();

        String pathSrc = System.getProperty("user.dir") + "/src/imagens/";
        String pathArquivoPrincipal = pathSrc + nomeArquivo + ".pgm";
        String pathArquivoComprimido;
        String pathArquivoDescomprimido;

        System.out.println("Escolha o tipo de codificação:");
        System.out.println("1. LZW");
        System.out.println("2. Huffman");
        System.out.println("3. RLE");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        sc.close();

        switch (opcao) {
            case 1:
                pathArquivoComprimido = pathSrc + nomeArquivo + "-lzw.comp";
                pathArquivoDescomprimido = pathSrc + nomeArquivo + "-lzw.desc";
                lzw lzw = new lzw(pathArquivoPrincipal, pathArquivoComprimido, pathArquivoDescomprimido);
                lzw.comprime();
                break;
            case 2:
                pathArquivoComprimido = pathSrc + nomeArquivo + "-huffman.comp";
                pathArquivoDescomprimido = pathSrc + nomeArquivo + "-huffman.desc";
                huffman huffman = new huffman(pathArquivoPrincipal, pathArquivoComprimido, pathArquivoDescomprimido);
                huffman.comprime();
                break;
            case 3:
                pathArquivoComprimido = pathSrc + nomeArquivo + "-rle.comp";
                pathArquivoDescomprimido = pathSrc + nomeArquivo + "-rle.desc";
                rle rle = new rle(pathArquivoPrincipal, pathArquivoComprimido, pathArquivoDescomprimido);
                rle.comprime();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
