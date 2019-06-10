package Operators;

import java.util.ArrayList;
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

		return goParse(input);
	}

	private boolean goParse(String input)
	{
		char[] split = input.toCharArray();

		ArrayList<Double> numberTemp = new ArrayList<Double>();
		ArrayList<Ops> opTemp = new ArrayList<Ops>();

		for (int index = 0; index < split.length; index++)
		{
			if (Character.isDigit(split[index]))
				numberTemp.add((double)Character.getNumericValue(split[index]));
			else if (parseOp(split[index]) != Ops.INVALID)
				opTemp.add(parseOp(split[index]));
			else if (split[index] != ' ')
				return false;
		}

		int lowPrio;
		while (!opTemp.isEmpty())
		{
			lowPrio = 0;
			for (int index = 0; index < opTemp.size(); index++)
			{
				if (opTemp.get(index).compareTo(opTemp.get(lowPrio)) > 0)
					lowPrio = index;
			}

			operatorStore.push(opTemp.remove(lowPrio));
			numberStore.push(numberTemp.remove(lowPrio));
			numberStore.push(numberTemp.remove(lowPrio + 1));
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
		operatorStore.add(theOp);
	}

	public void addNumber(Double theNumber)
	{
		numberStore.add(theNumber);
	}

	public boolean solveAll()
	{
		if (isValid() == false)
			return false;

		while (!operatorStore.empty())
		{
			double numA = numberStore.pop();
			double numB = numberStore.pop();
			Ops theOp = operatorStore.pop();

			numberStore.push(solve(theOp, numA, numB));
		}

		return true;
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
		if (numberStore.size() == 1 && operatorStore.isEmpty())
			return true;

		if (numberStore.isEmpty() && operatorStore.isEmpty())
			return false;

		if (numberStore.size() != operatorStore.size() + 1)
			return false;

		return true;
	}

	public String toString()
	{
		if (isValid() == false)
			return "Invalid State";

		String out = "\n";

		if (operatorStore.isEmpty())
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
