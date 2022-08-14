package skypro.courcetwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculateController {

    private final CalculateService calculateService;

    public CalculateController(CalculateServiceImpl calculateServiceImpl) {
        this.calculateService = calculateServiceImpl;
    }

    @GetMapping()
    public String welcome() {
        return "Добро пожаловать в калькулятор ";
    }

    @GetMapping(path = "/plus")
    public String sum(@RequestParam(name = "num1") Integer a,
                      @RequestParam(name = "num2") Integer b) {
        if (a==null || b==null){
            return ("Нужно задать значение переменной 'а'и переменной 'b'");
        }
        int sum = calculateService.sum(a, b);
        return a + "+" + b + "=" + sum;
    }

    @GetMapping(path = "/diff")
    public String diff(@RequestParam(name = "num1") Integer a,
                       @RequestParam(name = "num2") Integer b) {
        if (a==null || b==null){
            return ("Нужно задать значение переменной 'а'и переменной 'b'");
        }
        int diff = calculateService.diff(a, b);
        return a + "-" + b + "=" + diff;
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(name = "num1") Integer a,
                           @RequestParam(name = "num2") Integer b) {
        if (a==null || b==null){
            return ("Нужно задать значение переменной 'а'и переменной 'b'");
        }
        int multiply = calculateService.multiply(a, b);
        return a + "*" + b + "=" + multiply ;
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if(b==0){
           return  ("На ноль делить нельзя");
        }
         if (a==null || b==null){
            return ("Нужно задать значение переменной 'а'и переменной 'b'");
        }
        double divide = calculateService.divide(a, b);
        return a + "/" + b + "=" + divide;
    }
}

