package refactor.strategy;

public class Validator {
    private final ValidationStrategy strategy;
    public Validator(ValidationStrategy strategy){
        this.strategy = strategy;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }
}
