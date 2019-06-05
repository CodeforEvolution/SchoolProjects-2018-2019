package Operators;

import java.util.Stack;

public class CalculatorBackend {
	public enum Ops {ADD, SUB, MULT, DIV, INVALID};

	Stack<Ops> operatorStore;
	Stack<Double> numberStore;

	public CalculatorBackend()
	{
		operatorStore = new Stack<Ops>();
		numberStore = new Stack<Double>();
	}

	/**
	 * Each number/operator should be separated by spaces
	 * @param A string to parse into an equation;
	 * @return true for a successful parse, false if not
	 */
	public boolean parse(String input)
	{
		char[] splitInput = input.toCharArray();

		if (splitInput.length % 5 != 0)
			return false;

		int currIndex = 0;
		while (currIndex + 2 < splitInput.length)
		{
			if (!(Character.isDigit(splitInput[currIndex]) &&
				Character.isDigit(splitInput[currIndex + 1]) &&
				parseOp(splitInput[currIndex + 2]) != Ops.INVALID));
			{
				operatorStore.clear();
				numberStore.clear();
				return false;
			}

			numberStore.push((double)Character.getNumericValue(splitInput[currIndex]));
			numberStore.push(splitInput[currIndex + 1]);
			operatorStore.push(parseOp(splitInput[currIndex + 2]));
		}

		return true;
	}

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
			default:
				return Ops.INVALID;
		}
	}

	public void addOperator(Ops theOp)
	{
		operatorStore.push(theOp);
	}

	public void addNumber(Double theNumber)
	{
		numberStore.push(theNumber);
	}

	/**
	 * @return true if one step was successfully solved, false if not
	 */
	public boolean solveStep()
	{
		if (isValid() == false)
			return false;

		double numA = numberStore.pop();
		double numB = numberStore.pop();
		Ops theOp = operatorStore.pop();

		numberStore.push(solve(theOp, numA, numB));

		return true;
	}

	public void solveAll()
	{
		while (solveStep());
	}

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
			default:
				throw new IllegalArgumentException("Math hasn't changed that much! :)");
		}
	}

	private boolean isValid()
	{
		int indexNum = 0;
		int indexOps = 0;

		if (indexOps * 2 != indexNum)
			return false;

		return true;
	}
}
