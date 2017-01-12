import java.util.LinkedList;
import java.util.Queue;

/**
 * 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。
 * 然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
 * 给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
 * 测试样例：
 * 5 3
 * 返回：4
 */
public class Ex_50 {
    public static void main(String[] args) {
        System.out.println(getResult(5, 3));
    }
    public static int getResult(int n, int m) {
        // write code here
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }
        int index = 0;
        int tmp;
        while (queue.size() > 1) {
            tmp = queue.poll();
            index++;
            if (index != m) {
                queue.add(tmp);
            } else {
                index = 0;
            }
        }
        return queue.peek();
    }
}
