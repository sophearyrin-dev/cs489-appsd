package edu.miu.cs.cs489.lesson11.sumofquaresutil;

import edu.miu.cs.cs489.lesson11.sumofquaresutil.service.ISquaresComputingService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SumOfSquaresComputerTest {

    private SumOfSquaresComputer sumOfSquaresComputer;

//    @Mock
//    private ISquaresComputingService squaresComputingService;
    private ISquaresComputingService squaresComputingService = mock(ISquaresComputingService.class);

    @BeforeEach
    void setUp() {
        this.sumOfSquaresComputer = new SumOfSquaresComputer(squaresComputingService);
    }

    @AfterEach
    void tearDown() {
        this.sumOfSquaresComputer = null;
    }

    @Test
    void test_computeSumOfSquares() {
        when(squaresComputingService.computeSquares(new int[]{1,2,3})).thenReturn(new int[]{1,4,9});
        int actual = sumOfSquaresComputer.computeSumOfSquares(new int[]{1,2,3});
        MatcherAssert.assertThat(actual, CoreMatchers.is(13));
    }
}