package study;

public class Formula {

    private String[] formula;

    public Formula(String input) {
        this.formula = input.split(" ");
    }

    public String[] getFormula() {
        return formula;
    }
}

