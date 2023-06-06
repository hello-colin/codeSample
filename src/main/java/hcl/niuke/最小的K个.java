package hcl.niuke;

import javafx.scene.chart.ValueAxis;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最小的K个 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n=in.nextInt();
        int k=in.nextInt();

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        priorityQueue.offer(in.nextInt());
        for(int i=1;i<n;i++){
            int value=in.nextInt();
            if(i<k){
                priorityQueue.offer(value);
            }else if(value<priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(value);
            }
        }

        String sb=new String();
        while (!priorityQueue.isEmpty()){
            int value=priorityQueue.poll();
            sb=new StringBuilder(value+" ").append(sb).toString();
        }

        System.out.print(sb);


    }
}
