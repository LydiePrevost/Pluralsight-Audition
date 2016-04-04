import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Random;

public class RayInternExample {
	private static final int MAX = 5 * 1000 * 1000;
	private static String[] dbData = new String[10];;

	public static void main(String[] args) throws Exception {

		BufferedReader br = null;
		long t = 0;
		// Uses a String array to keep a strong reference to the String objects.
		final String[] list = new String[MAX];

		// Read from a filE to simulate grabbing data from databasE
		try {
			String sCurrentLine;
			br = new BufferedReader(
					new FileReader(
					"/Users/lydieprevost/Documents/workspace/Audition/InternData.txt"));
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				dbData[i] = sCurrentLine;
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// use a random number to concatenate strings read and create duplicates
		Random rn = new Random();

		System.out.println("Starting test interning Strings");
		t = System.currentTimeMillis();

		System.out.print("Test interning Strings ");
		for (int i = 0; i < MAX; i++) {
			int y = i % 10;
			list[i] = (dbData[y] + rn.nextInt(y + 1)).intern();
		}
		
		//Print the first element in the end to avoid removal of the structure due to optimization.		
		System.out.println("done " + list[0] + "   "
				+ (System.currentTimeMillis() - t) + "ms");

	}
}
