package Tree;

import java.util.Random;

public class main {

	public static void main(String[] args) {
		Random geradorNumeros = new Random();
		double myArray[] = new double[200000];
		double resultado = 0;
		
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = i;
		}
		
		for(int i = 0; i < myArray.length; i++) {
			System.out.println("["+(i+1)+"] = "+myArray[i]);
		}
	}

}
