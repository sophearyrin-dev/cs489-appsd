import java.util.Arrays;

public class ArrayFlattener {

    public static int[] flattenArray(int[][] inputArray) {

        return (inputArray == null) ? null : Arrays.stream(inputArray)  // Stream<int[]>
                .flatMapToInt(Arrays::stream)                           // Flatten each inner array
                .toArray();
    }

    public static void main(String[] args) {

        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattenedArray = flattenArray(inputArray);
        System.out.print("Flattened Array: ");
        System.out.println(Arrays.toString(flattenedArray));

    }


}
