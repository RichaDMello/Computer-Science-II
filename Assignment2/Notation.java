/**
 * 
 * @author Richa D'Mello
 *
 */

public class Notation {
	private static MyQueue<String> postfix;
	private static MyStack<String> stack;
	
	
/**
 * Cinverts an infix expression to a postfix one
 * @param infix the infix expression needed to be converted
 * @return postfix expression after conversion
 * @throws StackUnderflowException
 * @throws InvalidNotationFormatException
 * @throws QueueOverflowException
 */
	public static String convertInfixToPostfix(String infix)
			throws StackUnderflowException, InvalidNotationFormatException, QueueOverflowException 
	{
		stack = new MyStack<String>(infix.length());
		postfix = new MyQueue<String>(infix.length());

		for (String a : infix.split("")) {

			if (hasDigit(a)) 
			{
				try 
				{
					postfix.enqueue(a);
				} catch (QueueOverflowException e) 
				{
					e.printStackTrace();
				}
			}

			else if (a.equals("(")) 
			{
				try 
				{
					stack.push(a);
				} catch (StackOverflowException e) 
				{
					e.printStackTrace();
				}
			} else if (hasOperator(a)) 
			{
				while (!stack.isEmpty() && hasLowerPrecedence(a, (String)stack.top()) && !a.equals("(")) 
				{
					try {
						postfix.enqueue(stack.pop());

					} catch (StackUnderflowException | QueueOverflowException e) 
					{

						e.printStackTrace();
					}
				}
				try {
					stack.push(a);
					if (stack.isEmpty());
					
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else if (a.equals(")")) {

				while (!stack.isEmpty() && !stack.top().equals("(")) {
					postfix.enqueue(stack.pop());
				}

				if (!stack.isEmpty())
					stack.pop();
				else
					throw new InvalidNotationFormatException();
			}
		}
		
		while (!stack.isEmpty()) 
		{
			try 
			{
				if (!stack.top().equals("(")) 
				{
					postfix.enqueue(stack.pop());
				}

			} 
			catch (QueueOverflowException |StackUnderflowException e) 
			{
				e.getMessage();
			}
		}

		return postfix.toString();
	}


	/**
	 * Checks if the given expression has digits in it 
	 * @param expression the expression to be checked
	 * @return true if the expression contains digits, and false if it does not.
	 */
	public static boolean hasDigit(String expression) 
	{
		try 
		{
			Integer.parseInt(expression);
			return true;
		} 
		catch (NumberFormatException e) 
		{
			return false;
		}
	}
	
	/**
	 * Converts a postfix expression to an infix expression
	 * @param postfix the postfix expression to be converted
	 * @return the converted infix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
	{
		MyStack<String> infix = new MyStack<String>(postfix.length());
		
		char[] array = postfix.toCharArray();

		for (int i = 0; i < postfix.length(); i++)
		{
			if (array[i] != ' ')
			{
				if (Character.isDigit(array[i]) )
				{
					String s = "" + postfix.charAt(i);
					infix.push(s);
				}
				else if (array[i] == '-' || array[i] == '+' || array[i] == '*' || array[i] == '/')
				{
					if (infix.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					else
					{
						String a = (String) infix.pop();
						String b = (String) infix.pop();
						String str = ( "(" + b + array[i] + a + ")" ); 
						infix.push(str);
					}
				}
			}
		}
		if (infix.size() == 1)
		{
			String endStr = infix.pop().toString();
			return endStr;
		}
		else
		{
			throw new InvalidNotationFormatException();
		}
		
	} 
	/**
	 * Evaluates the given postfix expression
	 * @param postfix postfix expression to be evaluated
	 * @return the evaluated postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException
	{
		MyStack<String> myStack = new MyStack<String>(postfix.length());
		char[] charArray = postfix.toCharArray();

		for (int i = 0; i < postfix.length(); i++)
		{
			if (charArray[i] != ' ')
			{
				if (Character.isDigit(charArray[i]) || charArray[i] == '(')
				{
					String str = "" + postfix.charAt(i);
					myStack.push(str);
				}
				else if (charArray[i] == '+' || charArray[i] == '-' || charArray[i] == '/' || charArray[i] == '*')
				{				
					if (myStack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					else
					{
						String str1 = myStack.pop().toString(); 
						String str2 = myStack.pop().toString(); 
						double doub1 = Double.parseDouble(str1);
						double doub2 = Double.parseDouble(str2);
						
						double res = 0;
						
						if (charArray[i] == '-')
						{
							res = doub2 - doub1;
						}
						else if (charArray[i] == '+')
						{					
							res = doub2 + doub1;
						}
						else if (charArray[i] == '*')
						{
							res = doub2 * doub1;
						}
						else if (charArray[i] == '/')
						{
							res = doub2 / doub1;
						}
						String str = Double.toString(res);
						myStack.push(str);
					}
				}
			}
		}
		if (myStack.size() == 1)
		{
			return Double.parseDouble(myStack.pop().toString()) ;
		}
		else
		{
			throw new InvalidNotationFormatException();
		}
	}
	
	/**
	 * Compares an operator with the order of precedence and returns a number accordingly.
	 * @param operator the operator to be ordered according to arithmetic precedence
	 * @return the number corresponding with their place in the order of precedence
	 */
	public static int precedence(String operator) 
	{
		if (operator.equals("("))
			return 0;
		else if (operator.equals("+") || operator.equals("-"))
			return 1;
		else if (operator.equals("/") || operator.equals("*"))
			return 2;
		else if (operator.equals("%"))
			return 3;
		else
			return 4;
		
	}
	/**
	 * Checks if the expression contains operators
	 * @param str the expression to be checked
	 * @return true if the ecpression contains an operator, and false otherwise.
	 */
	public static boolean hasOperator(String str) 
	{
		return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
	}

	/**
	 * Checks if one element of the expression has lower precedence than another
	 * @param a the first element
	 * @param b the second element
	 * @return true if the first element's precedence is higher, and false otherwise.
	 */
	public static boolean hasLowerPrecedence(String a, String b) 
	{
		return precedence(a) < precedence(b);
	}
	
}

