/**
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 * 给定一个N阶方阵int[][](C++中为vector>)mat和矩阵的阶数n，
 * 请返回完成操作后的int[][]方阵，保证n小于等于300，矩阵中的元素为int范围内。
 * 测试样例：
 * [[1,2,3],[0,1,2],[0,0,1]]
 * 返回：[[0,0,3],[0,0,0],[0,0,0]]
 */
public class Ex_07 {
    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        boolean[] flagRow = new boolean[n];
        boolean[] flagCol = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    flagRow[i] = true;
                    flagCol[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flagCol[j] || flagRow[i]) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }
}
