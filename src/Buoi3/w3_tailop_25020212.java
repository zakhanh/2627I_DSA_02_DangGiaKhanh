package Buoi3;

import java.util.Stack;
import java.util.Scanner;

public class w3_tailop_25020212 {
    static int precedence(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case'/':
                return 2;
            default:
                return -1;
        }
    }

    static String infixToPostfix(String expression){
        // SỬA Ở ĐÂY: Đổi s thành result
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<expression.length();i++){
            char c = expression.charAt(i);
            if (c == ' ') continue;

            if (Character.isLetterOrDigit(c)){
                result.append(c);
            } else if (c == '('){
                stack.push(c);
            } else if(c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(' ){
                    result.append(stack.pop());
                }
                if (stack.isEmpty()) return "Bieu thuc khong hop le (thieu dau ngoac mo)";
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (stack.peek() == '(') break;
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Bieu thuc khong hop le (thua dau ngoac mo)";
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap bieu thuc trung to (Input): ");
        String infix = scanner.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println("Bieu thuc hau to (Output): " + postfix);

        scanner.close();
    }
}