package pl.pjatk.Template;

public class NetOrder extends OrderProcessTemplate{
    @Override
    public void doSelect() {
        System.out.println("Item added to online shopping cart");
        System.out.println("Get gift wrap preference");
        System.out.println("Get delivery address");
    }

    @Override
    public void doPayment() {
        System.out.println("Online Payment through Netbanking, card or Pay pal");
    }

    @Override
    public void doDelivery() {
        System.out.println("Ship the item through post office to delivery address");
    }
}
