package ufrpe.bcc.ts.imc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculoIMCTest {

    private CalculoIMC calculo;

    @BeforeEach
    void setUp() {
        calculo = new CalculoIMC();
    }

    @AfterEach
    void tearDown() {
        calculo = null;
    }

    // Test for normal weight (IMC in the "NORMAL" range)
    @Test
    void testNormalWeight() {
        String result = calculo.IMC(1.75f, 70f); // 70kg, 1.75m
        assertEquals("NORMAL", result);
    }

    // Test for underweight (IMC < 18.5)
    @Test
    void testUnderweight() {
        String result = calculo.IMC(1.75f, 50f); // 50kg, 1.75m
        assertEquals("MAGREZA", result);
    }

    // Test for overweight (IMC in the "SOBREPESO" range)
    @Test
    void testOverweight() {
        String result = calculo.IMC(1.75f, 85f); // 85kg, 1.75m
        assertEquals("SOBREPESO", result);
    }

    // Test for obesity (IMC in the "OBESIDADE" range)
    @Test
    void testObesity() {
        String result = calculo.IMC(1.75f, 100f); // 100kg, 1.75m
        assertEquals("OBESIDADE", result);
    }

    // Test for severe obesity (IMC in the "OBESIDADE GRAVE" range)
    @Test
    void testSevereObesity() {
        String result = calculo.IMC(1.75f, 130f); // 130kg, 1.75m
        assertEquals("OBESIDADE GRAVE", result);
    }

    // Test for height <= 0 (invalid input)
    @Test
    void testInvalidHeightZero() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculo.IMC(0f, 70f); // Invalid height (0)
        });
        assertEquals("Altura e peso devem ser maiores que zero.", thrown.getMessage());
    }

    // Test for weight <= 0 (invalid input)
    @Test
    void testInvalidWeightZero() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculo.IMC(1.75f, 0f); // Invalid weight (0)
        });
        assertEquals("Altura e peso devem ser maiores que zero.", thrown.getMessage());
    }

    // Test for negative height (invalid input)
    @Test
    void testInvalidHeightNegative() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculo.IMC(-1.75f, 70f); // Invalid height (-1.75)
        });
        assertEquals("Altura e peso devem ser maiores que zero.", thrown.getMessage());
    }

    // Test for negative weight (invalid input)
    @Test
    void testInvalidWeightNegative() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            calculo.IMC(1.75f, -70f); // Invalid weight (-70)
        });
        assertEquals("Altura e peso devem ser maiores que zero.", thrown.getMessage());
    }
}
