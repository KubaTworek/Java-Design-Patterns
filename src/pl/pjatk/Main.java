package pl.pjatk;

import pl.pjatk.AbstractFactoryMethod.*;
import pl.pjatk.Adapter.*;
import pl.pjatk.Bridge.*;
import pl.pjatk.Builder.*;
import pl.pjatk.ChainOfResponsibility.*;
import pl.pjatk.Command.*;
import pl.pjatk.Composite.*;
import pl.pjatk.Decorator.*;
import pl.pjatk.Decorator.Rectangle;
import pl.pjatk.Facade.*;
import pl.pjatk.FactoryMethod.*;
import pl.pjatk.Flyweight.CounterStrike;
import pl.pjatk.Flyweight.Player;
import pl.pjatk.Flyweight.PlayerFactory;
import pl.pjatk.Interpreter.ContextInterpreter;
import pl.pjatk.Interpreter.Expression;
import pl.pjatk.Interpreter.Interpreter;
import pl.pjatk.Iterator.*;
import pl.pjatk.Mediator.AuctionBuyer;
import pl.pjatk.Mediator.AuctionMediator;
import pl.pjatk.Mediator.Buyer;
import pl.pjatk.Observer.*;
import pl.pjatk.Proxy.Internet;
import pl.pjatk.Proxy.ProxyInternet;
import pl.pjatk.Singleton.*;
import pl.pjatk.State.AlertStateContext;
import pl.pjatk.State.Silent;
import pl.pjatk.Strategy.*;
import pl.pjatk.Template.*;

