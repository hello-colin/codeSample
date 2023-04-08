package hcl.example.reflect;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        Class<?> clazz1=Class.forName("hcl.example.reflect.Student");
        Class<?> clazz2=Student.class;
        Class<?> clazz3=new Student().getClass();
        Field[] fields=clazz1.getFields();


        System.out.println("clazz1");
        System.out.println(clazz1+","+clazz2+","+clazz3);
        System.out.println(clazz1.getName());
        System.out.println(clazz1.getSimpleName());
        System.out.println(clazz1.getPackage());
        System.out.println(clazz1.getPackage().getName());

        //readOnlyTest
        ReadOnly readOnly=new ReadOnly();
        Integer age2= readOnly.getAge();
        age2= 2;
        //未被修改
        System.out.println(readOnly.getAge());

        Class<?> clazz=ReadOnly.class;
        Method method= clazz.getMethod("getAge");
        method.invoke(readOnly);
        Field field=clazz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(readOnly,30);
        //强大的反射可以修改私有变量
        System.out.println(readOnly.getAge());

        Student stu=new Student();
        stu.setAge(11);
        stu.setName("hcl");
        //序列化
        OutputStream outputStream = new FileOutputStream(new File("Teacher.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(stu);


    }
}
