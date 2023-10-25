package edu.miu.cs.cs489.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArithmeticOpsUtilTest {

    private SimpleArithmeticOpsUtil simpleArithmeticOpsUtil;

    @Before
    public void setUp() throws Exception {
        this.simpleArithmeticOpsUtil = new SimpleArithmeticOpsUtil();
    }

    @After
    public void tearDown() throws Exception {
        this.simpleArithmeticOpsUtil = null;
    }

    @Test
    public void testAdd() {
        int a = 1;
        int b = 2;
        int actual = simpleArithmeticOpsUtil.add(a, b);
        int expected = 3;
        assertEquals("Error: Test fails. add(...) method is NOT working",
                expected, actual);
    }

    @Test
    public void testAdd_for_negative_inputs() {
        int a = -1;
        int b = -2;
        int actual = simpleArithmeticOpsUtil.add(a, b);
        int expected = -3;
        assertEquals("Error: Test fails. add(...) method is NOT working",
                expected, actual);
    }

}