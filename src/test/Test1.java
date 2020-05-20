package test;

import java.util.Scanner;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args){
        System.out.println("请输入一个由字母和数字组成的字符串");
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toLowerCase().toCharArray();
        System.out.println("请输入一个字符");
        char character = sc.nextLine().toLowerCase().charAt(0);
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character){
                total++;
            }
        }
        System.out.println("输入字符串中含有该字符的个数为："+total);

        TreeSet<Integer> sets = new TreeSet<>();


    }
}
