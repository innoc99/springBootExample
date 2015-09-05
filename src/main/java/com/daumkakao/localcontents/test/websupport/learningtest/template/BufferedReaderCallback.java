package com.daumkakao.localcontents.test.websupport.learningtest.template;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by innoc on 15. 9. 5..
 */
public interface BufferedReaderCallback {
    Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
