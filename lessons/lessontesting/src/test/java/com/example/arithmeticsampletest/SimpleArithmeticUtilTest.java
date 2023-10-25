package com.example.arithmeticsampletest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class SimpleArithmeticUtilTest {

    private SimpleArithmeticUtil simpleArithmeticUtil;


    @BeforeEach
    void setUp(){
        this.simpleArithmeticUtil = new SimpleArithmeticUtil();
    }


//you finish the executeing the test, then reinitailize to null, or close file,..
    @AfterEach
    void tearDown() {
        this.simpleArithmeticUtil = null;
    }

    @Test
    void testAdd() {
        int a = 1;
        int b = 2;
        int actual = simpleArithmeticUtil.add(a,b);
        int expected = 3;

        //make a verification
        Assertions.assertEquals(expected,actual);
    }
}