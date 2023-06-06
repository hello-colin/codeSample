package hcl.niuke;

import java.util.Scanner;

public class 字符串分隔 {

//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        String input=in.nextLine();
//        StringBuilder out=new StringBuilder();
//
//        for(int i=1;i<=input.length();i++){
//            out.append(input.charAt(i-1));
//            if(i%8==0){
//                System.out.println(out);
//                out=new StringBuilder();
//            }
//        }
//        if(out.length()>0){
//            for(int j=out.length();j<8;j++){
//                out.append("0");
//            }
//            System.out.println(out);
//        }
//    }

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        int left=0;
        if(sb.length()%8!=0){
            left=8-sb.length()%8;
        }
        while(left>0){
            sb.append("0");
            left--;
        }

        for(int i=1;i<=sb.length();i++){
            System.out.print(sb.charAt(i-1));
            if(i%8==0){
                System.out.print('\n');
                continue;
            }
        }
    }
}
