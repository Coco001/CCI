import java.util.Arrays;

/**
 * 有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。
 * 注意：n-m应该越小越好，也就是说，找出符合条件的最短序列。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。
 * (原序列位置从0开始标号,若原序列有序，返回[0,0])。保证A中元素均为正整数。
 * 测试样例：
 * [1,4,6,5,9,10],6
 * 返回：[2,3]
 */
public class Ex_63 {
    public static void main(String[] args) {
        findSegment(new int[]{1, 2, 10, 1, 8, 9}, 6);
    }
    public static int[] findSegment(int[] A, int n) {
        // write code here
        int[] res = new int[2];
        int[] tmp = Arrays.copyOf(A, n);
        Arrays.sort(A);
        boolean flagLeft = true;
        boolean flagRight = true;
        for (int i = 0; i < n; i++) {
            if (A[i] != tmp[i] && flagLeft) {
                res[0] = i;
                flagLeft = false;
            }
            if (A[n - i - 1] != tmp[n - 1 - i] && flagRight) {
                res[1] = n - 1 - i;
                flagRight = false;
            }
            if (!flagLeft && !flagRight) {
                break;
            }
        }

        return res;
    }
}
