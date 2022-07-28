package pl.pjatk.Strategy;

public class Context {
    public int executeStrategy(Strategy strategy, int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
