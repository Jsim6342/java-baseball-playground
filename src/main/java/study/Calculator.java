package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern regExp = Pattern.compile("^[0-9]*$");
    private Operator operator;
    private Formula formula;

    public Calculator(String input) {
        this.formula = new Formula(input);
    }

    public int getResult() {
        int result = 0;
        Operator nowOperator = Operator.PLUS;

        for (String now: formula.getFormula()) {
            if(regExp.matcher(now).find()) {
                result = nowOperator.operate(result, Integer.parseInt(now));
                continue;
            }
            nowOperator = Operator.findOperator(now);
        }

        return result;
    }




}
