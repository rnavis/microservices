package com.rnavis.basics.pulsate;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1. Is the expresion balanced? check by using a stack implementation
 * 2. Infix to post fix
 * Convert the expression to character array
 * create a stack for holding operators in sequence of the poll
 * loop through each character
 * if the character is an operand, simply add it to a post-fix string
 * if the character is an operator, then
 *      check if the stack is not empty and the stack's top character is of higher precedence than the incoming character,
 *      then add the stack top character to post-fix string
 *      If the closing brace is the incoming character, and the stack top is open brace, then pop it out.
 *      if no more high-precedence entry is found in stack, then push the incoming character to stack
 *      loop through
 *
 *  Finally, if the stack is still not empty, add all the entries from the stack to post-fix string
 *
 * 3. Compute postfix expression - using stack
 */
public class InfixToPostFixExpression {

    public static void main(String args[]) {

        Scanner sc= new Scanner(System.in);
        String expression = sc.next();
        System.out.println("Infix expression = "+ expression);
        InfixToPostFixExpression convertor = new InfixToPostFixExpression();
        boolean isBalanced = convertor.isExpressionBalanced(expression);
        System.out.println("Expression balanced? "+isBalanced);
        if (!isBalanced) {
            return;
        }
        System.out.print("Post Fix expression = ");
        String postFix = convertor.postFixExpression(expression);
        System.out.println(postFix);
        System.out.println("Solved answer = ");
        System.out.println(convertor.solvePostFixExpression(postFix));
    }

    private boolean isExpressionBalanced(String expression) {
        Stack<Character> bracketStack = new Stack<>();
        for (Character c: expression.toCharArray()) {
            if (isBracket(c)) {
                if (bracketStack.isEmpty()) {
                    if (isCloseBrace(c))
                        return false;
                    else
                        bracketStack.push(c);
                } else {
                    if (isOpenBrace(c))
                        bracketStack.push(c);
                    else
                        if (isCloseBrace(c)) {
                                if (isOpenBrace(bracketStack.peek()))
                                    bracketStack.pop();
                                else
                                    return false;
                        }
                }
            }
        }
        if (bracketStack.isEmpty())
            return true;

        return false;
    }

    private String postFixExpression(String expression) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        Stack<Character> stack = new Stack();
        for (Character c: expression.toCharArray()) {
            if (!isOperator(c)) {
                sb.append(c);
            } else {
                while(!stack.isEmpty() && (isStackCharacterHigherPrecdenceThanExpressionCharacter(stack.peek(),c))) {
                    char top = stack.peek();
                    if(isCloseBrace(c) && isOpenBrace(top)) {
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
                if (!isCloseBrace(c))
                    stack.push(c);
            }

        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public Integer solvePostFixExpression(String postFixExpresion) {
        Stack<Integer> calculatedStack = new Stack<>();
        for (Character c : postFixExpresion.toCharArray()) {
            if (!isOperator(c)) {
                calculatedStack.push(Character.getNumericValue(c));
            } else {
                int first = calculatedStack.pop();
                int second = calculatedStack.pop();
                if (c == '*')
                    calculatedStack.push(second * first);
                else if (c == '/')
                    calculatedStack.push(second / first);
                else if (c == '+')
                    calculatedStack.push(second + first);
                else if (c == '-')
                    calculatedStack.push(second - first);
            }
        }
        return calculatedStack.pop();
    }
    private boolean isStackCharacterHigherPrecdenceThanExpressionCharacter(Character fromStack, Character fromExpression) {
        switch(fromStack) {
            case '/':
                return fromExpression =='+' || fromExpression =='-' || fromExpression =='*' || fromExpression == ')' ? true:false;
            case '*':
                return fromExpression =='+' || fromExpression =='-'|| fromExpression == ')' ? true:false;
            case '+':
            case '-':
                return fromExpression == '+'|| fromExpression == '-'|| fromExpression == ')' ? true:false;
            case '(':
                return fromExpression == ')'? true:false;
            default:
                return true;

        }
    }

    private boolean isOperator(Character c) {
        return isMathOperators(c)|| isBracket(c);
    }

    private boolean isMathOperators(Character c) {
        return c =='+'|| c == '-' || c == '*' || c == '/';
    }

    private boolean isBracket(Character c) {
        return isOpenBrace(c) || isCloseBrace(c);
    }

    private boolean isOpenBrace(Character c) {
        return c =='(';
    }

    private boolean isCloseBrace(Character c) {
        return c == ')';
    }
}
