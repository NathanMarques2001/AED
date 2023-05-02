package Tree;

import java.io.*;
import java.util.Random;

public class CriaArvoreB {
	public static void main(String[] args) throws Exception {

		ArvoreB dicionario = new ArvoreB(ordemArvore(4, 8));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Random geradorNumeros = new Random();

		double myArray[] = new double[1000];
		double resultado = 0;
		int chave = 0;

		System.out.println("Criacao da arvore");

		for (int i = 0; i < myArray.length; i++) {
			resultado = geradorNumeros.nextInt();
			myArray[i] = Math.round(resultado / 100000);
		}

		for (int j = 0; j < myArray.length; j++) {
			chave = (int) myArray[j];
			MeuItem item = new MeuItem(chave);
			dicionario.insere(item);
			dicionario.imprime();
		}

		System.out.println("\nPesquisando chaves");
		chave = Integer.parseInt(in.readLine());
		while (chave > 0) {
			MeuItem item = new MeuItem(chave);
			item = (MeuItem) dicionario.pesquisa(item);
			if (item == null)
				System.out.println("Item nao encontrado");
			else
				System.out.println("Item encontrado");
			chave = Integer.parseInt(in.readLine());
		}

		System.out.println("\nRemovendo algumas chaves");
		chave = Integer.parseInt(in.readLine());
		while (chave > 0) {
			MeuItem item = new MeuItem(chave);
			dicionario.retira(item);
			dicionario.imprime();
			chave = Integer.parseInt(in.readLine());
		}
	}

	static int ordemArvore(int tamanhoBloco, int tamanhoRegistro) {
		int tamPonteiroBloco = 16;
		int tamPonteiroNo = 12;
		int tamBloco = tamanhoBloco * 1024;

		int ordem = Math.round(((tamBloco - tamPonteiroNo) / (tamPonteiroBloco + tamanhoRegistro + tamPonteiroNo)) + 1);
		return ordem;
	}
}
