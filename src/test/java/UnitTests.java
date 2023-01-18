import application.Calculator;
import models.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {

    @Test
    void expressionEvaluate(){
        Expression exp = new Expression("3*-2");
        Calculator.calculate(exp);
        String result = exp.getResult();
        assertEquals("-6.0", result);
    }
}
