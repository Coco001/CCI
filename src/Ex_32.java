/**
 * 在n个顶点的多边形上有n只蚂蚁，这些蚂蚁同时开始沿着多边形的边爬行，请求出这些蚂蚁相撞的概率。(这里的相撞是指存在任意两只蚂蚁会相撞)
 * 给定一个int n(3<=n<=10000)，代表n边形和n只蚂蚁，请返回一个double，为相撞的概率。
 * 测试样例：
 * 3
 * 返回：0.75
 */
public class Ex_32 {
    public double antsCollision(int n) {
        // write code here
        int noTrack = 2;
        double count = (int) Math.pow(2, n);
        return (count - noTrack) / count;
    }
}
