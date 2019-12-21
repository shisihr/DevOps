package ua.yermolenko.model;

public class Operation {
    private int firstNumber;
    private int secondNumber;

    public Operation() {
    }

    public Operation(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {

        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Integer add(int a, int b) {
        return a+b;
    }

    public Integer substract(int a, int b) {
        return a - b;
    }

    public Integer multiply(int a, int b) {return a*b;}

    public Integer divide(int a, int b) {
        return (b != 0 ? a/b : null);
    }

    public Double calculate(Integer firstNumber, Integer secondNumber, String operator) {
        double result = 0.0;
        if ("+".equalsIgnoreCase(operator)) {
            result = firstNumber + secondNumber;
        }
        else if ("-".equalsIgnoreCase(operator)) {
            result = firstNumber - secondNumber;
        }
        else if ("*".equalsIgnoreCase(operator)) {
            result = firstNumber * secondNumber;
        }
        else if ("/".equalsIgnoreCase(operator)) {
            if (secondNumber != 0) {
                result = firstNumber / secondNumber;
            }
        }
        return result;
    }
}
