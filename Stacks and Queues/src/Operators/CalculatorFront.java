package Operators;

public class CalculatorFront {
    public static void main(String[] args)
    {
        CalculatorBackend backend = new CalculatorBackend();
        System.out.println(backend.parse("5 5 + 6 *"));

        System.out.println(backend);
    }
}
