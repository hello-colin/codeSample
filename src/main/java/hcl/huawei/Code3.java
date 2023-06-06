package hcl.huawei;

import java.util.Scanner;

public class Code3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int rows=in.nextInt();
        int cols=in.nextInt();

        String[][] table=new String[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                String value=in.next();
                table[i][j]=value;
            }
        }
        String target=in.next();
        String left=target.split(":")[0];
        String right=target.split(":")[1];

        int left_col=left.charAt(0)-'A'+1;
        int right_col=right.charAt(0)-'A'+1;
        int left_row=Integer.valueOf(left.substring(1,left.length()));
        int right_row=Integer.valueOf(right.substring(1,right.length()));

        int min_row=left_row<right_row?left_row:right_row;
        int max_row=left_row>right_row?left_row:right_row;

        int min_col=left_col<right_col?left_col:right_col;
        int max_col=left_col>right_col?left_col:right_col;

        int count=0;
        for(int i=min_row;i<=max_row;i++){
            for(int j=min_col;j<=max_col;j++){
                count+=getValue(table,table[i-1][j-1]);
            }
        }


        System.out.println(count);



    }


    public  static int getValue(String[][] table,String key){
        if(key.startsWith("=")){
            return getValue(table,key.substring(1,key.length()));
        }else if(key.contains("+")){
            return getValue(table,key.split("\\+")[0])+getValue(table,key.split("\\+")[1]);
        }else if(key.contains("-")){
            return getValue(table,key.split("\\-")[0])-getValue(table,key.split("\\-")[1]);
        }else if (key.charAt(0)>='0'&&key.charAt(0)<='9'){
            return Integer.valueOf(key);
        }else{
            int col=key.charAt(0)-'A'+1;
            int row=Integer.valueOf(key.substring(1,key.length()));
            String value=table[row-1][col-1];
            return getValue(table,value);
        }
    }
}
