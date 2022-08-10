package pl.pjatk.Visitor;

import java.util.ArrayList;

public class VisitorClient {
    public static ArrayList<Visitable> items = new ArrayList();

    public static double calculatePostage(Visitor visitor){
        for(Visitable item: items){
            item.accept(visitor);
        }
        double postage = visitor.getTotalPostage();
        return postage;
    }

}
