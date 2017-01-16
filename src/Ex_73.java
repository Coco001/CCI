import com.sun.org.apache.xml.internal.serializer.ElemDesc;

/**
 * 有一篇文章内含多个单词，现给定两个单词，
 * 请设计一个高效算法，找出文中这两个单词的最短距离(即最少相隔的单词数,也就是两个单词在文章中位置的差的绝对值)。
 * 给定一个string数组article，代表所给文章，同时给定文章的单词数n和待查找的两个单词x和y。
 * 请返回两个单词的最短距离。保证两个单词均在文中出现且不相同，同时保证文章单词数小于等于1000。
 */
public class Ex_73 {
    public int getDistance(String[] article, int n, String x, String y) {
        // write code here
        int lastPosWordX = -1;
        int lastPosWordY = -1;
        int min = Integer.MAX_VALUE;
        int dis;
        for (int i = 0; i < n; i++) {
            if (article[i].equals(x)) {
                lastPosWordX = i;
                dis = lastPosWordX - lastPosWordY;
                if (lastPosWordY > 0 && min > dis) {
                    min = dis;
                }
            } else if (article[i].equals(y)) {
                lastPosWordY = i;
                dis = lastPosWordY - lastPosWordX;
                if (lastPosWordX > 0 && min > dis) {
                    min = dis;
                }
            }
        }
        return min;
    }
}
