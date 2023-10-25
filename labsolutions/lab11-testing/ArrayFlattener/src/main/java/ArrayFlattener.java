import java.util.Arrays;

public class ArrayFlattener {

    public static int[] flattenArray(int[][] inputArray) {

        return (inputArray == null) ? null : Arrays.stream(inputArray)  // Stream<int[]>
                .flatMapToInt(Arrays::stream)                           // Flatten each inner array
                .toArray();
    }

}
