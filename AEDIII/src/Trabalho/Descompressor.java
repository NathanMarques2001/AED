package Trabalho;

import java.io.*;
import java.util.Scanner;

public class Descompressor {
    
    public static void decompress(String inputFilePath, String outputFilePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            
            // Lê o cabeçalho PGM
            String magicNumber = reader.readLine();
            String comment = reader.readLine();
            String dimensions = reader.readLine();
            String maxValue = reader.readLine();
            writer.write(magicNumber + "\n");
            writer.write(comment + "\n");
            writer.write(dimensions + "\n");
            writer.write(maxValue + "\n");
            
            // Lê os valores comprimidos e faz a descompressão com RLE
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int i = 0; i < tokens.length; i += 2) {
                    int count = Integer.parseInt(tokens[i]);
                    int pixel = Integer.parseInt(tokens[i + 1]);
                    
                    for (int j = 0; j < count; j++) {
                        writer.write(pixel + " ");
                    }
                }
            }
            
            reader.close();
            writer.close();
            
            System.out.println("Descompressão concluída.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Digite o nome da imagem -> ");
    	String imageName = sc.nextLine();
        String inputFilePath = "src/Trabalho/imagens/"+imageName+"_comprimido.pgm";
        String outputFilePath = "src/Trabalho/imagens/"+imageName+"_descomprimida.pgm";
        decompress(inputFilePath, outputFilePath);
    }
}
