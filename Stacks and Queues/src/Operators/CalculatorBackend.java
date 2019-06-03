package Operators;

import java.util.Stack;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class CalculatorBackend {
	public enum Ops {ADD, SUB, MULT, DIV};


	Stack<Ops> operatorStore;
	Stack<Double> numberStore;

	public CalculatorBackend()
	{
		operatorStore = new Stack<Ops>();
		numberStore = new Stack<Double>();
	}

	public boolean parse(String input)
	{
		char[] splitInput = input.toCharArray();

		int currIndex = 0;
		for (currIndex < splitInput.length)
		{

		}

		return true;
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
