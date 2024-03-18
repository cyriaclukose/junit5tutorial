package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

    @DisplayName("test Addition")
    @Test
    public void testAdd(){
        var calculator=new SimpleCalculator();
        int actual=calculator.add(2,2);
        Assertions.assertEquals(4,actual);

    }

    @DisplayName("Test Substraction")
    @Test
    public  void testSubstract(){

        var calculator=new SimpleCalculator();

        int actual=calculator.substract(9,6);
        Assertions.assertEquals(3,actual);

    }


    @Test
    @DisplayName("Test Multiplication")
    public void testMultiplication(){

        var calculator=new SimpleCalculator();
        int result=calculator.multiply(3,4);
        Assertions.assertEquals(12,result);
    }

}