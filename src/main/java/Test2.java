import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void  sort(int [] data,int left,int right){

        if(right-left<=1){
            return;
        }
        int mid=data[(left+right)/2];

        int i=0;
        int j=right-1;

        while(i<j){
            while(data[i]<mid && i<j)
            {
                i++;
            }
            while(data[j]>mid&& i<j){
                j--;
            }
            int temp=data[i];
            data[i]=data[j];
            data[j]=temp;
        }
        sort(data,0,(left+right)/2);
        sort(data,(left+right)/2,right);
    }
    public static void main(String[] args) {

        int[] data={1,9,3,10,2,7};
        sort(data,0,data.length);
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]);
            System.out.print(",");
        }
    }
}
