package edu.miu.cs.cs489.lesson11.sumofquaresutil;

import edu.miu.cs.cs489.lesson11.sumofquaresutil.service.ISquaresComputingService;

import java.util.Arrays;

public class SumOfSquaresComputer {

    private ISquaresComputingService squaresComputingService;

    public SumOfSquaresComputer(ISquaresComputingService squaresComputingService) {
        this.squaresComputingService = squaresComputingService;
    }

    public int computeSumOfSquares(int[] ints) {
        int[] squares = squaresComputingService.computeSquares(ints);
        return Arrays.stream(squares).sum();
    }
}
