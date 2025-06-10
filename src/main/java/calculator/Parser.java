package calculator;

public class Parser {

  public String[] parse(String input) {
    String text = input.replaceAll(" ", "")
        .replaceAll("\\.", ",");

    if (text.isEmpty()) {
      return null;
    }

    String PARSER = ",|:";

    while (text.startsWith("//")) {
      text = changeCustomToBasicParser(text);
    }

    String[] split = text.split(PARSER);

    return split;
  }

  private String changeCustomToBasicParser(String text) {
    final String COMMA = ",";

    String[] split = text.split("n", 2);

    if (!split[0].endsWith("\\")) {
      throw new IllegalArgumentException("커스텀 구분자 양식을 지켜주세요. ");
    }

    String customParser = split[0].replace("//", "")
        .replace("\\", "");

    if (customParser.length() > 1) {
      throw new IllegalArgumentException("커스텀 구분자는 1 개 씩 저장해야 합니다. 현재 : " + customParser);
    }

    if (customParser.isEmpty()) {
      return split[1];
    }

    return split[1].replaceAll(customParser, COMMA);
  }

}
