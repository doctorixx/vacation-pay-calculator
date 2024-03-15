package ru.doctorixx.vacationpaycalculator.web.entity;

import lombok.Data;

import java.math.BigInteger;


@Data
public class CalculateRequest {

    private BigInteger yearSalary;
    private int vacationDays;

}
