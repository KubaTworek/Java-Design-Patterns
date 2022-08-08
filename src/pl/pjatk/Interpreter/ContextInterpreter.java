package pl.pjatk.Interpreter;

public class ContextInterpreter {
    private String input;

    public ContextInterpreter(String input) {
        this.input = input;
    }

    public boolean getResult(String data){
        if(input.contains(data)){
            return true;
        } else {
            return false;
        }
    }
}
