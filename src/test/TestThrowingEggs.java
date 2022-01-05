package test;


import java.util.Arrays;

public class TestThrowingEggs {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], 9999);
        }
        //填写下标为0,1的行k
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        //填写下标为0,1的列n
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        dp[0][1] = 0;
        dp[1][0] = 0;
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                for (int m = 1; m <= j; m++) {
                    dp[i][j] = Integer.min(dp[i][j],
                            Integer.max(dp[i - 1][m-1], dp[i][j - m]) + 1
                    );
                }
            }
        }
        return dp[k][n];

    }

    public static void main(String[] args) {
        TestThrowingEggs testThrowingEggs = new TestThrowingEggs();
        int i = testThrowingEggs.superEggDrop(2, 6);
        System.out.println("i = " + i);
    }
}
