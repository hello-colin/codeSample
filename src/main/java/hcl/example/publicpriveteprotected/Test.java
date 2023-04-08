package hcl.example.publicpriveteprotected;

// 友元函数，可以调用protected、public方法方法
public class Test {
    public static void main(String[] args) {
        HCL protectedTest=new HCL();
        System.out.println(protectedTest.getProtectedName());

        System.out.println(protectedTest.getPublicName());
    }
}
