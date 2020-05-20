package test.test_string_intern;

public class Test2 {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String intern1 = s1.intern();
        String s2 = "hello";
        System.out.println(s1 == s2);
        String s3 = new String("hello") + new String("hello");
        String intern3 = s3.intern();
        String s4 = "hellohello";
        System.out.println(s3 == s4);
    }
}
