package Trabalho;

import java.io.*;
import java.util.Scanner;

public class Descompressor {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.print("Insira o nome da imagem -> ");
		String nomeArquivo = sc.nextLine();
		sc.close();

		String pathArquivoPrincipal = "src/Trabalho/imagens/" + nomeArquivo + "-comp-RLE.pgm";
		String pathArquivoDescomprimido = "src/Trabalho/imagens/" + nomeArquivo + "-desc-RLE.pgm";

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
		String valores = linha.replace(cabecalho, "");

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
		
		while(valores.indexOf("@") != -1) {
			
		}
		
		in.close();
		out.close();
	}
}
