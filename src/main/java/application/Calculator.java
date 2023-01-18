package application;

import models.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator {
    public static void calculate(Expression expression){
        net.objecthunter.exp4j.Expression exp = new ExpressionBuilder(expression.getData()).build();
        expression.setResult(String.valueOf(exp.evaluate()));
    }
}
