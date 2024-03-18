package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {


    @Test
    @DisplayName("test GRADE E")
    public void testGrade(){
        var gradeCalculator=new GradeCalculator();
        var result= gradeCalculator.getGrade(59);

        Assertions.assertEquals("E",result);


    }

    @Test
    @DisplayName("test GRADE D")
    public void testGradeD(){
        var gradeCalculator=new GradeCalculator();
        var result= gradeCalculator.getGrade(69);

        Assertions.assertEquals("D",result);


    }

    @Test
    @DisplayName("test GRADE C")
    public void testGradeC(){
        var gradeCalculator=new GradeCalculator();
        var result= gradeCalculator.getGrade(79);

        Assertions.assertEquals("C",result);


    }

    @Test
    @DisplayName("test GRADE B")
    public void testGradeB(){
        var gradeCalculator=new GradeCalculator();
        var result= gradeCalculator.getGrade(89);

        Assertions.assertEquals("B",result);


    }

    @Test
    @DisplayName("test GRADE A")
    public void testGradeA(){
        var gradeCalculator=new GradeCalculator();
        var result= gradeCalculator.getGrade(92);

        Assertions.assertEquals("A",result);


    }

    @Test
    @DisplayName("Test Nagative Score")
    public void testNegativeScore(){

        var gradeCalc= new GradeCalculator();

        Assertions.assertThrows(IllegalArgumentException.class,()->{

            gradeCalc.getGrade(-1);
        });

    }

}
