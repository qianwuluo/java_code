import java.util.Stack;

/**
 * ClassName: Test_Stack
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 2023/7/4 21:54
 * @Version 1.0
 */
public class Test_Stack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.add("jack");
        stack.add("Tom");
        stack.add("Smith");

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
