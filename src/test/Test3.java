package test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args)
    {
        System.out.println("请输入若干单词，以空格作为分隔");
        Scanner sc = new Scanner(System.in);
        while(! sc.hasNext("#"))
        {
            System.out.println("键盘输入的内容是："

                    + sc.next());
        }
        System.out.println("执行吗");
    }

}
