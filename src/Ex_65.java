import com.sun.org.apache.xml.internal.serializer.ElemDesc;

/**
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。
 * 给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
 * 测试样例：
 * [1,2,3,-6,1]
 * 返回：6
 */
public class Ex_65 {
    public int getMaxSum(int[] A, int n) {
        // write code here
        int max = A[0];
        int sum = A[0];
        for (int i = 1; i < n; i++) {
            if (sum + A[i] > A[i]) {
                sum += A[i];
            } else {
                sum = A[i];
            }
            if (max < sum) {//max中始终保存最大值
                max = sum;
            }

            //全是负数的时候返回0
           /* sum += A[i];
            if (max < sum) {//max中始终保存最大值
                max = sum;
            } else if (sum < 0) {//当前累计加结果小于0时，重新计算
                sum = A[i];
            }*/
        }
        return max;
    }
}
