package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        Parser parser = new Parser();
        String[] numbers = parser.parse(scanner.nextLine());

        Calculator calculator = new Calculator();
        int result = calculator.add(numbers);

        System.out.println("결과 : " + result);

        scanner.close();
    }
}
