import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Duplicates {
	private static final int MAX = 100 * 1000;
	private static String[] dbData = new String[10];

	public static void main(String[] args) throws Exception {

		BufferedReader br = null;
		long t = 0;
		String[] list = null;

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

		list = new String[MAX];
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < MAX; i++) {
				int y = i % 10;
				list[i] = new String(dbData[y]);
			}

		}
	}
}
