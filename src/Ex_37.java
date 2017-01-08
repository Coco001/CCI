import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。
 * 给定一个数int k，请返回第k个数。保证k小于等于100。
 * 测试样例：
 * 3
 * 返回：7
 */
public class Ex_37 {
    public static void main(String[] args) {
        System.out.println(findKth(16));
    }

    private static int findKth01(int k) {
        int num = 3;
        int temp;
        while (num != 0 && k != 0) {
            temp = num;
            while (temp % 3 == 0)
                temp /= 3;
            while (temp % 5 == 0)
                temp /= 5;
            while (temp % 7 == 0)
                temp /= 7;
            if (1 == temp)
                k--;
            num++;
        }
        return --num;
    }

    public static int findKth(int k) {
        // write code here
        if (k < 0) {
            return 0;
        }
        int val = 1;
        Queue<Integer> queue = new LinkedList<>();
        addProducts(queue, val);
        for (int i = 0; i < k; i++) {
            val = getMin(queue);
            addProducts(queue, val);
        }
        return val;
    }

    private static void addProducts(Queue<Integer> q, int i) {
        for (int j = 3; j < 8; j += 2) {
            if (!q.contains(i * j)) {
                q.add(i * j);
            }
        }
    }

    private static int getMin(Queue<Integer> q) {
        int min = q.peek();
        for (Integer tmp : q) {
            if (tmp < min) {
                min = tmp;
            }
        }
        q.remove(min);
        return min;
    }
}
