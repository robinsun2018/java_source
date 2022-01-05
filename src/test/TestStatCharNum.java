package test;

import java.util.BitSet;
import java.util.Scanner;

public class TestStatCharNum {

    private static int statCharNum(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        BitSet bitSet = new BitSet(128);
        for (char c: line.toCharArray()) {
            if (!bitSet.get(c)){
                bitSet.set(c);
            }
        }
        return bitSet.cardinality();
    }

    public static void main(String[] args) {
        int i = statCharNum();
        System.out.println("i = " + i);
    }
}
