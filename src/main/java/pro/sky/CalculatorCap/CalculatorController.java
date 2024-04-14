package pro.sky.CalculatorCap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String calculatorWelcomeAnswer() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String calculatorPlus(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.calculatorPlus(num1, num2);
        return massage(num1,num2,'+',result);
    }

    @GetMapping(path = "/minus")
    public String calculatorMinus(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.calculatorMinus(num1, num2);
        return massage(num1,num2,'-',result);
    }

    @GetMapping(path = "/multiply")
    public String calculatorMultiply(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.calculatorMultiply(num1, num2);
        return massage(num1, num2, '*', result);
    }

    @GetMapping(path = "/divide")
    public String calculatorDivide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Второй аргумент равен = 0. На ноль делить нельзя.";
        }
        int result = calculatorService.calculatorDivide(num1, num2);
        return massage(num1, num2, '/', result);
    }

    private String massage(int num1, int num2, char symbyl, int result) {
        return String.format("%d %c %d = % d", num1, symbyl, num2, result);
    }
}
