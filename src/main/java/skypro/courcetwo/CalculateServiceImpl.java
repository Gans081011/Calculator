package skypro.courcetwo;
import org.springframework.stereotype.Service;

@Service
public  class CalculateServiceImpl implements CalculateService {
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }
    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int diff(int a, int b) {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }

    @Override
    public double divide(int a, int b) {
        return (double) a/b;
    }
}

