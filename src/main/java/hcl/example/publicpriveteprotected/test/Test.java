package hcl.example.publicpriveteprotected.test;

import hcl.example.publicpriveteprotected.HCL;

//不同包，只能调用public方法
//子类，可以调用父类的protected方法
public class Test {
    public static void main(String[] args) {
        HCL hcl=new HCL();
        System.out.println(hcl.getPublicName());


        HCL2 hcl2=new HCL2();
        System.out.println(hcl2.getProtectedname());
    }
}
