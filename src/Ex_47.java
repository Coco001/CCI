/**
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
 * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
 * 测试样例：
 * 6
 * 返回：2
 */
public class Ex_47 {
    public int countWays(int n) {
        // write code here
        int[] money = new int[]{1, 5, 10, 25};
        int[][] map = new int[4][n + 1];
        for (int i = 0; i < 4; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < n + 1; i++) {
            map[0][i] = 1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j >= money[i]) {
                    map[i][j] = (map[i - 1][j] + map[i][j - money[i]]) % 1000000007;
                } else {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        return map[3][n] % 1000000007;
    }
}
