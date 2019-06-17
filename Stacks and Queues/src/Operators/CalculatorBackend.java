package Operators;

import java.util.Stack;

public class CalculatorBackend {
	private enum Ops
	{
		ADD, SUB, MULT, DIV, EXP, INVALID;

		/**
		 * Determines operator precedence
		 * @param opA An Ops enum
		 * @param opB An Ops enum
		 * @return -1 for opA before opB
		 * 		   0 for opA equal to opB
		 * 		   1 for opA after opB
		 */
		public static int relativePrio(Ops opA, Ops opB)
		{
			switch (opA)
			{
				case ADD:
				case SUB:
				{
					if (opB == MULT || opB == DIV || opB == EXP)
						return 1;
					else if (opB == ADD || opB == SUB)
						return 0;
					else
						throw new IllegalArgumentException();
				}
				case MULT:
				case DIV:
				{
					if (opB == EXP)
						return 1;
					else if (opB == MULT || opB == DIV)
						return 0;
					else if (opB == ADD || opB == SUB)
						return -1;
					else
						throw new IllegalArgumentException();
				}
				case EXP:
					if (opB == EXP)
						return 0;
					else if (opB == MULT || opB == DIV ||
							 opB == ADD || opB == SUB)
						return -1;
					else
						throw new IllegalArgumentException();
				case INVALID:
				default:
					throw new IllegalArgumentException();
			}
		}
	}

	private Stack<Ops> operatorStore;
	private Stack<Double> numberStore;

	private boolean hasSolution;

	/* //////////////////
		   Constructor
	*/ //////////////////

	public CalculatorBackend()
	{
		operatorStore = new Stack<Ops>();
		numberStore = new Stack<Double>();
		hasSolution = false;
	}

	/* //////////////////
		 Public Methods
	*/ //////////////////

	/**
	 * Parses and solves an equation
	 * @param input A String containing an equation to be solved
	 * @return true for successful parse, false otherwise
	 */
	public boolean parse(String input)
	{
		operatorStore.clear();
		numberStore.clear();
		hasSolution = false;

		char[] split = input.toCharArray();

		for (int index = 0; index < split.length; index++)
		{
			System.out.println("\nParsing: " + split[index]);

			if (Character.isDigit(split[index]))
				numberStore.push((double)Character.getNumericValue(split[index]));
			else if (parseOp(split[index]) != Ops.INVALID)
			{
				Ops currOp = parseOp(split[index]);
				if (operatorStore.isEmpty())
					operatorStore.push(currOp);
				else
				{
					while (!operatorStore.isEmpty() && Ops.relativePrio(currOp, operatorStore.peek()) > 0)
						solveTop(numberStore, operatorStore);
					operatorStore.push(currOp);
				}
			}
			else if (split[index] == '(')
			{
				Stack<Ops> tempOp = new Stack<Ops>();
				Stack<Double> tempNum = new Stack<Double>();

				index++;
				while (index < split.length && !(split[index] == ')'))
				{
					if (Character.isDigit(split[index]))
						tempNum.push((double)Character.getNumericValue(split[index]));
					else if (parseOp(split[index]) != Ops.INVALID)
					{
						Ops currOp = parseOp(split[index]);
						if (tempOp.isEmpty() ||
								Ops.relativePrio(currOp, tempOp.peek()) <= 0)
							tempOp.push(currOp);
						else
						{
							while (Ops.relativePrio(currOp, tempOp.peek()) > 0)
								solveTop(tempNum, tempOp);
							tempOp.push(currOp);
						}
					}

					System.out.println("///////////// In Parentheses ////////////");
					System.out.println(stackOutput(tempNum, tempOp));
					System.out.println("/////////////////////////////////////////");

					index++;
				}

				if (index >= split.length || split[index] != ')')
					return false;

				while (solveTop(tempNum, tempOp));

				numberStore.push(tempNum.peek());
			}
			else if (split[index] != ' ')
				return false;

			System.out.println(this);
		}

		while (solveTop(numberStore, operatorStore));

		if (!(numberStore.size() == 1 && operatorStore.isEmpty()))
			return false;

		hasSolution = true;
		return true;
	}

	/**
	 * Returns a formatted String of a number and an operator stack
	 * @param theNums A Stack of Doubles to output
	 * @param theOps A Stack of Ops to output
	 * @return A String containing a formatted output of the stacks
	 */
	public String stackOutput(Stack<Double> theNums, Stack<Ops> theOps)
	{
		String out = "\n";

		if (hasSolution)
		{
			out += "Solution: " + theNums.get(0);
		}
		else
		{
			out += "Operator Stack: ";
			for (int count = 0; count < theOps.size(); count++)
				out += opToString(theOps.get(count)) + " ";
			out += "\n";

			out += "Number Stack: ";
			for (int count = 0; count < theNums.size(); count++)
				out += theNums.get(count) + " ";
		}

		out += "\n";

		return out;
	}

	/**
	 * @return A formatted String revealing the contents of the
	 * 		   internal numberStore and operatorStore stacks
	 */
	public String toString()
	{
		return stackOutput(numberStore, operatorStore);
	}

	/* //////////////////
		Private Methods
	*/ //////////////////

	/**
	 * @param theOp A Character to parse
	 * @return An Ops enum representing the inputted character
	 */
	private Ops parseOp(char theOp)
	{
		switch (theOp)
		{
			case '+':
				return Ops.ADD;
			case '-':
				return Ops.SUB;
			case '*':
				return Ops.MULT;
			case '/':
				return Ops.DIV;
			case '^':
				return Ops.EXP;
			default:
				return Ops.INVALID;
		}
	}

	/**
	 * Do a calculation involving the two top most numbers of a Double stack
	 * and the top most operator of an Ops enum stack.
	 * The answer will be pushed back to the stack of Doubles
	 * @param nums The number stack to use, must be Doubles
	 * @param ops The operator stack to use, must be Ops enums
	 * @return true if there is more to solve in the two stacks,
	 * 		   false if the solution is in the nums stack
	 */
	private boolean solveTop(Stack<Double> nums, Stack<Ops> ops)
	{
		if (nums.size() == 1)
			return false;

		double numB = nums.pop();
		double numA = nums.pop();
		Ops theOp = ops.pop();

		nums.push(solve(theOp, numA, numB));

		System.out.println("Just solved: " +
							numA + " " +
							opToString(theOp) + " " +
							numB + " = " +
							nums.peek());

		return true;
	}

	/**
	 * Solves a simple formula
	 * @param theOp The operator
	 * @param numA The first number
	 * @param numB The second number
	 * @return The solution
	 */
	private double solve(Ops theOp, double numA, double numB)
	{
		switch (theOp)
		{
			case ADD:
				return numA + numB;
			case DIV:
				return numA / numB;
			case MULT:
				return numA * numB;
			case SUB:
				return numA - numB;
			case EXP:
				return Math.pow(numA, numB);
			default:
				throw new IllegalArgumentException("Math hasn't changed that much! :)");
		}
	}

	/**
	 * Converts an Ops enum to a String
	 * @param theOp An operator represented as an Ops enum
	 * @return A String representing the operator
	 */
	private String opToString(Ops theOp)
	{
		switch (theOp)
		{
			case ADD:
				return "+";
			case DIV:
				return "/";
			case MULT:
				return "*";
			case SUB:
				return "-";
			case EXP:
				return "^";
			case INVALID:
			default:
				return "?";
		}
	}
}
