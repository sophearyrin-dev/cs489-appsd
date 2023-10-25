package edu.miu.cs.cs489.util;

import java.util.stream.IntStream;

public class SimpleArrayOpsUtil {

    public int sumNumbers(int[] nums) {
        return IntStream.of(nums)
                .sum();
    }

}
