import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。
 * 有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
 * 然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
 * 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
 * 以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。
 * 给定一个int n，代表游戏的人数。请返回最后一个人的编号
 * 测试样例：
 * 5
 * 返回：5
 */
public class Ex_51 {
    public static void main(String[] args) {
        System.out.println(getResult(5));
    }

    public static int getResult(int n) {
        // write code here
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int flag = 2;
        while (queue.size() > 1) {
            int size = queue.size();
            for (int i = 0, removeIndex = 0, count = 1; i < size; i++, count++) {//count为当前报的数字，removeIndex为需要删除的数字
                if (count % flag != 1) {
                    queue.remove(removeIndex);//删除的时候保证删除索引不增加
                } else {
                    removeIndex++;
                }
            }
            Integer last = queue.removeLast();
            queue.offerFirst(last);
            flag++;
        }
        return queue.peek();
    }
}
