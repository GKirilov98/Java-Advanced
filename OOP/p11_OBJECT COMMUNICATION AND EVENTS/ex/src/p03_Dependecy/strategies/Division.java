package p03_Dependecy.strategies;

import p03_Dependecy.ActionCalculator;

public class Division implements ActionCalculator {
    @Override
    public int Calculate(int firstOperand, int secondOperand) {
        return  firstOperand / secondOperand;
    }
}
