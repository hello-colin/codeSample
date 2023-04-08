package hcl.example.finalTest;

import hcl.example.reflect.ReadOnly;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        HCL hcl=new HCL();
        //final 变量不可修改值，指的是基本类型的值不能修改，引用类型的值不可修改为其他引用对象
        hcl.stringBuilder.append("4");
        System.out.println(hcl.stringBuilder);

//        不被允许
//        hcl.stringBuilder=new StringBuilder("789");
        StringBuilder stringBuilder2=hcl.stringBuilder;
        stringBuilder2.append("000");
        System.out.println(hcl.stringBuilder);
        stringBuilder2=new StringBuilder("1234567");
        System.out.println(stringBuilder2);





    }
}
