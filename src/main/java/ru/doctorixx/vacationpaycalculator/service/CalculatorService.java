package ru.doctorixx.vacationpaycalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CalculatorService {

    private final int DAYS_IN_YEAR = 356;

    public BigInteger calculateVacationMoney(BigInteger salary, int days){
        BigInteger moneyPerDay = salary.divide(BigInteger.valueOf(DAYS_IN_YEAR));
        return moneyPerDay.multiply(BigInteger.valueOf(days));
    }
}
