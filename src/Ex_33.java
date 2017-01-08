/**
 * 给定直角坐标系上的两条直线，确定这两条直线会不会相交。
 * 线段以斜率和截距的形式给出，即double s1，double s2，double y1，double y2，
 * 分别代表直线1和2的斜率(即s1,s2)和截距(即y1,y2)，请返回一个bool，代表给定的两条直线是否相交。这里两直线重合也认为相交。
 * 测试样例：
 * 3.14,3.14,1,2
 * 返回：false
 */
public class Ex_33 {
    public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        // write code here
        if (0 == s1 + s2) {
            return true;
        }
        return Math.abs(s1 - s2) < 0.001 && Math.abs(y1 - y2) < 0.001;
    }
}
