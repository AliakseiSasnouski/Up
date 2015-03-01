package exam;


import java.io.*;
import java.util.*;

public class Juicer {
    private ArrayList<String> inputData = new ArrayList<String>();

    public void read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        while ((s = in.readLine()) != null) {
            inputData.add(s);
        }
    }

    public void showComponents(String outputFileName) throws IOException {
        HashSet<String> onlyComponents = new HashSet<String>();

        for (String s : inputData) {
            StringTokenizer tokenizer = new StringTokenizer(s, " ");
            while (tokenizer.hasMoreTokens()) {
                onlyComponents.add(tokenizer.nextToken());
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));


        for (String s: onlyComponents) {
            out.write(s);
            out.newLine();
        }

        out.close();
    }

    public void showSorted(String outputFileName) throws IOException {
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

        BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));


        out.close();

    }

    public void showHowMany(String outputFileName) throws IOException {
        Collections.sort(inputData);

        String s;
        int count1 = 0;
        int index = 0;
        int n = inputData.size();
        int t = 0;
        for (int i = 0; i < inputData.size(); i++) {
            s = inputData.get(i);
            for (int j = i + 1; j < inputData.size(); j++) {
                if (inputData.get(j).contains(s)) {
                    count1++;
                    index = inputData.indexOf(s);
                    s = inputData.get(j);
                    inputData.remove(index);
                }

            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));
        out.write("Min: " + (n - count1));
        out.close();

    }

    public void show() {
        for (int i = 0; i < inputData.size(); i++) {
            System.out.println(inputData.get(i));
        }
    }
}
