import java.util.jar.JarEntry;

/**
 * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
 * 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
 * 测试样例：
 * [[1,1,1],[1,0,1],[1,1,1]],3
 * 返回：3
 */
public class Ex_78 {
    public static void main(String[] args) {
        int[][] test = {{1, 1, 1, 0, 0}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 1, 0}, {1, 0, 0, 0, 1}};
        System.out.println(maxSubMatrix(test, 5));
    }

    //编译通过
    private static int maxSubMatrix01(int[][] mat, int n) {
        for (int size = n; size >= 1; size--) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (isSquare0(mat, row, col, size) || isSquare1(mat, row, col, size)) {
                        return size;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isSquare1(int[][] mat, int row, int col, int size) {
        //检查上下边界
        for(int i = 0; i < size; i++){
            if (col + i >= mat.length || row + size - 1 >= mat.length) {
                return false;
            }
            if (mat[row][col + i] == 0 || mat[row + size - 1][col + i] == 0) {
                return false;
            }
        }
        // 检测 左 右 边界
        for(int j = 1;j< size - 1;j++){
            if (row + j >= mat.length || col + size - 1 >= mat.length) {
                return false;
            }
            if (mat[row + j][col] == 0 || mat[row + j][col + size - 1] == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSquare0(int[][] mat, int row, int col, int size) {
        //检查上下边界
        for (int i = 0; i < size; i++) {
            if (col + i >= mat.length || row + size - 1 >= mat.length) {
                return false;
            }
            if (mat[row][col + i] == 1 || mat[row + size - 1][col + i] == 1) {
                return false;
            }
        }
        //检查左右边界
        for (int i = 1; i < size - 1; i++) {
            if (row + i >= mat.length || col + size - 1 >= mat.length) {
                return false;
            }
            if (mat[row + i][col] == 1 || mat[row + i][col + size - 1] == 1) {
                return false;
            }
        }
        return true;
    }

    // 暴力破解
    private static int maxSubMatrix(int[][] mat, int n) {
        // write code here
        for (int i = n, res; i > 0; i--) {
            res = findSquareWithSize(mat, i, n);
            if (-1 != res) {
                return res;
            }
        }
        return 0;
    }

    private static int findSquareWithSize(int[][] mat, int size, int n) {
        int count = n - size + 1;
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(mat, row, col, size)) {
                    return size;
                }
            }
        }
        return -1;
    }

    private static boolean isSquare(int[][] mat, int row, int col, int size) {
        //检查上边界和下边界
        for (int i = 0; i < size; i++) {
            if (mat[row][col + i] != mat[row][size-1+col] || mat[row + size-1][col + i] != mat[row][size-1+col]) {
                return false;
            }
        }

        //检查左边界和有边界
        for (int i = 1; i < size - 1; i++) {
            if (mat[row + i][col] != mat[row][size-1+col] || mat[row + i][col + size-1] != mat[row][size-1+col]) {
                return false;
            }
        }
        return true;
    }
}
