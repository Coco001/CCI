/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class Ex_45 {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        int flag = 0;
        char c;
        for (int i = 0; i < n; i++) {
            c = A.charAt(i);
            if (c == '(') {
                flag++;
            } else if (c == ')') {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        return flag == 0;
    }
}
