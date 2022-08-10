package pl.pjatk.Visitor;

public class SouthAmericaPostageVisitor implements Visitor{
    private double totalPostageForCart = 0;

    @Override
    public void visit(Book book) {
        if(book.getPrice() < 30.0){
            totalPostageForCart += (book.getWeight() * 2) * 2;
        }
    }

    @Override
    public void visit(CD cd) {
        if(cd.getPrice() < 30.0){
            totalPostageForCart += (cd.getWeight() * 2.5) * 2;
        }
    }

    @Override
    public void visit(DVD dvd) {
        if(dvd.getPrice() < 30.0){
            totalPostageForCart += (dvd.getWeight() * 3) * 2;
        }
    }

    public double getTotalPostage() {
        return totalPostageForCart;
    }
}
