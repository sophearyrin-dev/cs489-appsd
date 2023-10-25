import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayReversorTest {

    private ArrayReversor arrayReversor;

    @Before
    public void setUp() throws Exception {
        arrayReversor = new ArrayReversor();
    }

    @After
    public void tearDown() throws Exception {
        arrayReversor = null;
    }

    @Test
    public void testFlattenAndReverseArrayWithNonNullInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {9, 5, 4, 0, 3, 1};  // Expected result after reversing

        int[] actual = arrayReversor.flattenArray(inputArray);

        assertArrayEquals("Arrays should be equal", expected, actual);
    }
}