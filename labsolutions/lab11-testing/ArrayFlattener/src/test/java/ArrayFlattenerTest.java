import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener;

    @Before
    public void setUp() throws Exception {
        arrayFlattener = new ArrayFlattener();
    }

    @After
    public void tearDown() throws Exception {
        arrayFlattener = null;
    }

    @Test
    public void flattenArray() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] actual = ArrayFlattener.flattenArray(inputArray);
        assertArrayEquals(expected, actual);
    }
}