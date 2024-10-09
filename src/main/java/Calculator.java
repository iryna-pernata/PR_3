class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Ділити на нуль не можна");
        }
        return a / b;
    }

    public double sqrt(double a) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("Неможливо обчислити квадратний корінь з від'ємного числа");
        }
        return Math.sqrt(a);
    }
}

