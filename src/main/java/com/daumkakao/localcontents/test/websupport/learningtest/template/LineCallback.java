package com.daumkakao.localcontents.test.websupport.learningtest.template;

/**
 * Created by innoc on 15. 9. 5..
 */
public interface  LineCallback<T> {
    T doSomethisWithLine(String line, T value);
}
