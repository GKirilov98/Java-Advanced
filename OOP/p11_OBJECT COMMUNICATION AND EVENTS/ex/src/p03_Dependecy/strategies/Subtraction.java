package p03_Dependecy.strategies;

import p03_Dependecy.ActionCalculator;

public class Subtraction implements ActionCalculator {
    public int Calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
