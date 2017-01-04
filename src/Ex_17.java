import java.util.ArrayList;

/**
 * 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
 * 第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
 * 给定一个操作序列int[][2] ope代表所有事件。
 * 若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
 * 若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，
 * 若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 * 测试样例：
 * [[1,1],[1,-1],[2,0],[2,-1]]
 * 返回：[1,-1]
 */
public class Ex_17 {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();//领养的序列
        ArrayList<Integer> list = new ArrayList<>();//收养的序列
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) {//有动物进入
                list.add(ope[i][1]);
            } else if (ope[i][0] == 2) {//有动物被领养
                if (list.size() == 0) {
                    continue;
                }
                int tmp;
                if (ope[i][1] == 0) {//领养最先进入的动物
                    tmp = list.get(0);
                    list.remove(0);
                    res.add(tmp);
                } else if (ope[i][1] == 1) {//领养最先进入的狗
                    for (int j = 0; j < list.size(); j++) {
                        tmp = list.get(j);
                        if (tmp > 0) {
                            list.remove(j);
                            res.add(tmp);
                            break;
                        }
                    }
                } else if (ope[i][1] == -1) {//领养最先进入的猫
                    for (int j = 0; j < list.size(); j++) {
                        tmp = list.get(j);
                        if (tmp < 0) {
                            list.remove(j);
                            res.add(tmp);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
