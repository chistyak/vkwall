import util.Initializer;

import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Thread> threads = Initializer.initialize();
        for(Thread x : threads) x.start();
    }
}