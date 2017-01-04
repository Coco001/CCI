import java.util.ArrayList;

/**
 * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
 * 该数据结构应支持与普通栈相同的push和pop操作。
 * 给定一个操作序列int[][2] ope，每个操作的第一个数代表操作类型，
 * 若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
 * 请返回一个int[][]，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
public class Ex_14 {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        if (ope.length == 0) {
            return null;
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        lists.add(list);
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) {//push操作
                if (list.size() == size) {
                    list = new ArrayList<>();
                    lists.add(list);
                }
                list.add(ope[i][1]);
            } else {
                if (list.size() == 0) {
                    lists.remove(lists.size()-1);//删除已经变空的
                    list = lists.get(lists.size()-1);//获取一个新的
                }
                list.remove(list.size()-1);
            }
        }
        return lists.size() == 0 ? null : lists;
    }

}
