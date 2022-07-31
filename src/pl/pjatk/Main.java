package pl.pjatk;

import pl.pjatk.Adapter.*;
import pl.pjatk.Command.Broker;
import pl.pjatk.Command.BuyStock;
import pl.pjatk.Command.SellStock;
import pl.pjatk.Command.Stock;
import pl.pjatk.Decorator.Circle;
import pl.pjatk.Decorator.Rectangle;
import pl.pjatk.Decorator.RedShapeDecorator;
import pl.pjatk.Decorator.Shape;
import pl.pjatk.Facade.Both;
import pl.pjatk.Facade.HotelKeeper;
import pl.pjatk.Facade.NonVegMenu;
import pl.pjatk.Facade.VegMenu;
import pl.pjatk.FactoryMethod.AnimalFactoryInterface;
import pl.pjatk.FactoryMethod.AnimalInterface;
import pl.pjatk.FactoryMethod.ConcreteFactory;
import pl.pjatk.Observer.AverageScoreDisplay;
import pl.pjatk.Observer.CricketData;
import pl.pjatk.Observer.CurrentScoreDisplay;
import pl.pjatk.Singleton.MakeACaptain;
import pl.pjatk.Strategy.Context;
import pl.pjatk.Strategy.OperationAdd;
import pl.pjatk.Strategy.OperationMultiply;
public class Main {
    public static void main(String[] args) {

        System.out.println("TESTING STRATEGY DESIGN PATTERNS");
	    Context context = new Context();
        System.out.println(context.executeStrategy(new OperationAdd(), 2,4));
        System.out.println(context.executeStrategy(new OperationMultiply(), 2,4));

        System.out.println("\nTESTING OBSERVER DESIGN PATTERNS");
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

        CricketData cricketData = new CricketData();

        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        cricketData.dataChanged();

        cricketData.unregisterObserver(averageScoreDisplay);

        cricketData.dataChanged();

        System.out.println("\nTESTING DECORATOR DESIGN PATTERNS");
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        circle.draw();
        redCircle.draw();
        redRectangle.draw();

        System.out.println("\nTESTING FACTORY DESIGN PATTERNS");
        AnimalFactoryInterface animalFactory = new ConcreteFactory();

        try {
            AnimalInterface duckType = animalFactory.GetAnimalType("Duck");
            duckType.speak();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            AnimalInterface tigerType = animalFactory.GetAnimalType("Tiger");
            tigerType.speak();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nTESTING ABSTRACT FACTORY DESIGN PATTERNS");


        System.out.println("\nTESTING SINGLETON DESIGN PATTERNS");
        System.out.println("Making captain for our team");

        MakeACaptain c1 = MakeACaptain.getCaptain();

        System.out.println("Making another captain");
        MakeACaptain c2 = MakeACaptain.getCaptain();

        if(c1 == c2){
            System.out.println("c1 and c2 are the same instance");
        }

        System.out.println("\nTESTING COMMAND DESIGN PATTERNS");
        Stock googleStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(googleStock);
        SellStock sellStockOrder = new SellStock(googleStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();

        System.out.println("\nTESTING ADAPTER DESIGN PATTERNS");
        MediaPlayerInterface audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "jasonsMusic.mp3");

        AdvancedMediaPlayerInterface mp4Player = new Mp4Player();
        MediaPlayerInterface advancedMediaPlayerAdapter1 = new AdvancedMediaPlayerAdapter(mp4Player);
        advancedMediaPlayerAdapter1.play("mp4", "alone.mp4");

        AdvancedMediaPlayerInterface vlcPlayer = new VlcPlayer();
        MediaPlayerInterface advancedMediaPlayerAdapter2 = new AdvancedMediaPlayerAdapter(vlcPlayer);
        advancedMediaPlayerAdapter2.play("vlc", "far far away.vlc");

        audioPlayer.play("vlc", "far far away.vlc");

        HotelKeeper keeper = new HotelKeeper();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both b = keeper.getVegNonMenu();

    }
}