import java.util.List;

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

        System.out.println("\nTESTING COMPOSITE DESIGN PATTERNS");
        Supervisor technologyDean = new Supervisor("Dr. Mike", "Dean of Technology");
        Supervisor chairOfMathDepartment = new Supervisor("Dr. John", "Chair of Math Department");
        Supervisor chairOfComputerScienceDepartment = new Supervisor("Dr. Ian", "Chair Of CS Department");

        Professor mathProf1 = new Professor("Math Professor1", "Adjunct", 302);
        Professor mathProf2 = new Professor("Math Professor2", "Associate", 303);

        Professor cseProf1 = new Professor ("CSE Professor1", "Adjunct", 507);
        Professor cseProf2 = new Professor ("CSE Professor2", "Professor", 508);
        Professor cseProf3 = new Professor ("CSE Professor3", "Professor", 509);

        technologyDean.add(chairOfMathDepartment );
        technologyDean.add(chairOfComputerScienceDepartment );

        chairOfMathDepartment.add(mathProf1);
        chairOfMathDepartment.add(mathProf2);

        chairOfComputerScienceDepartment.add(cseProf1);
        chairOfComputerScienceDepartment.add(cseProf2);
        chairOfComputerScienceDepartment.add(cseProf3);

        System.out.println("\nThe college has the following structure\n");

        System.out.println(technologyDean.getDetails());
        List<Faculty> chairs=technologyDean.getMyFaculty();

        for(int i=0;i<chairs.size();i++)
        {
            System.out.println("\t"+chairs.get(i).getDetails());
        }

        List<Faculty> mathProfessors= chairOfMathDepartment.getMyFaculty();
        for(int i=0;i<mathProfessors.size();i++)
        {
            System.out.println("\t\t"+ mathProfessors.get(i).getDetails());
        }

        List<Faculty> cseProfessors= chairOfComputerScienceDepartment.getMyFaculty();
        for(int i=0;i<cseProfessors.size();i++)
        {
            System.out.println("\t\t"+cseProfessors.get(i).getDetails());
        }

        chairOfComputerScienceDepartment.remove(cseProf2);

        System.out.println("\n After CSE Professor2 leaving the organization- CSE department has following faculty:");

        cseProfessors = chairOfComputerScienceDepartment.getMyFaculty();
        for(int i=0;i< cseProfessors.size();i++)
        {
            System.out.println("\t\t"+ cseProfessors.get(i).getDetails());
        }

        System.out.println("\nTESTING STATE DESIGN PATTERNS");
        AlertStateContext stateContext = new AlertStateContext();

        stateContext.alert();
        stateContext.alert();

        stateContext.setState(new Silent());

        stateContext.alert();
        stateContext.alert();
        stateContext.alert();

        System.out.println("\nTESTING PROXY DESIGN PATTERNS");
        Internet internet = new ProxyInternet();

        try {
            internet.connectTo("jasonfedin.org");
            internet.connectTo("whatever.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTESTING BRIDGE DESIGN PATTERNS");
        System.out.println("\nColoring Triangle");
        ColorInterface green = new GreenColor();
        ShapeBridge triangleShape = new Triangle(green);
        triangleShape.drawShape(20);
        triangleShape.modifyBorder(20,3);

        System.out.println("\nColoring Rectangle");
        ColorInterface red = new RedColor();
        ShapeBridge rectangleShape = new RectangleBridge(red);
        rectangleShape.drawShape(50);
        rectangleShape.modifyBorder(50,2);

        System.out.println("\nTESTING BRIDGE DESIGN PATTERNS");
        Director director = new Director();

        MealBuilderInterface vegMealBuilder = new VegMealBuilder();
        MealBuilderInterface nonVegMealBuilder = new NonVegMealBuilder();

        director.construct(vegMealBuilder);
        Meal vegMeal = vegMealBuilder.getMeal();

        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        director.construct(nonVegMealBuilder);
        Meal nonVegMeal = nonVegMealBuilder.getMeal();

        System.out.println("Non-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());

        System.out.println("\nTESTING CHAIN OF RESPONSIBILITY DESIGN PATTERNS");
        ReceiverInterface faxHandler, emailHandler;

        emailHandler = new EmailErrorHandler();
        faxHandler = new FaxErrorHandler();
        faxHandler.setNextChain(emailHandler);

        IssueRaiser raiser = new IssueRaiser(faxHandler);

        Message m1 = new Message("Fax is whatever", MessagePriority.High);
        Message m2 = new Message("Email is whatever", MessagePriority.High);
        Message m3 = new Message("Fax is downgrade", MessagePriority.Normal);
        Message m4 = new Message("Email is downgrade", MessagePriority.Normal);

        raiser.raiseMessage(m1);
        raiser.raiseMessage(m2);
        raiser.raiseMessage(m3);
        raiser.raiseMessage(m4);

        System.out.println("\nTESTING FLYWEIGHT DESIGN PATTERNS");
        for (int i = 0; i < 10; i++)  {
            Player p = PlayerFactory.getPlayer(CounterStrike.getRandPlayerType());

            p.assignWeapon(CounterStrike.getRandWeapon());

            p.mission();
        }

        System.out.println("\nTESTING INTERPRETER DESIGN PATTERNS");
        Expression isMale = Interpreter.getMaleExpression();
        Expression isMarriedWoman = Interpreter.getMarriedWomanExpression();

        ContextInterpreter ic = new ContextInterpreter("John");
        System.out.println("John is male? " + isMale.interpret(ic));

        ContextInterpreter ic2 = new ContextInterpreter("Married Julie");
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret(ic2));

        ContextInterpreter ic3 = new ContextInterpreter("Lucy");
        System.out.println("Lucy is male? " + isMale.interpret(ic3));

        System.out.println("\nTESTING MEDIATOR DESIGN PATTERNS");
        AuctionMediator med = new AuctionMediator();

        Buyer b1 = new AuctionBuyer(med,"Jason");
        Buyer b2 = new AuctionBuyer(med,"Ian");
        Buyer b3 = new AuctionBuyer(med,"Myra");

        med.addBuyer(b1);
        med.addBuyer(b2);
        med.addBuyer(b3);

        System.out.println("Welcome to the auction. Tonight we are selling a vacation to Zanzibar");
        System.out.println("-------------------------------------------------------");
        System.out.println("Waiting for the buyers offers..");

        b1.bid(1800);
        b2.bid(2000);
        b3.bid(780);

        System.out.println("-------------------------------------------------------");
        med.findHighestBidder();
    }

}
