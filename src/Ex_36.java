import java.util.HashMap;

/**
 * 在二维平面上，有一些点，请找出经过点数最多的那条线。
 * 给定一个点集vector p和点集的大小n,没有两个点的横坐标相等的情况,
 * 请返回一个vector，代表经过点数最多的那条直线的斜率和截距。
 */
public class Ex_36 {
    private class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point() {
            this.x = 0;
            this.y = 0;
        }
    }
    //自定义的Map中存放的value，包含了直线的截距与直线经过的点数
    private class Bt{
        double b;
        int times;

        public Bt(double b, int times) {
            this.b = b;
            this.times = times;
        }
    }
    public double[] getLine(Point[] p, int n) {
        // write code here
        Bt per;//上一个结点
        Bt cur = new Bt(0, 0);//当前结点
        int max = 0;//记录经过最最点的点数
        Line res = new Line(p[0], p[1]);//记录经过最多点的直线
        double[] kb = new double[2];//返回的结果
        HashMap<Double, Bt> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Line line = new Line(p[i], p[j]);
                if (map.containsKey(line.k)) {
                    per = map.get(line.k);
                    cur.b = per.b;
                    cur.times = per.times + 1;
                    if (max < cur.times) {
                        res = line;
                    }
                    map.remove(line.k);
                    map.put(line.k, cur);
//                    map.replace(line.k, per, cur);
                } else {
                    cur.b = line.k;
                    cur.times = 0;
                    map.put(line.k, cur);
                }
            }
        }
        kb[0] = res.k;
        kb[1] = res.b;
        return kb;
    }

    private class Line{
        private double k, b;
        private boolean overBig = false;
        private Line(Point p1, Point p2) {
            if (Math.abs(p1.x - p2.x) > 0.0001) {
                k = (p1.y - p2.y) / (p1.x - p2.x);
                b = p1.y - k * p1.x;
            } else {//斜率无穷大
                overBig = true;
            }
        }
    }
}
