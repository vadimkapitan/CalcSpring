package pro.sky.CalculatorCap;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public int calculatorPlus(int num1, int num2) {
        return num1 + num2;
    }

    public int calculatorMinus(int num1, int num2) {
        return num1 - num2;

    }

    public int calculatorMultiply(int num1, int num2) {
        return num1 * num2;
    }

    public int calculatorDivide(int num1, int num2) {

        return num1 / num2;

    }
}
