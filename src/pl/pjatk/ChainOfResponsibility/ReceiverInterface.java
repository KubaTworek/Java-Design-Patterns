package pl.pjatk.ChainOfResponsibility;

public interface ReceiverInterface {
    public boolean processMessage(Message msg);
    public void setNextChain(ReceiverInterface nextChain);
}
