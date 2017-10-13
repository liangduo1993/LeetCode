package stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another
 * expression. Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author Liang
 *
 */
public class evaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		int result = 0;

		if (tokens.length == 1)
			return Integer.parseInt(tokens[0]);
		Stack<Integer> stack = new Stack<>();
		for (String current : tokens) {
			if (!isCal(current)) {
				stack.push(Integer.parseInt(current));
				System.out.println(stack);
				continue;
			}
			if (isCal(current)) {
				int two = stack.pop();
				int one = stack.pop();
				switch (current) {
				case "+":
					result = one + two;
					stack.push(result);
					break;
				case "-":
					result = one - two;
					stack.push(result);
					break;
				case "*":
					result = one * two;
					stack.push(result);
					break;
				case "/":
					result = one / two;
					stack.push(result);
					break;
				}
			}

		}

		return result;
	}

	public boolean isCal(String input) {
		String[] string = new String[] { "+", "-", "*", "/" };
		for (String s : string) {
			if (s.equals(input.trim()))
				return true;
		}
		return false;
	}
	

}
