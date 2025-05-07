package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTests {
  Calculator calculator = new Calculator();

  @Test
  @DisplayName("추출한 문자열을 더하는 기능 테스트")
  void add_numbers_from_String_test() throws Exception {

    assertThat(calculator.add(null)).isEqualTo(0);
    assertThat(calculator.add(new String[]{"1", "2"})).isEqualTo(3);
    assertThat(calculator.add(new String[]{"1", "2", "3"})).isEqualTo(6);

  }

  @Test
  @DisplayName("잘못된 커스텀 구분자에 대한 예외 발생 테스트")
  void wrong_format_custom_parser_exception_test() throws Exception {

    assertThatThrownBy(
        () -> {
          calculator.add(new String[]{"\1", "2"});
        }
    ).isInstanceOf(IllegalArgumentException.class);

  }
}