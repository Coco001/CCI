import java.util.Arrays;

/**
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。
 * 同时我们应该让下面的人比上面的人更高一点。已知参加游戏的每个人的身高，
 * 请编写代码计算通过选择参与游戏的人，我们最多能叠多少个人。
 * 注意这里的人都是先后到的，意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。
 * 给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回最多能叠的人数。保证n小于等于500。
 * 测试样例：
 * [1,6,2,5,3,4],6
 * 返回：4
 */
public class Ex_56 {
    public int getHeight(int[] men, int n) {
        // write code here
        return getLIS(men, n);
    }

    private int getLIS(int[] men, int n) {
        int[] tmp = Arrays.copyOf(men, n);
        Arrays.sort(tmp);
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (men[i - 1] == tmp[j - 1]) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }
        return map[n][n];
    }

    private int getLIS01(int[] men, int n) {
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;//自身长度
            for (int j = 0; j < i; j++) {//不包含自身，遍历之前的长度
                if (men[j] < men[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}
