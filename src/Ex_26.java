import java.util.AbstractCollection;

/**
 * 有一个介于0和1之间的实数，类型为double，返回它的二进制表示。
 * 如果该数字无法精确地用32位以内的二进制表示，返回“Error”。
 * 给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。
 * 测试样例：
 * 0.625
 * 返回：0.101
 */
public class Ex_26 {
    public static void main(String[] args) {
        System.out.println(printBin(0.625));
    }
    public static String printBin(double num) {
        // write code here
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double apend;
        while (num != 0 && sb.length() < 33) {
            num *= 2;
            apend = num - 1;
            if (apend >= 0) {
                sb.append(1);
                num -= 1;
            } else {
                sb.append(0);
            }
        }
        return sb.length() > 32 ? "Error" : sb + "";
    }
}
