package study;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (firstNum, secondNum) -> firstNum + secondNum),
    MINUS("-", (firstNum, secondNum) -> firstNum - secondNum),
    MULTIPLY("*", (firstNum, secondNum) -> firstNum * secondNum),
    DIVIDE("/", (firstNum, secondNum) -> {
            if(secondNum == 0) {throw new IllegalArgumentException();}
            return firstNum / secondNum;
    });

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;
    private static final Map<String, Operator> operatorMap =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(operator -> operator.getSymbol(), operator -> operator)));


    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int operate(int first, int second) {
        return operation.apply(first, second);
    }

    public static Operator findOperator(String symbol) {

        Operator operator = operatorMap.get(symbol);

        if(operator == null) throw new IllegalArgumentException();
        return operator;
    }

}
