/**
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，
 * 保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 * 测试样例
 * "aabcccccaaa"
 * 返回："a2b1c5a3"
 * "welcometonowcoderrrrr"
 * 返回："welcometonowcoderrrrr"
 */
public class Ex_05 {
    public String zipString(String iniString) {
        // write code here
        int index;
        char per;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iniString.length(); i++) {
            per = iniString.charAt(i);
            index = 0;
            sb.append(per);
            for (int j = i + 1; j < iniString.length(); j++) {
                if (iniString.charAt(j) != iniString.charAt(i)) {
                    break;
                }
                index++;
            }
            sb.append(index);
            i += index-1;
        }
        return sb.length() < iniString.length() ? String.valueOf(sb) : iniString;
    }
}
