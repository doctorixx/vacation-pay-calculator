package ru.doctorixx.vacationpaycalculator.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class CalculateResponse {
    private BigInteger money;
}
