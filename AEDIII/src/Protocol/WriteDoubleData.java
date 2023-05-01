package Protocol;
import java.io.*;

public class WriteDoubleData {

  public static void main(String[] args) throws IOException {

    double[] data = {1.55555, 3.58, 7.788797, 1.3333, 2.8157};

    writeData(data, "src/Protocol/Response.txt");
  }

  public static void writeData(double[] input, String fileName) throws IOException{
    FileOutputStream req = new FileOutputStream(fileName);
    DataOutputStream res = new DataOutputStream(req);

    res.writeInt(input.length);
    for (int i = 0; i < input.length; i++) {
      res.writeDouble(input[i]);
    }
    res.close();
  }
}
