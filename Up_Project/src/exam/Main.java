package exam;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File in = new File("juice.in");
        File out1 = new File("juice1.out");
        File out2 = new File("juice2.out");
        File out3 = new File("juice3.out");

        Juicer juice = new Juicer();

        juice.read(in.getName());
        juice.showComponents(out1.getName());
        Sort sortMy = new Sort();
        Thread thread = new Thread(sortMy);
        thread.start();
        //juice.showSorted(out2.getName());
        juice.showHowMany(out3.getName());
    }
}
