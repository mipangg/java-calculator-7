package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTests {

  Parser parser = new Parser();

  @Test
  @DisplayName("basic parser test")
  void basic_parser_test() throws Exception {

    assertThat(parser.parse("")).isNull();
    assertThat(parser.parse("1,2")).isEqualTo(new String[]{"1", "2"});
    assertThat(parser.parse("1, 2")).isEqualTo(new String[]{"1", "2"});
    assertThat(parser.parse("1,2,3")).isEqualTo(new String[]{"1", "2", "3"});
    assertThat(parser.parse("1,2:3")).isEqualTo(new String[]{"1", "2", "3"});

  }

  @Test
  @DisplayName("custom parser test")
  void custom_parser_test() throws Exception {

    assertThat(parser.parse("//;\\n1;2;3")).isEqualTo(new String[]{"1", "2", "3"});
    assertThat(parser.parse("//;\\n1")).isEqualTo(new String[]{"1"});

  }

  @Test
  @DisplayName("multiple custom parser test")
  void multiple_custom_parser_test() throws Exception {

    assertThat(parser.parse("//;\\n//k\\n//.\\n1;2k3.4"))
        .isEqualTo(new String[]{"1", "2", "3", "4"});

  }

  @Test
  @DisplayName("커스텀 구분자가 없는 경우 테스트")
  void no_custom_parser_test() throws Exception {

    assertThat(parser.parse("//\\n1:2")).isEqualTo(new String[]{"1", "2"});

  }

  @Test
  @DisplayName("두 글자 이상의 커스텀 구분자를 시도할 경우 발생하는 예외 테스트")
  void IllegalArgumentException_test() throws Exception {

    assertThatThrownBy(
        () -> {
          parser.parse("//kr\\n1:2");
        }
    ).isInstanceOf(IllegalArgumentException.class);

  }

}
