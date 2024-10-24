import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 流 {
    public static void main(String[] args) {
        String[] data="1,2,3,4,5".split(",");
        List<String> a=Arrays.stream(data).sorted((x,y)->{
            return y.charAt(0) - x.charAt(0);

        }).collect(Collectors.toList());
        System.out.print(a);

        a.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.charAt(0)-t1.charAt(0);
            }
        });

        Boolean b=a.size()>0?true:false;
        System.out.print('\r');
        System.out.print(b);

    }
}
