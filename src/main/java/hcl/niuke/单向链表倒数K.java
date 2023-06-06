package hcl.niuke;

import java.sql.Struct;
import java.util.List;
import java.util.Scanner;

public class 单向链表倒数K {

    public static class ListNode{
        public ListNode(int value){
            this.m_key=value;
        }
        int m_key;
        ListNode m_pNext;
    }
    public static class Hcl{
        int h=1;
        Hcl haah;
    }
    public static void main(String[] args) {
        Hcl hcl1=new Hcl();
        Hcl hcl2=hcl1;
        hcl1.h=100;


        Scanner in =new Scanner(System.in);

        while (in.hasNext()){
            int n=in.nextInt();
            int firstValue=in.nextInt();
            ListNode root=new ListNode(firstValue);
            ListNode pre=root;
            for(int i=1;i<n;i++){
                int value=in.nextInt();
                ListNode next=new ListNode(value);
                pre.m_pNext=next;
                pre=next;
            }
            pre.m_pNext=null;
            n=0;
            int k=in.nextInt();

            ListNode left=root;
            ListNode right=root;

            try{
                for(int i=1;i<k;i++){
                    right=right.m_pNext;
                }
                while(right.m_pNext!=null){
                    left=left.m_pNext;
                    right=right.m_pNext;
                }

                System.out.println(left.m_key);
            }catch (Exception e){
                System.out.println("null");
            }
        }

    }
}
