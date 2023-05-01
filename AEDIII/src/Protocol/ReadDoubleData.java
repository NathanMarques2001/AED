package Protocol;
import java.io.*;
public class ReadDoubleData {
  public static void main(String[] args) throws IOException {

    double[] aux;

    aux = readData("src/Protocol/Response.txt");

    for(double value : aux){
      System.out.printf("%.2f\n", value);
    }
  }
  public static double[] readData(String fileName) throws IOException{

    FileInputStream req = new FileInputStream(fileName);
    DataInputStream res = new DataInputStream(req);

    double[] data = new double[res.readInt()];

    for (int i = 0; i < data.length; i++) {
      data[i] = res.readDouble();
    }
    req.close();

    return data;
  }
}
