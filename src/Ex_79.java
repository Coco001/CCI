/**
 * 有一个正整数和负整数组成的NxN矩阵，请编写代码找出元素总和最大的子矩阵。请尝试使用一个高效算法。
 * 给定一个int矩阵mat和矩阵的阶数n，请返回元素总和最大的子矩阵的元素之和。
 * 保证元素绝对值小于等于100000，且矩阵阶数小于等于200。
 * 测试样例：
 * [[1,2,-3],[3,4,-5],[-5,-6,-7]],3
 * 返回：10
 */
public class Ex_79 {
    /**
     * 1、首先判断所有可能的子矩阵（纵向选定）
     * 2、将这块子矩阵按行累加压缩成一堆，然后处理简单的一维（横向选定）
     * 3、过程中有最大值出现就更新最大值
     */
    private int maxSum;
    public int sumOfSubMatrix(int[][] mat, int n) {
        // write code here
        maxSum = Integer.MIN_VALUE;
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {//压缩的起点
            for (int j = 0; j < n; j++) {//每次更换起点sum就重置
                sum[j] = 0;
            }

            for (int k = 0; k < n - i; k++) {//步长，矩阵=起点+步长
                for (int j = 0; j < n; j++) {//求上述矩阵的压缩和
                    sum[j] += mat[i + k][j];
                }
                maxSum = Math.max(maxSum, getMaxSum(sum));//压缩为一维求和，求最大值
            }
        }
        return maxSum;
    }

    private int getMaxSum(int[] row) {//一维数组中连续子序列的最大和
        int curSum = 0;
        for (int i = 0; i < row.length; i++) {
            curSum += row[i];
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
