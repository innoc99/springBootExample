package com.daumkakao.localcontents.test.websupport.learningtest.junit;

import com.daumkakao.localcontents.test.websupport.dao.DaoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by illy on 2016. 1. 5..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoFactory.class)
public class JUnitTest {

    @Autowired
    ApplicationContext context;

    static Set<JUnitTest> testObject = new HashSet<>();
    static ApplicationContext contextObject = null;

    @Test public void test1(){
        assertThat(testObject, not(hasItem(this)));
        testObject.add(this);
        assertThat(contextObject == null || contextObject == this.context, is(true));
        contextObject = this.context;
    }

    @Test public void test2(){
        assertThat(testObject, not(hasItem(this)));
        testObject.add(this);
        assertTrue(contextObject == null || contextObject == this.context);
        contextObject = this.context;
    }

    @Test public void test3(){
        assertThat(testObject, not(hasItem(this)));
        testObject.add(this);
        assertThat(contextObject, either(is(nullValue())).or(is(this.context)));
        contextObject = this.context;
    }

}
