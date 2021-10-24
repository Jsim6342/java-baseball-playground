package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    void plusTest() {
        calculator = new Calculator("1 + 2");
        int result = calculator.getResult();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minusTest() {
        calculator = new Calculator("6 - 3");
        int result = calculator.getResult();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void multiplicationTest() {
        calculator = new Calculator("5 * 3");
        int result = calculator.getResult();
        assertThat(result).isEqualTo(15);
    }

    @Test
    void divisionTest() {
        calculator = new Calculator("6 / 3");
        int result = calculator.getResult();
        assertThat(result).isEqualTo(2);
    }

    @Test
    void stringCalculatorTest() {
        calculator = new Calculator("2 + 3 * 4 / 2");
        int result = calculator.getResult();
        assertThat(result).isEqualTo(10);

    }

    @DisplayName("0 으로 나눌 시 테스트")
    @Test
    void divideZeroTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator = new Calculator("2 / 0");
            calculator.getResult();
        });
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우")
    @Test
    void inputNullOrEmptyTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator("2 +   * 2 / 2");
            int result = calculator.getResult();
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우")
    @Test
    void checkPermittedOperator(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator("2 $ 6 * 5 / 4");
            int result = calculator.getResult();
        });
    }

}
