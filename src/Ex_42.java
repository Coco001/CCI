/**
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。
 * 给定一个不下降序列，元素值可能相同，编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 * 测试样例：
 * [1,1,3,4,5]
 * 返回：true
 */
public class Ex_42 {
    public boolean findMagicIndex(int[] A, int n) {
        // write code here

        for (int i = 0; i < n; ) {
            if (A[i] == i) {
                return true;
            } else {
                i = Math.max(A[i], i + 1);
            }
        }
        return false;
        //return func(A, 0, n - 1);
    }

    private boolean func(int[] arr, int left, int right) {
        if (left > right || left < 0 || right > arr.length) {
            return false;
        }
        int mid = (right - left) / 2 + left;
        if (arr[mid] == mid) {
            return true;
        } else {
            int halfL = Math.min(arr[mid], mid - 1);
            int halfR = Math.max(arr[mid], mid + 1);
            return func(arr, left, halfL) || func(arr, halfR, right);
        }
    }
}
