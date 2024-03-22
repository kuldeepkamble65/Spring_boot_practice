package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        // Create a mock of the Calculator class
        Calculator calculatorMock = mock(Calculator.class);

        // Stub the behavior of the add method
        when(calculatorMock.add(2, 3)).thenReturn(5);

        // Perform the test using the mock
        int result = calculatorMock.add(2, 3);

        // Verify that the add method was called with the specified arguments
        verify(calculatorMock).add(2, 3);

        // Assert the result
        assertEquals(5, result);
    }

    private Calculator mock(Class<Calculator> calculatorClass) {
    }

    @Test
    public void testSubtract() {
        // You can also create a spy, which is a partial mock
        Calculator calculatorSpy = spy(new Calculator());

        // Stub the behavior of the subtract method
        when(calculatorSpy.subtract(5, 2)).thenReturn(3);

        // Perform the test using the spy
        int result = calculatorSpy.subtract(5, 2);

        // Verify that the subtract method was called with the specified arguments
        verify(calculatorSpy).subtract(5, 2);

        // Assert the result
        assertEquals(3, result);

        // Since subtract is a real method, unstubbed calls will use the real implementation
        assertEquals(10, calculatorSpy.subtract(12, 2));
    }
}
