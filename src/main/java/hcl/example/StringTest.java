package hcl.example;
public class StringTest {

    //反转字符串
    public static String reverse(String str){
        String out="";
        for(int i=str.length();i>=0;i--){
            out+=str.charAt(i);
        }
        return  out;
    }
    public static void main(String[] args) {
        String str1="1";
        String str2="1";
        String str3=new String("1");
        //true
        System.out.println(str1==str2);
        //false
        System.out.println(str1==str3);

        String str4=new String("1")+new String("3");
        str4.intern();
        String str5="13";

        //true
        System.out.println(str4==str5);


        String str6=new String("4")+new String("5");
        String str7="45";
        //false
        System.out.println(str7==str6);

        StringBuilder stringBuilder=new StringBuilder(str7);
        String ret=stringBuilder.reverse().toString();

    }
}
