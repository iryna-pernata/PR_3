import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void divideTest() {
        Exception exception = Assert.assertThrows(ArithmeticException.class, () -> {
            calc.divide(1, 0);
        });
        Assert.assertEquals("Ділити на нуль не можна", exception.getMessage());
    }

    @Test
    public void sqrtTest() {
        Exception exception = Assert.assertThrows(InvalidInputException.class, () -> {
            calc.sqrt(-2);
        });
        Assert.assertEquals("Неможливо обчислити квадратний корінь з від'ємного числа", exception.getMessage());
    }

    @Test
    public void testIsNumber() {
        assertTrue(isNumber("5"));
        assertTrue(isNumber("3.14"));

        assertFalse(isNumber("abc"));
        assertFalse(isNumber("1.2.3"));
        assertFalse(isNumber(""));
        assertFalse(isNumber(null));
    }

    private boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
