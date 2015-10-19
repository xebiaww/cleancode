package com.badcode.names;

public class StartCalculator {

    public double calc(int firstNumber, int secondNumber, int operationPerformed) {
        if (operationPerformed == 0)
            return firstNumber + secondNumber;
        else if (operationPerformed == 1)
            return firstNumber - secondNumber;
        else if (operationPerformed == 2)
            return firstNumber * secondNumber;
        else if(operationPerformed == 3)
            return firstNumber/secondNumber;
        return 0;
    }

    public String opName(int op) {
        if (op == 0)
            return "Add";
        if (op == 1)
            return "Subtract";
        if (op == 2)
            return "Multiply";
        if (op == 3)
            return "Divide";
        return "unknown";

    }

    public boolean getSupport(int op) {
        if (op > 3)
            return false;
        return true;
    }

}
