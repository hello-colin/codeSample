import java.util.ArrayList;
import java.util.Iterator;

public class 数组 {

    public static void main(String[] args) {
        ArrayList<Integer> hcl=new ArrayList<>(10);
        hcl.add(10);
        hcl.add(11);
        System.out.println(hcl.get(0));

        Iterator iterator=hcl.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
