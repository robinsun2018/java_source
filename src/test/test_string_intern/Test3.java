package test.test_string_intern;

public class Test3 {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "hello";
        String intern1 = s1.intern();
        System.out.println(s1 == s2);
        String s3 = new String("hello") + new String("hello");
        String s4 = "hellohello";
        String intern3 = s3.intern();
        System.out.println(s3 == s4);
    }
}
