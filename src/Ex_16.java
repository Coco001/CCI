import java.util.ArrayList;
import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class Ex_16 {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            if (stack1.isEmpty() || stack1.peek() < numbers[i]) {
                stack1.push(numbers[i]);
            } else {
                while (!stack1.isEmpty() && stack1.peek() > numbers[i]) {
                    stack2.push(stack1.pop());
                }
                stack1.push(numbers[i]);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
        }
        while (!stack1.isEmpty()) {
            res.add(stack1.pop());
        }
        return res;
    }
}
