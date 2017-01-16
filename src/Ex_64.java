/**
 * 有一个非负整数，请编写一个算法，打印该整数的英文描述。
 * 给定一个int x，请返回一个string，为该整数的英文描述。
 * 测试样例：
 * 1234
 * 返回："One Thousand,Two Hundred Thirty Four"
 */
public class Ex_64 {
    private String[] digits = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] bigs = {"", "Thousand", "Million", "Billion"};
    public String toString(int x) {
        // write code here
        if (x == 0) {
            return "Zero";
        } else if (x < 0) {
            return "Negative" + toString(-1 * x);
        }
        String str = "";
        int count = 0;
        while (x > 0) {
            if (x % 1000 != 0) {
                str = numToString100(x % 1000) + bigs[count] + "," + str;
            }
            x /= 1000;
            count++;
        }
        if (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        return str.trim();
    }

    private String numToString100(int num) {
        String str = "";
        //转换百位的数字
        if (num >= 100) {
            str += digits[num / 100] + " Hundred ";
            num %= 100;
        }
        //转换十位数的地方
        if (num >= 11 && num <= 19) {
            return str + teens[num - 11] + " ";
        } else if (num == 10 || num >= 20) {
            str += tens[num / 10] + " ";
            num %= 10;
        }
        //转换个位数的地方
        if (num >= 1 && num <= 9) {
            str += digits[num] + " ";
        }
        return str;
    }
}
