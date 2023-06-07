package Trabalho;

import java.io.*;
import java.util.Scanner;

public class RLE_Descompressor {

	public static void main(String[] args) throws IOException {

		// Pega o path do diretório pai
		String pathSrc = System.getProperty("user.dir") + "/AEDIII/src/Trabalho/imagens/";

		Scanner sc = new Scanner(System.in);

		System.out.print("Insira o nome da imagem -> ");
		String nomeArquivo = sc.nextLine();
		sc.close();

		String pathArquivoPrincipal = pathSrc + nomeArquivo + "-comp-RLE.pgm";
		String pathArquivoDescomprimido = pathSrc + nomeArquivo + "-desc-RLE.pgm";

		DescomprimePGM(pathArquivoPrincipal, pathArquivoDescomprimido);
	}

	private static void DescomprimePGM(String pathArquivoPrincipal, String pathArquivoDescomprimido)
			throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(pathArquivoPrincipal));
		BufferedWriter out = new BufferedWriter(new FileWriter(pathArquivoDescomprimido));

		String linha = in.readLine();

		int inicioCabecalho = linha.indexOf("'");
		int finalCabecalho = linha.lastIndexOf("'");
		String cabecalho = linha.substring(inicioCabecalho, finalCabecalho + 1);
		cabecalho = cabecalho.replaceAll("'", "");
		String valores = linha.replace(cabecalho, "").replaceAll("'", "");

		String dadosCabecalho[] = cabecalho.split(",");

		String numeroMagico = dadosCabecalho[0];
		String comentario = dadosCabecalho[1];
		String dimensao = dadosCabecalho[2] + " " + dadosCabecalho[3];
		String valorMaximo = dadosCabecalho[4];

		out.write(numeroMagico);
		out.newLine();
		out.write(comentario);
		out.newLine();
		out.write(dimensao);
		out.newLine();
		out.write(valorMaximo);
		out.newLine();

		int atual = 0;
		int quantidade = 0;
		int quebraEspaco = 0;
		int arrobaPos = 0;
		String tempString = "";

		while (valores.length() > 0) {
			quebraEspaco = valores.indexOf(" ");
			tempString = valores.substring(0, quebraEspaco + 1).trim();
			arrobaPos = tempString.indexOf("@");
			if (arrobaPos != -1) {
				quantidade = Integer.parseInt(tempString.substring(0, arrobaPos));
				atual = Integer.parseInt(tempString.substring(arrobaPos + 1, tempString.length()));
			}

			for (int i = 0; i < quantidade; i++) {
				if (i % 12 == 0) {
					out.newLine();
				}
				out.write(atual + " ");
			}

			valores = valores.replace(tempString, "");
		}

		in.close();
		out.close();
	}
}
