package pl.pjatk.Visitor;

public class USPostageVisitor implements Visitor{
    private double totalPostageForCart = 0;

    @Override
    public void visit(Book book) {
        if(book.getPrice() < 20.0){
            totalPostageForCart += book.getWeight() * 2;
        }
    }

    @Override
    public void visit(CD cd) {
        if(cd.getPrice() < 20.0){
            totalPostageForCart += cd.getWeight() * 2.5;
        }
    }

    @Override
    public void visit(DVD dvd) {
        if(dvd.getPrice() < 20.0){
            totalPostageForCart += dvd.getWeight() * 3;
        }
    }

    public double getTotalPostage() {
        return totalPostageForCart;
    }
}
