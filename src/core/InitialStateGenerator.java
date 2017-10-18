package core;

import java.util.*;

/**
 * A product of mecha
 */
public class InitialStateGenerator {
    // variables
    private int board_size;

    // constructors
    public InitialStateGenerator(int size) {
        board_size = size;
    }

    // methods
    public int[][] generate() {
        int[][] tmp = new int[board_size][board_size];
        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < board_size * board_size; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int row = 0; row < board_size; row++) {
            for (int column = 0; column < board_size; column++) {
                tmp[row][column] = numbers.pop();
            }
        }

        return tmp;
    }
}
