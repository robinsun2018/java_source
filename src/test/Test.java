package test;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {

/*    public static void main(String[] args){
        System.out.println("输入多行，先输入随机整数的个数，再输入相应个数的整数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num];
        for(int i =0;i<num;i++){
            System.out.println("请输入第"+(i+1)+"个整数");
            ints.scanner.nextInt();
            scanner.hasNext()
        }
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            TreeSet<Integer> tc = new TreeSet<>();
            while(num-->0&&sc.hasNextInt()){
                tc.add(sc.nextInt());
            }
            Iterator<Integer> it = tc.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
        sc.close();
    }
}
