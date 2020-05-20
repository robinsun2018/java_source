package test.test_string_intern;

public class Test4 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);//输出true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);//输出false
    }
}
