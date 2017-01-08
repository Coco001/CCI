
/**
 * 在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。假定正方形的上下两条边与x轴平行。
 * 给定两个vecotrA和B，分别为两个正方形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。
 * 测试样例：
 * [(0,0),(0,1),(1,1),(1,0)],[(1,0),(1,1),(2,0),(2,1)]
 * 返回：[0.0，0.5]
 */
public class Ex_35 {
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
    public double[] getBipartition(Point[] A, Point[] B) {
        // write code here
        double[] res = new double[2];
        double x1 = (A[0].x + A[1].x + A[2].x + A[3].x)/4;
        double y1 = (A[0].y + A[1].y + A[2].y + A[3].y)/4;
        double y2 = (B[0].y + B[1].y + B[2].y + B[3].y)/4;
        double x2 = (B[0].x + B[1].x + B[2].x + B[3].x)/4;
        res[0] = (y2-y1)/(x2 - x1);
        res[1] = y1 - res[0] * x1;
        return res;
    }
}
