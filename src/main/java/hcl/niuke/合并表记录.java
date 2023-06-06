package hcl.niuke;

import java.util.*;
import java.util.stream.Stream;

/*
数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 */
public class 合并表记录 {
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        Map<Long,Long> map=new TreeMap<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1>o2){
                    return 1;
                }else if(o1.equals(o2)){
                    return 0;
                }
                return -1;
            }
        });
     //   Map<Long,Long> map=new TreeMap<>();
        for(int i=0;i<num;i++){
            long key=in.nextLong();
            long value=in.nextLong();
            if(map.get(key)!=null){
                value+=map.get(key);
            }
            map.put(key,value);
        }

        for(long key:map.keySet()){
            System.out.print(key);
            System.out.print(' ');
            System.out.println(map.get(key));
        }

    }
}
