package pl.pjatk.Interpreter;

public class TerminalExpression implements Expression{
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(ContextInterpreter context) {
        return context.getResult(data);
    }
}
