package p03_Dependecy;


import p03_Dependecy.strategies.Addition;
import p03_Dependecy.strategies.Division;
import p03_Dependecy.strategies.Multiplication;
import p03_Dependecy.strategies.Subtraction;

public class PrimitiveCalculator {

    private boolean isAddition;
    private boolean isMultiplycation;
    private boolean isSubstraction;
    private boolean isDevision;
    private Addition additionStrategy;
    private Subtraction subtractionStrategy;
    private Multiplication multiplicationStrategy;
    private Division divisionStrategy;

    public PrimitiveCalculator() {
        this.additionStrategy = new Addition();
        this.subtractionStrategy = new Subtraction();
        this.multiplicationStrategy = new Multiplication();
        this.divisionStrategy = new Division();
        this.isAddition = true;
    }

    public void changeStrategy(char operator) {
        switch (operator) {
            case '+':
                this.isAddition = true;
                this.isSubstraction = false;
                this.isMultiplycation = false;
                this.isDevision = false;
                break;
            case '-':
                this.isAddition = false;
                this.isSubstraction = true;
                this.isMultiplycation = false;
                this.isDevision = false;
                break;
            case '*':
                this.isAddition = false;
                this.isSubstraction = false;
                this.isMultiplycation = true;
                this.isDevision = false;
                break;
            case '/':
                this.isAddition = false;
                this.isSubstraction = false;
                this.isMultiplycation = false;
                this.isDevision = true;
                break;


        }
    }


    public int performCalculation(int firstOperand, int secondOperand) {
        if (this.isAddition) {
            return additionStrategy.Calculate(firstOperand, secondOperand);
        } else if (isSubstraction) {
            return subtractionStrategy.Calculate(firstOperand, secondOperand);
        } else if (isDevision) {
            return divisionStrategy.Calculate(firstOperand, secondOperand);
        } else {
            return multiplicationStrategy.Calculate(firstOperand, secondOperand);
        }
    }
}
