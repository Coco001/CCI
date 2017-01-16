import java.util.Arrays;

/**
 * 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。
 * 给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。
 * 测试样例：
 * [1,2,3,4,5],5,6
 * 返回：2
 */
public class Ex_67 {
    public int countPairs(int[] A, int n, int sum) {
        // write code here
        int count = 0;
        Arrays.sort(A);
        int first = 0;
        int last = n - 1;
        int s = 0;
        while (first < last) {
            s = A[first] + A[last];
            if (s == sum) {
                if (A[first] == A[last]) {//3 3 3 3 3 3 3 的情况
                    int scap = last - first + 1;
                    count += scap * (scap - 1) / 2;
                    break;
                } else {//2 2 2 2 3 3 3 4 4 4 4 4的情况
                    int k = first+1;
                    while(k <= last && A[first] == A[k]){
                        ++k;
                    }
                    int k2 = last-1;
                    while(k2 >= first && A[last] == A[k2]){
                        --k2;
                    }
                    count += (k - first) * (last - k2);
                    first = k;
                    last = k2;
                }
            } else {
                if (s < sum) {
                    first++;
                } else {
                    last--;
                }
            }
        }
        return count;
    }
}
