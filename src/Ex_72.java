/**
 * 现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。
 * 给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。
 * 测试样例：
 * [11,13,10,5,12,21,3],7
 * [12,21,12,12,21,-1,-1]
 */
public class Ex_72 {
    public int[] findNext(int[] A, int n) {
        // write code here
        int[] res = new int[n];
        int tmp;
        boolean flag;
        for (int i = 0; i < n - 1; i++) {
            tmp = Integer.MAX_VALUE;
            flag = false;
            for (int j = i + 1; j < n; j++) {
                if (A[j] > A[i]) {
                    tmp = Math.min(A[j], tmp);
                    flag = true;
                }
            }
            if (!flag) {
                res[i] = -1;
            } else {
                res[i] = tmp;
            }
        }
        res[n - 1] = -1;
        return res;
    }
}
