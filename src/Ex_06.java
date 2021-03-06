/**
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，
 * 在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class Ex_06 {
    public int[][] transformImage(int[][] mat, int n) {
        // write code here
        int len = n - 1;
        for (int i = 0; i < n / 2; i++) {//圈数
            for (int j = i; j < len - i; j++) {
                int tmp = mat[i][j];//保存左上角的值
                // 左到上
                mat[i][j] = mat[len - j][i];
                // 下到左
                mat[len - j][i] = mat[len - i][len - j];
                // 右到下
                mat[len - i][len - j] = mat[j][len - i];
                // 上到右
                mat[j][len - i] = tmp;
            }
        }
        return mat;
    }
}
