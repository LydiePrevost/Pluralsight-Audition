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


public class LongInternExample {
	private static final int MAX = 100*1000;
	private static  String[]dbData = new String[10];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = null;
		long t = 0;
		String[] list = null;

		String name = ManagementFactory.getRuntimeMXBean().getName();
		String[] str = name.split("@");

		System.out.println (" *** process: "  + str[0]);
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("/Users/lydieprevost/Documents/workspace/Audition/InternData.txt"));

			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				dbData[i] = sCurrentLine;
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		Random rn = new Random();
		
		BufferedReader br0 = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("without intern : 0, intern: 1 ?");
		list = new String[MAX];
 		for (int k = 0; k < 100; k++) {
        try{
//            int ans = Integer.parseInt(br0.readLine());
        	int ans =1;

    		//sleep 10 seconds
//   		Thread.sleep(10000);		
//    		System.out.println("starting");
    		t = System.currentTimeMillis();
    		
  
    	
    		if ( ans==0) {
//                System.out.print(" Test without intern ");
        		for (int i = 0; i < MAX; i++) {
        			int y = i % 10;
           			list[i] = new String(dbData[y]);
        		}
            }
            else if ( ans==1) {
//                    System.out.print(" Test with intern ");
            		for (int i = 0; i < MAX; i++) {
            			int y = i % 10;
                			list[i] = new String(dbData[y]).intern();
               		            		}
            }
            else {
                System.out.print("invalid answer, please try again");
               
            }
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        }
		System.out.println("done " +  list[0] + "   " + (System.currentTimeMillis() - t) + "ms");
		
		Runtime.getRuntime().exec("jmap -heap:file= /Users/lydieprevost/Documents/workspace/Audition/InternData.res" + str[0]);
		Thread.sleep(1000);
//		System.gc();
	}
}
