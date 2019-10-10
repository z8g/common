package use;

import io.StdOut;
import java.util.Scanner;
import ds.impl.LinkedStack;

/**
 *
 * @author zhaoxuyang
 */
public class StackTest {

    public static void main(String[] args) {
        evaluate();
    }

    /**
     * Dijkstra的双栈算数表达式求值算法
     */
    public static void evaluate() {
        String str = "( 1 + ( ( 2.3 + 3 ) / ( sqrt ( 16 ) * ( 5 % 9 ) ) ) )";
        LinkedStack<String> opStack = new LinkedStack<>();
        LinkedStack<Double> valStack = new LinkedStack<>();
        Scanner scanner = new Scanner(str);
        while (scanner.hasNext()) {
            String s = scanner.next();
            StdOut.print(s + ' ');
            switch (s) {

                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "sqrt":
                    opStack.push(s);
                    break;
                case "(":
                    break;
                case ")":
                    String op = opStack.pop();
                    double v = valStack.pop();
                    switch (op) {
                        case "+":
                            v = valStack.pop() + v;
                            break;
                        case "-":
                            v = valStack.pop() - v;
                            break;
                        case "*":
                            v = valStack.pop() * v;
                            break;
                        case "/":
                            v = valStack.pop() / v;
                            break;
                        case "%":
                            v = valStack.pop() % v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                        default:
                            break;
                    }
                    valStack.push(v);
                    break;
                default:
                    valStack.push(Double.parseDouble(s));
                    break;
            }
        }
        StdOut.printf("= %f\n", valStack.pop());
    }
}
