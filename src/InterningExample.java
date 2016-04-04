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
import java.util.StringTokenizer;

public class InterningExample {	private static final int MAX = 100 * 1000;
private static String[] dbData = new String[10];

public static void main(String[] args) throws Exception {

	BufferedReader br = null;
	long t = 0;
	String[] list = new String[MAX];
	String name = ManagementFactory.getRuntimeMXBean().getName();
	String[] str = name.split("@");

	System.out.println (" *** process: "  + str[0]);

	try {
		String sCurrentLine;

		br = new BufferedReader(
				new FileReader(
						"/Users/lydieprevost/Documents/workspace/Audition/FirstNames.txt"));

		int i = 0;
		while ((sCurrentLine = br.readLine()) != null) {

			StringTokenizer tokens = new StringTokenizer(sCurrentLine,
					" \t\n\r\f\",.;:-+*()[]|/Ð?=_&á");
			while (tokens.hasMoreTokens()) {
				list[i] = (tokens.nextToken().intern());
				i++;
			}
		}
		Thread.sleep(100000);
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

}}
