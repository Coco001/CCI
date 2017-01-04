/**
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 * 测试样例：
 * "This is nowcoder"
 * 返回："redocwon si sihT"
 */
public class Ex_02 {
    public String reverseString(String iniString) {
        // write code here
        char[] chars = iniString.toCharArray();
        int left;
        int right;
        int len = iniString.length();
        for (int i = 0; i < len / 2; i++) {
            left = i;
            right = len - 1 - i;
            swap(chars, left, right);
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }
}
