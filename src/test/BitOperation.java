package test;

public class BitOperation {

    public static void main(String[] args) {

        /**
         * 1.位或|空格 统一转小写
         * ('a' | ' ') = 'a'
         * ('A' | ' ') = 'a'
         */
        System.out.println("('a' | ' ') = " + ('a' | ' '));
        System.out.println("('A' | ' ') = " + ('A' | ' '));

        /**
         * 2.位与&下划线_ 统一转大写
         * ('a' & '_') = 'A'
         * ('A' & '_') = 'A'
         */
        System.out.println("('a' & '_') = " + ('a' & '_'));
        System.out.println("('A' & '_') = " + ('A' & '_'));

        /**
         * 3.位异或^或空格可以颠倒大小写
         * ('a' ^ ' ') = 'a'
         * ('A' ^ ' ') = 'a'
         */
        System.out.println("('a' ^ ' ') = " + ('a' ^ ' '));
        System.out.println("('A' ^ ' ') = " + ('A' ^ ' '));
    }
}
