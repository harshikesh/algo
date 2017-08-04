package Strings;

import java.io.*;

/**
 * Created by harshikesh.kumar on 31/03/17.
 */
public class FileHelper {

    private static final String FILENAME = "/Users/harshikesh.kumar/Desktop/abc.txt";

    public static void  writeToFile(String message, int linenumber,Object lock) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        synchronized (lock) {
            try {
                String content = message;
                fw = new FileWriter(FILENAME,true);
                bw = new BufferedWriter(fw);
                for (int i = 0; i < linenumber; i++) {
                    bw.newLine();
                }
                bw.append(content);
                System.out.println("Done");
                Thread.sleep(300);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                        fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    public static void readFromFile() {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            br = new BufferedReader(new FileReader(FILENAME));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
