package com.daumkakao.localcontents.test.websupport.learningtest.template;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by innoc on 15. 9. 5..
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
public class CalcSumTest {
    private String filepath;
    private Calculator calculator;

    @Before
    public void setup(){
        this.calculator = new Calculator();
        this.filepath = "/Develope/privateWork/springBootExample/src/main/java/numbers.txt";
    }

    @Test
    public void sumOfNumbers() throws IOException {
        int sum = calculator.calcSum(filepath);
        assertThat(sum, is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        int sum = calculator.calcMultiply(filepath);
        assertThat(sum, is(24));
    }

    @Test
    public void concatenateStrings() throws IOException {
        String result = calculator.concatenate(filepath);
        assertThat(result, is("1234"));
    }

}
