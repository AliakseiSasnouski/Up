package exam;

import java.io.*;
import java.util.*;

/**
 * Created by HP on 17.02.2015.
 */
public class Sort implements Runnable {

    public void run() {
        ArrayList<String> inputData = new ArrayList<String>();
        try {

            BufferedReader in = new BufferedReader(new FileReader("juice.in"));
            String s;
            while ((s = in.readLine()) != null) {
                inputData.add(s);
            }
        }
        catch (IOException e) {
        }


        ArrayList<String> onlyComponents = new ArrayList<String>();

        for (String s : inputData) {
            StringTokenizer tokenizer = new StringTokenizer(s, " ");
            while (tokenizer.hasMoreTokens()) {
                onlyComponents.add(tokenizer.nextToken());
            }
        }

        Collections.sort(onlyComponents, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) > o2.charAt(i))
                            return 1;
                        if (o1.charAt(i) < o2.charAt(i))
                            return -1;
                    }
                    return -1;
                }
                if (o1.length() > o2.length()) {
                    for (int i = 0; i < o2.length(); i++) {
                        if (o1.charAt(i) > o2.charAt(i))
                            return 1;
                        if (o1.charAt(i) < o2.charAt(i))
                            return -1;
                    }
                    return 1;
                } else
                    return 0;
            }
        });


        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("juice.out"));


            for (String s: onlyComponents) {
                out.write(s);
                out.newLine();
            }

            out.close();
        } catch (IOException e) {

        }


    }
}
