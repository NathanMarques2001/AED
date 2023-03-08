import java.io.*;
public class CountLines {
    public static void main(String[] args) throws IOException{

        BufferedReader in = new BufferedReader(new FileReader("caminho do arquivo txt"));

        String line = in.readLine();
        int countLine = 0;
        int numChar = 0;

        while(line != null){
            countLine++;
            numChar += line.length();
            line = in.readLine();
        }
        System.out.println("numero de linhas = "+countLine);
        System.out.println("numero de caracteres = "+numChar);
    }

}
