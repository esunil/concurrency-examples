package net.sunilkumar.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.Lists;

public class ExecutorExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1; i <=1000; i++){
            list.add(i);
        }
        System.out.println("Initial List : "+ list);
        List<List<Integer>> partition = Lists.partition(list, 10);
        ExecutorService executor = Executors.newFixedThreadPool(partition.size());
        for (List<Integer> subList : partition) {
            PrintWorker task = new PrintWorker(subList);
            executor.execute(task);
        }
        executor.shutdown();
        while(!executor.isTerminated()){
            
        }
        System.out.println("Finished!");
    }
    
}
