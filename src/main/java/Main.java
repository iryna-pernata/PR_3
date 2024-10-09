import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean keepRunning = true;

        while (keepRunning) {
            try {
                System.out.println("Введіть перше число:");
                double num1 = scanner.nextDouble();

                System.out.println("Введіть друге число (не потрібно для операції sqrt):");
                double num2 = scanner.nextDouble();

                System.out.println("Виберіть операцію (+, -, *, /, sqrt або 'exit' для виходу):");
                String operation = scanner.next();

                if (operation.equals("exit")) {
                    System.out.println("Вихід з програми...");
                    keepRunning = false;

                    continue;
                }

                if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/") && !operation.equals("sqrt")) {
                    System.out.println("Невідома операція. Спробуйте ще раз.");
                    continue;
                }

                double result = 0;

                switch (operation) {
                    case "+":
                        result = calculator.add(num1, num2);
                        break;
                    case "-":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "/":
                        result = calculator.divide(num1, num2);
                        break;
                    case "sqrt":
                        result = calculator.sqrt(num1);
                        System.out.println("Результат квадратного кореня: " + result);
                        continue;
                }

                System.out.println("Результат: " + result);

            } catch (ArithmeticException | InvalidInputException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Помилка: Введено некоректне значення. Будь ласка, введіть число.");
                scanner.next();
            } finally {
                System.out.println("Операція завершена.");
            }
        }

        scanner.close();
    }
}

