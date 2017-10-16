package utils;

/**
 * A product of mecha
 */
public class ArrayUtils {

    public static void swap(int[][] arr, int first_row, int first_column, int second_row, int second_column) {
        int tmp = arr[first_row][first_column];
        arr[first_row][first_column] = arr[second_row][second_column];
        arr[second_row][second_column] = tmp;
    }

    public static void copy(int[][] source, int[][] target, int dimension) {
        for (int i = 0; i < dimension; i++) {
            System.arraycopy(source[i], 0, target[i], 0, dimension);
        }
    }
}
