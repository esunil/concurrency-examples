package net.sunilkumar.concurrency;

import java.util.List;

public class PrintWorker implements Runnable {
    
    private List<Integer> list;
    
    public PrintWorker(List<Integer> list) {
        this.list = list;
    }
    
    public void run() {
        for (Integer i : list) {
            System.out.println("i = "+ i);
        }
    }
    
}
