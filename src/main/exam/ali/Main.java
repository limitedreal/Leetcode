package main.exam.ali;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal(5.67);
        x = x.setScale(1, RoundingMode.DOWN);
        System.out.println(x);
    }
}
