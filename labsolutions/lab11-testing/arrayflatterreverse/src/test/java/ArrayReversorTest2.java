import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayReversorTest2 {

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
    public void testFlattenAndReverseArrayWithNullInput() {
        int[][] expected = null;

        int[] actual = arrayReversor.flattenArray(expected);

        assertNull("Result should be null for null input", actual);
    }
}