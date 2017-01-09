/**
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
 * 给定一个int[][] map,表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。
 * 另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，
 * 为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
 */
public class Ex_40 {
    public int countWays(int[][] map, int x, int y) {
        // write code here
        if(map == null || map.length != x || map[0].length != y)
            return 0;
        if(map[x-1][y-1] != 1 || map[0][0] != 1)
            return 0;
        int[][] res = new int[x][y];
        res[0][0] = 1;
        for (int i = 1; i < x; i++) {//初始化第一列
            if (map[i][0] != 1) {
                res[i][0] = 0;
            } else {
                res[i][0] = res[i-1][0];
            }
        }
        for (int i = 1; i < y; i++) {//初始化第一行
            if (map[0][i] != 1) {
                res[0][i] = 0;
            } else {
                res[0][i] = res[0][i-1];
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (map[i][j] != 1) {//当前点可以行走
                    res[i][j] = 0;
                } else {
                    res[i][j] = (res[i - 1][j]%1000000007 + res[i][j - 1]%1000000007)%1000000007;

                }
            }
        }
        return (res[x - 1][y - 1]%1000000007);
    }
}
