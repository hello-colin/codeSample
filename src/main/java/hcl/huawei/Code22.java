package hcl.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Code22 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String s1=in.next();
        String s2=in.next();
        int k=in.nextInt();

        List<String> ch1=new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            ch1.add(s1.charAt(i)+"");
        }
        ch1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0)-o1.charAt(0);
            }
        });

        //寻找最右侧left

        int s1len=s1.length();
        int s2len=s2.length();
        int result=-1;


        int left=0;
        int right=left+k;
        int len=s1len+k;

        for(int i=0;i<=s2.length()-len;i++){
            if(voliate(ch1,s2,i,i+len)){
                result=i;
                break;
            }
        }

        System.out.println(result);




    }

    public static boolean voliate(List<String> ch1,String s2,int left,int right){

        List<String> ch2=new ArrayList<>();
        for(int i=left;i<right;i++){
            ch2.add(s2.charAt(i)+"");
        }
        ch2.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0)-o1.charAt(0);
            }
        });

        int j=0;
        for(int i=0;i<ch2.size();i++){
            if(j==ch1.size()){
                break;
            }
            if(ch2.get(i).equals(ch1.get(j))){
                j++;
            }
        }

        return  j==ch1.size();
    }
}
