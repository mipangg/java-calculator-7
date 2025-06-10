package calculator;

public class Calculator {

  public int add(String[] numbers) throws IllegalArgumentException {
    int sum = 0;

    if (numbers == null || numbers[0].isBlank()) {
      return sum;
    }

    try {
      for (String number : numbers) {
        int numberInt = Integer.parseInt(number);
        if (numberInt < 0) {
          throw new IllegalArgumentException("모든 숫자는 양수여야 합니다.");
        }
        sum += numberInt;
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("알 수 없는 문자가 포함되어 있습니다.");
    }

    return sum;
  }

}
