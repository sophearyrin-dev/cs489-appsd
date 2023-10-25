package edu.miu.cs.cs489.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArrayOpsUtilTest {

    private SimpleArrayOpsUtil simpleArrayOpsUtil;

    @Before
    public void setUp() throws Exception {
        this.simpleArrayOpsUtil = new SimpleArrayOpsUtil();
    }

    @After
    public void tearDown() throws Exception {
        this.simpleArrayOpsUtil = null;
    }

    @Test
    public void sumNumbers() {
        int[] nums = new int[]{1,2,3};
        int expected = 6;
        int actual = simpleArrayOpsUtil.sumNumbers(nums);
        Assert.assertEquals("Error: Test fails. SumNumber is not working",
                expected, actual);
    }

    @Test
    public void test_sum_Numbers_for_null_array() {
        int[] nums = null;
        int expected = null;
        int actual = simpleArrayOpsUtil.sumNumbers(nums);
        Assert.assertEquals("Error: Test fails. SumNumber is not working",
                expected, actual);
    }
}