package pl.pjatk;

import pl.pjatk.AbstractFactoryMethod.*;
import pl.pjatk.Adapter.*;
import pl.pjatk.Command.*;
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
import pl.pjatk.Iterator.Arts;
import pl.pjatk.Iterator.IteratorInterface;
import pl.pjatk.Iterator.Science;
import pl.pjatk.Iterator.SubjectInterface;
import pl.pjatk.Observer.AverageScoreDisplay;
import pl.pjatk.Observer.CricketData;
import pl.pjatk.Observer.CurrentScoreDisplay;
import pl.pjatk.Singleton.MakeACaptain;
import pl.pjatk.Strategy.Context;
import pl.pjatk.Strategy.OperationAdd;
import pl.pjatk.Strategy.OperationMultiply;
import pl.pjatk.Template.NetOrder;
import pl.pjatk.Template.OrderProcessTemplate;
import pl.pjatk.Template.StoreOrder;

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
        MovieFactoryInterface actionMovies = FactoryProducer.getFactory("Action");

        HollyWoodMovieInterface hAction = actionMovies.GetHollyWoodMovie();
        BollyWoodMovieInterface bAction = actionMovies.GetBollyWoodMovie();

        System.out.println("\nAction movies are:");
        System.out.println(hAction.getMovieName());
        System.out.println(bAction.getMovieName());

        MovieFactoryInterface comedyMovies = FactoryProducer.getFactory("Comedy");

        HollyWoodMovieInterface hComedy = comedyMovies.GetHollyWoodMovie();
        BollyWoodMovieInterface bComedy = comedyMovies.GetBollyWoodMovie();

        System.out.println("\nComedy movies are:");
        System.out.println(hComedy.getMovieName());
        System.out.println(bComedy.getMovieName());


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

        System.out.println("\nTESTING FACADE DESIGN PATTERNS");
        HotelKeeper keeper = new HotelKeeper();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both b = keeper.getVegNonMenu();

        System.out.println("\nTESTING TEMPLATE DESIGN PATTERNS");
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder(true);

        System.out.println("-- We changed the template to a store order --");
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);

        System.out.println("\nTESTING ITERATOR DESIGN PATTERNS");
        SubjectInterface Sc_subjects = new Science();
        SubjectInterface Ar_subjects = new Arts();

        IteratorInterface Sc_iterator = Sc_subjects.createIterator();
        IteratorInterface Ar_iterator = Ar_subjects.createIterator();

        System.out.println("Science");
        while(!Sc_iterator.isDone()) {
            System.out.println(Sc_iterator.next());
        }
        System.out.println("Arts");
        while(!Ar_iterator.isDone()) {
            System.out.println(Ar_iterator.next());
        }
    }
}
