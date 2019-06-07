package Operators;

import java.util.Stack;

public class CalculatorBackend {
	private static int CHUNK_SIZE = 5;

	public enum Ops {ADD, SUB, MULT, DIV, INVALID}

	Stack<Ops> operatorStore;
	Stack<Double> numberStore;

	public CalculatorBackend()
	{
		operatorStore = new Stack<Ops>();
		numberStore = new Stack<Double>();
	}

	public boolean parse(String input)
	{
		operatorStore.clear();
		numberStore.clear();

		if (parseOld(input))
			return true;

		if (parseNew(input))
			return true;

		return false;
	}

	/**
	 * Each number/operator should be separated by spaces, old calculation
	 * @param input A string to parse into an equation;
	 * @return true for a successful parse, false if not
	 */
	private boolean parseOld(String input)
	{
		char[] splitInput = input.toCharArray();

		if ((splitInput.length % 2) == 0)
			return false;

		int currIndex = 0;
		while (currIndex + CHUNK_SIZE - 1 < splitInput.length)
		{
			if (!(Character.isDigit(splitInput[currIndex]) &&
				Character.isDigit(splitInput[currIndex + 2]) &&
				parseOp(splitInput[currIndex + 4]) != Ops.INVALID))
			{
				operatorStore.clear();
				numberStore.clear();
				return false;
			}

			numberStore.push((double)Character.getNumericValue(splitInput[currIndex]));
			numberStore.push((double)Character.getNumericValue(splitInput[currIndex + 2]));
			operatorStore.push(parseOp(splitInput[currIndex + 4]));

			currIndex += CHUNK_SIZE;
		}

		return isValid();
	}

	private boolean parseNew(String input)
	{
		return false;
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
		while (!(numberStore.size() == 1 && operatorStore.empty()) && solveStep());
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
		// We might have the solution...
		if (numberStore.size() == 1 && operatorStore.empty())
			return true;

		if (numberStore.empty() && operatorStore.empty())
			return false;

		if (numberStore.size() % 2 != 0)
			return false;

		return true;
	}

	public String toString()
	{
		if (isValid() == false)
			return "Invalid State";

		String out = "\n";

		if (operatorStore.empty())
		{
			out += numberStore.get(0);
			return out;
		}

		int numIndex = 0;
		int opsIndex = 0;
		while (numIndex + 1 < numberStore.size())
		{
			out += numberStore.get(numIndex) + " ";
			out += numberStore.get(numIndex + 1) + " ";
			out += opToString(operatorStore.get(opsIndex));

			numIndex += 2;
			opsIndex++;
		}

		out += "\n";

		return out;
	}

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
			case INVALID:
			default:
				return "?";
		}
	}
}
