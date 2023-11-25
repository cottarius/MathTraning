package model;

public class Model {
    private int firstNumber;
    private int secondNumber;

    public Model() {
    }
    public int addition(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    public int subtraction(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }
    public int Multiply(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }
    public boolean isEqual(int mathResult, int inputResult){
        return mathResult == inputResult;
    }
}
