package Trabalho;

import java.io.*;
import java.util.Scanner;

public class Compressor {
    
    public static void compress(String pathImagem, String arquivoComprimido) {
    	try {
            BufferedReader r = new BufferedReader(new FileReader(pathImagem));
            BufferedWriter w = new BufferedWriter(new FileWriter(arquivoComprimido));
            
            int count = 0;
    	} catch(IOException e) {
    		
    	}
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Digite o nome da imagem -> ");
    	String imageName = sc.nextLine();
        String inputFilePath = "src/Trabalho/imagens/"+imageName+".pgm";
        String outputFilePath = "src/Trabalho/imagens/"+imageName+"comprimida.pgm";
        compress(inputFilePath, outputFilePath);
    }
}
