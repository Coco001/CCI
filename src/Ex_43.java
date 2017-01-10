import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 请编写一个方法，返回某集合的所有非空子集。
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
 * 保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序，见样例。
 * 测试样例：
 * [123,456,789]
 * 返回：{[789,456,123],[789,456],[789,123],[789],[456 123],[456],[123]}
 */
public class Ex_43 {
    public static void main(String[] args) {
        int[] test = new int[]{0,1};
        getSubsets(test, 2);
    }
    public static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // write code here
        ArrayList<ArrayList<Integer>> per = new ArrayList<>();//存储之前的结果
        ArrayList<ArrayList<Integer>> cur = new ArrayList<>();//存储添加当前元素的结果
        ArrayList<Integer> tmp;//当前元素
        ArrayList<Integer> t;
        Arrays.sort(A);//对数组进行排序
        for (int i = 0; i < n; i++) {
            tmp = new ArrayList<>();
            tmp.add(A[i]);
            cur.clear();
            cur = new ArrayList<>();
            cur.addAll(per);//添加之前元素的组合
            cur.add(tmp);//添加当前元素
            for (ArrayList<Integer> al : per) {//添加之前的组合与当前元素的组合
                t = new ArrayList<>();
                t.add(A[i]);
                t.addAll(al);
                cur.add(t);
            }
            per = new ArrayList<>();
            per.addAll(cur);
        }
        Collections.reverse(cur);
        return cur;
    }
}
