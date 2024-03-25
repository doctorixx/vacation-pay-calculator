package ru.doctorixx.vacationpaycalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.doctorixx.vacationpaycalculator.service.CalculatorService;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceTest {
    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void calcTest() {


        assertEquals(BigInteger.ONE,
                calculatorService.calculateVacationMoney(
                        BigInteger.valueOf(365),
                        1
                )
        );

        assertEquals(BigInteger.TWO,
                calculatorService.calculateVacationMoney(
                        BigInteger.valueOf(365 * 2),
                        1
                )
        );

        assertEquals(BigInteger.TEN,
                calculatorService.calculateVacationMoney(
                        BigInteger.valueOf(365 * 10),
                        1
                )
        );

        assertEquals(BigInteger.valueOf(100),
                calculatorService.calculateVacationMoney(
                        BigInteger.valueOf(365 * 10),
                        10
                )
        );
    }
}
