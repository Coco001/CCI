import java.util.ArrayList;

/**
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。
 * 给定一个int n，请返回方法数，保证n小于等于10
 * 测试样例：
 * 1
 * 返回：1
 */
public class Ex_48 {
    public int nQueens(int n) {
        // write code here
        int[] columns = new int[n];//columns[r] = c；表示第r行第c列存放有数据
        ArrayList<int[]> list = new ArrayList<>();
        placeQueen(list, columns, 0);
        return list.size();
    }

    /**
     * 放置皇后
     * @param list 存放满足条件放置的结果
     * @param columns 当前存放的情况
     * @param index 行索引
     */
    private void placeQueen(ArrayList<int[]> list, int[] columns, int index) {
        if (index == columns.length) {
            list.add(columns.clone());
            return;
        }
        for (int i = 0; i < columns.length; i++) {//遍历每一列
            if (check(columns, index, i)) {
                columns[index] = i;//第index行存放第i列
                placeQueen(list, columns, index + 1);
            }
        }
    }

    /**
     * 判断当前行存放数据是否合法
     * @param columns 数组
     * @param row 当前行
     * @param col 列
     * @return 是否合法
     */
    private boolean check(int[] columns, int row, int col) {
        for (int i = 0; i < row; i++) {//搜索到当前行即可
            if (columns[i] == col) {//index列已经存放数据了
                return false;
            }
            //行不需要判断，因为是一行一行进行检查，不会出现想同行的情况
            if (row - i == Math.abs(col - columns[i])) {//当前行减去i,以及当前行中存放的列减去i中存放的列
                return false;
            }
        }
        return true;
    }
}
