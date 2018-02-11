package com.rnavis.basics.pulsate;

import java.util.*;

/**
 * Reverse String
 * 1. iterative method
 * 2. using stack
 * 3. balanced parantheses problem
 * 4. convert infix expression to post fix expression
 */
public class CharacterArrayBased {
    public static void main(String args[]) {
        CharacterArrayBased test = new CharacterArrayBased();
        String data = "lasrever";
        System.out.println("Current =" +data);
        System.out.print("After = " );
        test.reverse(data);

        System.out.println("\nalternately using stack...");
        test.stackReverse(data);
        System.out.println("Checked balanced parathesis expression ...");
        System.out.println("test is balanced? "+ test.isExpressionParanthesisBalanced("test"));
        System.out.println("empty is balanced? "+ test.isExpressionParanthesisBalanced(""));
        System.out.println("null is balanced? "+ test.isExpressionParanthesisBalanced(null));
        System.out.println("{} is balanced? "+ test.isExpressionParanthesisBalanced("{}"));
        System.out.println("[] is balanced? "+ test.isExpressionParanthesisBalanced("[]"));
        System.out.println("() is balanced? "+ test.isExpressionParanthesisBalanced("()"));
        System.out.println("( is balanced? "+ test.isExpressionParanthesisBalanced("("));
        System.out.println("{ is balanced? "+ test.isExpressionParanthesisBalanced("{"));
        System.out.println("{{ is balanced ?"+ test.isExpressionParanthesisBalanced("{{"));
        System.out.println("{{}}} is balanced ?"+ test.isExpressionParanthesisBalanced("{{}}}"));
        System.out.println("tria{% fsdjfdsfsj ') []) is balanced ?"+ test.isExpressionParanthesisBalanced("tria{% fsdjfdsfsj ') [])"));
        System.out.println("tria{% fsdjfdsfsj '( []){}}) is balanced ?"+ test.isExpressionParanthesisBalanced("tria{% fsdjfdsfsj '( []){}})"));
        System.out.println("tria{({% fsdjfdsfsj '( [take a test]){}})} is balanced ?"+ test.isExpressionParanthesisBalanced("tria{({% fsdjfdsfsj '( [take a test]){}})}"));

    }
    private void reverse(String data) {
        char[] array = data.toCharArray();
        for (int i=array.length-1;i>=0;i--) {
            System.out.print(array[i]);
        }
    }

    private void stackReverse(String data) {
        char[] array = data.toCharArray();
        Stack<Character> stack = new Stack<>();

        System.out.println("Before.. ");
        for (int i =0; i<array.length;i ++){
            stack.push(array[i]);
            System.out.print(stack.peek());
        }
        System.out.println("");
        System.out.println("After....");
        for (int i=0; i< array.length; i++) {
            System.out.print(stack.pop());
        }
    }

    private boolean isExpressionParanthesisBalanced(String expression) {
        if (expression == null || expression =="") {
            System.out.println("Empty expression");
            return true;
        }
        char[] characters = expression.toCharArray();
        char[] data = new char[]{'{', '}', '[', ']', '(', ')'};
        List<Character> interestedCharacters = new ArrayList<>();
        for (Character c: data) {
            interestedCharacters.add(c);
        }
        //Sample data {test.[b]test}
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < characters.length; i++) {
            if (interestedCharacters.contains(characters[i])) {
                if (stack.isEmpty()) {
                    if (characters[i] == '{' || characters[i] == '[' || characters[i] =='(') {
                        stack.push(characters[i]);
                    } else {
                        return false;
                    }
                } else {
                    if (characters[i] == '{' || characters[i] == '[' || characters[i] =='(') {
                        stack.push(characters[i]);
                    } else {
                        char topChar = stack.peek();
                        if (topChar == '{' && characters[i] =='}') {
                            stack.pop();
                        } else if (topChar == '[' && characters[i] ==']') {
                            stack.pop();
                        } else if (topChar == '(' && characters[i] ==')') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
