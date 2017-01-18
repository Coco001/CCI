import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 现有一些随机生成的数字要将其依次传入，请设计一个高效算法，
 * 对于每次传入一个数字后，算出当前所有传入数字的中位数。(若传入了偶数个数字则令中位数为第n/2小的数字，n为已传入数字个数)。
 * 给定一个int数组A，为传入的数字序列，同时给定序列大小n，请返回一个int数组，代表每次传入后的中位数。保证n小于等于1000。
 * 测试样例：
 * [1,2,3,4,5,6],6
 * 返回：[1,1,2,2,3,3]
 */
public class Ex_76 {
    public int[] getMiddle(int[] A, int n) {
        // write code here
        if(A==null || n<1)
            return null;
        int[] res = new int[n];
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1,Integer i2) {
                return i2.compareTo(i1);
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue(n,cmp);
        PriorityQueue<Integer> minHeap = new PriorityQueue(n);
        for(int i=0;i<n;i++) {
            maxHeap.offer(A[i]);
            if(i%2==1) {
                minHeap.offer(maxHeap.poll());
                //res[i] =(maxHeap.peek()+minHeap.peek())/2;
            } else{
                if(!minHeap.isEmpty()){
                    if(maxHeap.peek()>minHeap.peek()) {
                        Integer ma = maxHeap.poll();
                        Integer mi = minHeap.poll();
                        maxHeap.offer(mi);
                        minHeap.offer(ma);
                    }
                }
            }
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
