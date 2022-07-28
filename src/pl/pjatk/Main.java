package pl.pjatk;

import pl.pjatk.Strategy.Context;
import pl.pjatk.Strategy.OperationAdd;
import pl.pjatk.Strategy.OperationMultiply;
public class Main {
    public static void main(String[] args) {
	    Context context = new Context();
        System.out.println(context.executeStrategy(new OperationAdd(), 2,4));
        System.out.println(context.executeStrategy(new OperationMultiply(), 2,4));
    }
}
