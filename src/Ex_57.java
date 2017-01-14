
/**
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。
 * 为了使叠成的罗汉更稳固，我们应该让上面的人比下面的人更轻一点。
 * 现在一个马戏团要表演这个节目，为了视觉效果，我们还要求下面的人的身高比上面的人高。
 * 请编写一个算法，计算最多能叠多少人，注意这里所有演员都同时出现。
 * 给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。
 * 同时给定演员总数n，请返回最多能叠的人数。保证总人数小于等于500。
 * 测试样例：
 * [[1,2],[3,4],[5,6],[7,8]],4
 * 返回：4
 */
public class Ex_57 {
    public int getHeight(int[][] actors, int n) {
        // write code here
        sort(actors, n);//按照身高进行排序，矮的排在前面
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {//对排序之后的数组按照体重求取最长递增子序列
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (actors[i][1] > actors[j][1] && dp[i] - 1 < dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    private void sort(int[][] actors, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (actors[i][0] > actors[j][0]) {
                    swap(actors,i,j);
                }
            }
        }
    }

    private void swap(int[][] actors, int i, int j) {
        int[] tmp = actors[i];
        actors[i] = actors[j];
        actors[j] = tmp;
    }
}
