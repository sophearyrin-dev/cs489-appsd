import java.util.Arrays;

public class ArrayReversor implements ArrayFlattenerService{

    @Override
    public int[] flattenArray(int[][] inputArray) {
        if (inputArray == null) {
            return null;
        }

        int[] flattenedArray = Arrays.stream(inputArray)           // Stream<int[]>
                .flatMapToInt(Arrays::stream)                      // Flatten each inner array
                .toArray();

        // Reverse the flattened array
        int[] reversedArray = new int[flattenedArray.length];
        for (int i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }

        return reversedArray;
    }

}
