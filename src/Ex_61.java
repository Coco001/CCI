/**
 * 我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。
 * 例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，槽4为蓝色)，作为玩家，你需要试图猜出颜色的组合。
 * 比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。要是只是猜对了颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。
 * 给定两个string A和guess。分别表示颜色组合，和一个猜测。
 * 请返回一个int数组，第一个元素为猜中的次数，第二个元素为伪猜中的次数。
 * 测试样例：
 * "RGBY","GGRR"
 * 返回：[1,1]
 */
public class Ex_61 {
    public static void main(String[] args) {
        calcResult("rgby", "ggrr");
    }

    public static int[] calcResult(String A, String guess) {
        // write code here
        if (A.length() != guess.length()) {
            return null;
        }
        int[] res = new int[2];
        int[] countA = new int[256];// 统计源字符串没有猜中的频率
        int[] countG = new int[256];// 统计猜测字符串没有猜中的频率

        for (int i = 0; i < A.length(); i++) {
            countA[A.charAt(i)]++;
            countG[guess.charAt(i)]++;
            if (A.charAt(i) == guess.charAt(i)) {
                res[0]++;
                countA[A.charAt(i)]--;      //当前位置被猜中
                countG[guess.charAt(i)]--;  //当前位置被猜中
            }
        }
        for (int i = 0; i < 256; i++) {
            res[1] += Math.min(countA[i], countG[i]);
        }
        return res;
    }
}
