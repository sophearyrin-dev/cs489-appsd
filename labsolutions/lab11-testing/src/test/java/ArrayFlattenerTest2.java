import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayFlattenerTest2 {

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
        int[][] inputArray = null;

        int[] result = ArrayFlattener.flattenArray(inputArray);

        Assert.assertNull("Result should be null for null input", result);
    }
}