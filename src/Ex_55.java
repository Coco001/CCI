/**
 * 有一个NxM的整数矩阵，矩阵的行和列都是从小到大有序的。请设计一个高效的查找算法，查找矩阵中元素x的位置。
 * 给定一个int有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，
 * 请返回一个二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
 * 测试样例：
 * [[1,2,3],[4,5,6]],2,3,6
 * 返回：[1,2]
 */
public class Ex_55 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int row = 0;
        int col = m-1;
        while (row < n - 1 || col > 0) {
            if (mat[row][col] == x) {
                break;
            }
            if (mat[row][col] > x) {
                col--;
            }
            if (mat[row][col] < x) {
                row++;
            }
        }
        int[] res = new int[]{row, col};
        return res;
    }
}
