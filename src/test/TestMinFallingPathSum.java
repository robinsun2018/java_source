package test;

import java.util.Arrays;

public class TestMinFallingPathSum {

    private int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        //初始化备忘录
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }

        //结束位置可能出现在最后一行n-1的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    int dp(int[][] matrix, int i, int j) {
        //1.索引校验
        if (i < 0 ||
                j < 0 ||
                matrix.length <= i ||
                matrix[0].length <= j
        ) return 99999;
        //2.base case
        if (i == 0) return matrix[0][j];

        //3.使用备忘录
        if (memo[i][j] != 6666) return memo[i][j];
        //4.状态转移
        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j + 1)
        );
        return memo[i][j];

    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        //[[2,1,3],[6,5,4],[7,8,9]]
        //int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        //[-19,57],[-40,-5]
        int[][] matrix = new int[][]{{-19, 57}, {-40, -5}};

        int i = new TestMinFallingPathSum().minFallingPathSum(matrix);
        System.out.println("i = " + i);
    }
}
