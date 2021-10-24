package study;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator("2 + 3 * 4 / 2");
        int result = calculator.getResult();
        System.out.println("result= " + result);
    }

}
