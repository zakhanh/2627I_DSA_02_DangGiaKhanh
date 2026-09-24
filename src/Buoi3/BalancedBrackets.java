package Buoi3;

import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s){
        Stack<Character> stack =new Stack<>();
        for (char c: s.toCharArray()){
            if (!stack.isEmpty()){
                char top=stack.peek();
                boolean isMatch = (top == '(' && c == ')') ||
                        (top == '[' && c == ']') ||
                        (top == '{' && c == '}');
                if(isMatch){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        if (stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }
}
