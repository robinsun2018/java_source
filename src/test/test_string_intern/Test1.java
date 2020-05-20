package test.test_string_intern;

public class Test1 {
    public static void main(String[] args) {
        String s1 = new String("helloworld");
        String s2 = "helloworld";
        s1.intern();
        System.out.println(s1 == s2);//false    false

        String s3 = new String("helloyeah");
        s3.intern();
        String s4 = "helloyeah";
        System.out.println(s3 == s4);//false  true

        String s5=new String("hello")+new String("yeah");
        //s5.intern();
        System.out.println(s4 == s5);//如果true则
/*        String s6="helloyeah";
        System.out.println(s5==s6);//false  true

        String s7=new String("hello")+new String("yeah0");
        s7.intern();
        String s8="helloyeah0";
        System.out.println(s7==s8);//true  true*/
    }
}
