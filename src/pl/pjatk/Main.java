package pl.pjatk;

import pl.pjatk.Observer.AverageScoreDisplay;
import pl.pjatk.Observer.CricketData;
import pl.pjatk.Observer.CurrentScoreDisplay;
import pl.pjatk.Strategy.Context;
import pl.pjatk.Strategy.OperationAdd;
import pl.pjatk.Strategy.OperationMultiply;
public class Main {
    public static void main(String[] args) {

        // TESTING STRATEGY DESIGN PATTERNS
	    Context context = new Context();
        System.out.println(context.executeStrategy(new OperationAdd(), 2,4));
        System.out.println(context.executeStrategy(new OperationMultiply(), 2,4));

        // TESTING OBSERVER DESIGN PATTERNS
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

        CricketData cricketData = new CricketData();

        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        cricketData.dataChanged();

        cricketData.unregisterObserver(averageScoreDisplay);

        cricketData.dataChanged();

        // TESTING DECORATOR DESIGN PATTERNS
    }
}
