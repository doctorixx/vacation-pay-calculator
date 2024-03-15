package ru.doctorixx.vacationpaycalculator.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.doctorixx.vacationpaycalculator.service.CalculatorService;
import ru.doctorixx.vacationpaycalculator.web.entity.CalculateRequest;
import ru.doctorixx.vacationpaycalculator.web.entity.CalculateResponse;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/calculate")
    public Object index(@RequestBody CalculateRequest request) {

        BigInteger vacationMoney = calculatorService.calculateVacationMoney(
                request.getYearSalary(),
                request.getVacationDays()
        );



        return new CalculateResponse(vacationMoney);
    }
}
