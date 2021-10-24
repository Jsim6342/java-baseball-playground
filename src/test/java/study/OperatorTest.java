package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @DisplayName("plus, minus, multiply, divide 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+:12", "-:8", "*:20", "/:5"}, delimiter = ':')
    void operatorTest(String value, int expected) {
        int result = Operator.findOperator(value).operate(10, 2);
        assertThat(result).isEqualTo(expected);
    }
}
