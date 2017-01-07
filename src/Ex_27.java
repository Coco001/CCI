/**
 * 有一个正整数，请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小)
 * 给定正整数int x，请返回一个vector，代表所求的两个数（小的在前）。保证答案存在。
 * 测试样例：
 * 2
 * 返回：[1,4]
 */
public class Ex_27 {

    public int[] getCloseNumber(int x) {
        int[] result = new int[2];
        result[0] = getPrev(x);
        result[1] = getNext(x);
        return result;
    }

    private int getNext(int n) {
        //规定非拖尾0的位置（从右为0开始向左数）为p
        //计算c0和c1，C0：p右边0的个数 C1:p右边1的个数 易知：p=c0+c1
        //计算c0和c1
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while ((c & 1) == 0 && (c != 0)) {//计算拖尾0的个数
            c0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {//计算拖尾1的个数
            c1++;
            c >>= 1;
        }

        //错误：若n==前面连续若干个1，后面连续若干个0，那么就没有更大的数
        //此处31也行吧??
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        int p = c0 + c1;//最右边非拖尾0的位置
        n |= (1 << p); //将非拖尾0变成1
        n &= ~((1 << p) - 1);//将p右边的所有位清0
        n |= (1 << (c1 - 1)) - 1;//在p右方插入(c1-1)个1
        return n;
    }

    private int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {//计算拖尾1的个数
            c1++;
            temp >>= 1;
        }

        if (temp == 0) return -1;//全是1，不存在比他小且1的个数相同的数字

        while (((temp & 1) == 0) && (temp != 0)) {//计算拖尾0的个数
            c0++;
            temp >>= 1;
        }

        int p = c0 + c1; //最右边，非拖尾1的位置
        n &= ((~0) << (p + 1));//将位0到p清0

        int mask = (1 << (c1 + 1)) - 1;//（c1+1）个1
        n |= mask << (c0 - 1);

        return n;
    }


    //暴力破解
    public int[] getCloseNumber01(int x) {
        // write code here
        int[] res = new int[2];
        if ((x & (x - 1)) == 0) {
            res[0] = x >> 1;
            res[1] = x << 1;
        }
        int numOne = countOne(x);
        res[0] = x - 1;
        res[1] = x + 1;
        while (countOne(res[0]) != numOne) {
            res[0] -= 1;
        }
        while (countOne(res[1]) != numOne) {
            res[1] += 1;
        }
        return res;
    }

    private static int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= (--num);
        }
        return count;
    }
}
