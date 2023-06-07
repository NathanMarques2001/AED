package Trabalho;

import java.io.*;
import java.util.*;

public class Compressor {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.print("Insira o nome da imagem -> ");
		String nomeArquivo = sc.nextLine();
		sc.close();

		String pathArquivoPrincipal = "src/Trabalho/imagens/" + nomeArquivo + ".pgm";
		String pathArquivoComprimido = "src/Trabalho/imagens/" + nomeArquivo + "-comp-RLE.pgm";

		FormataPGM(pathArquivoPrincipal, pathArquivoComprimido);
		ComprimePGM(pathArquivoComprimido);
	}

	private static void FormataPGM(String pathArquivoPrincipal, String pathNovoArquivo) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(pathArquivoPrincipal));
		BufferedWriter out = new BufferedWriter(new FileWriter(pathNovoArquivo));

		String line;

		while ((line = in.readLine()) != null) {
			String linhaModificada = line.replaceAll("\\s+", " ");
			out.write(linhaModificada);
			out.newLine();
		}

		in.close();
		out.close();
	}

	private static void ComprimePGM(String pathArquivoComprimido) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(pathArquivoComprimido));

		String numeroMagico = in.readLine();
		String comentario = in.readLine();
		String[] dimensoes = in.readLine().split(" ");
		int largura = Integer.parseInt(dimensoes[0]);
		int altura = Integer.parseInt(dimensoes[1]);
		String valorMaximo = in.readLine();

		List<Integer> pgmProcessado = new ArrayList<>();

		String linha;
		while ((linha = in.readLine()) != null) {
			String[] valores = linha.split(" ");
			for (String valor : valores) {
				if (valor != "") {
					pgmProcessado.add(Integer.parseInt(valor));
				}
			}
		}

		int count = 1;
		String RLE = "'" + numeroMagico + "," + comentario + "," + largura + "," + altura + "," + valorMaximo + ","
				+ "'";

		for (int i = 0; i < pgmProcessado.size() - 1; i++) {
			if (pgmProcessado.get(i).intValue() == pgmProcessado.get(i + 1).intValue()) {
				count++;
			} else {
				RLE += count + "@" + pgmProcessado.get(i).intValue();
				if (count > 1) {
					count = 1;
				}
			}
		}

		in.close();

		BufferedWriter out = new BufferedWriter(new FileWriter(pathArquivoComprimido));
		out.write(RLE);
		out.close();
	}

}
