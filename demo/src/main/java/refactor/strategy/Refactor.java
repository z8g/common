package refactor.strategy;


/**
 * 重构策略模式
 */
public class Refactor {
    public static void main(String[] args) {
        Validator v3  =new Validator(new IsAllLowerCase());
        v3.validate("asas");

        Validator v1 = new Validator(s-> s.matches("[a-z]+"));
        boolean isAllLoserCase = v1.validate("aaaaa");

        Validator v2 = new Validator((s-> s.matches("\\d+")));
        boolean isNumber = v2.validate("1212");

        System.out.println(isAllLoserCase);
        System.out.println(isNumber);
    }
}
