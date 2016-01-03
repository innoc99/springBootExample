package com.daumkakao.localcontents.test.websupport.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by innoc on 15. 9. 5..
 */
public class Calculator {
    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        Integer sum;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            sum = callback.doSomethingWithReader(br);
            return sum;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if(br != null){
                try {
                    br.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }

    public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));

            T number = initVal;
            String line;
            while((line = br.readLine()) != null){
                number = callback.doSomethisWithLine(line, number);
            }
            return number;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if(br != null){
                try {
                    br.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }

    public int calcSum(String filepath) throws IOException {
        LineCallback<Integer> callback = (line, value) -> value + Integer.valueOf(line);
        return lineReadTemplate(filepath, callback , 0);
    }

    public int calcMultiply(String filepath) throws IOException {
        LineCallback<Integer> callback = (line, value) -> value * Integer.valueOf(line);
        return lineReadTemplate(filepath, callback, 1);
    }

    public String concatenate(String filepath) throws IOException {
        LineCallback<String> callback = (line, value) -> value + line;
        return lineReadTemplate(filepath, callback, "");
    }
}
