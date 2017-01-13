
/**
 * 有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，
 * 例如，原数组为[1,2,3,4,5,6]，向左移位5个位置即变成了[6,1,2,3,4,5],现在对于移位后的数组，
 * 需要查找某个元素的位置。请设计一个复杂度为log级别的算法完成这个任务。
 * 给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，
 * 请返回x的位置(位置从零开始)。保证数组中元素互异。
 * 测试样例：
 * [6,1,2,3,4,5],6,6
 * 返回：0
 */
public class Ex_53 {
    public static void main(String[] args) {
        int[] test = new int[]{4,5,6, 1, 2, 3};
        System.out.println(findElement(test, 6, 5));
    }
    public static int findElement(int[] A, int n, int x) {
        // write code here
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] < x) {//本应该搜索右半部分，现在需要判断
                if (A[mid] < A[left] && x > A[right]) {//右侧有序，并且寻找的数比右侧最大值还大，一定在左边出现
                    right = mid - 1;
                } else {//否则在右边出现
                    left = mid + 1;
                }
            } else {//本应该搜索左半部分
                if (A[mid] > A[left] && x < A[left]) {//左侧有序，且寻找的数比左侧最小值还小，一定在右侧
                    left = mid + 1;
                } else {//否则在左侧
                    right = mid - 1;
                }
            }
        }
        return mid;
    }
}
