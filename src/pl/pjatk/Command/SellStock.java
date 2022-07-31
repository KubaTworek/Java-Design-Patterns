package pl.pjatk.Command;

public class SellStock implements Order{
    private Stock myStock;

    public SellStock(Stock myStock) {
        this.myStock = myStock;
    }

    @Override
    public void execute() {
        myStock.sell();
    }
}
