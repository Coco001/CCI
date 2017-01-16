/**
 * 现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。
 * 给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。保证数组中元素均为正整数。
 * 测试样例：
 * [11,13,10,5,12,21,3],7
 * 返回：[13,21,12,12,21,-1,-1]
 */
public class Ex_71 {
    public int[] findNext(int[] A, int n) {
        // write code here
        int[] res = new int[n];
        boolean flag;
        for (int i = 0; i < n - 1; i++) {
            flag = false;
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    res[i] = A[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res[i] = -1;
            }
        }
        res[n - 1] = -1;
        return res;
    }
}
