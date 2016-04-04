import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import java.util.Random;

public class InternExample2 {
	private static final int MAX = 5 * 1000 * 1000;
	private static String[] dbData = new String[100000];;
	private final static String myData = "/Users/lydieprevost/Documents/workspace/Audition/InternData.txt";

	public static void main(String[] args) throws Exception {

		String name = ManagementFactory.getRuntimeMXBean().getName();
		String[] str = name.split("@");

		System.out.println (" *** process: "  + str[0]);
		for (int k = 0; k < 10; k++) {
			BufferedReader br = null;
			long t = 0;
			// Uses a String array to keep a strong reference to the String
			// objects.
			final String[] list = new String[MAX];

			// Read from a filE to simulate grabbing data from databasE
			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader(myData));
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

			// use a random number to concatenate strings read and create
			// duplicates
			Random rn = new Random();

			System.out.println("Starting test 2 interning Strings");
			t = System.currentTimeMillis();

			System.out.print("Test interning Strings ");
			for (int i = 0; i < MAX; i++) {
				int y = i % 10;
				list[i] = (dbData[y] + rn.nextInt(y + 1)).intern();
			}

			// Print the first element in the end to avoid removal of the
			// structure due to optimization.
			System.out.println("done " + list[0] + "   "
					+ (System.currentTimeMillis() - t) + "ms");

			for (int i = 0; i < 10; i++) {
				try {
					String filename = "MyFile.txt";
					FileWriter fw = new FileWriter(myData, true); // the true
																	// will
																	// append
																	// the new
																	// data
					fw.write(list[i] + "\n");// appends the string to the file
					fw.close();
				} catch (IOException ioe) {
					System.err.println("IOException: " + ioe.getMessage());
				}
			}

		}
	}
}
