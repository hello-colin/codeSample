package hcl.example.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {

        People[] peoples={new People("hcl",10),new People("hds",9)};

        Arrays.sort(peoples,(People a,People b)->a.getAge()-b.getAge());

//        Arrays.sort(peoples, new Comparator<People>() {
//            @Override
//            public int compare(People o1, People o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });

        for (People p:peoples) {
            System.out.println(p.getName()+":"+p.getAge());

        }
    }
}
