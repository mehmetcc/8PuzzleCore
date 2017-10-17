package core;

import java.util.Random;

/**
 * A product of mecha
 */
public class InitialStateGenerator {
    // variables
    private int board_size;
    private Random random;

    // constructors
    public InitialStateGenerator(int size) {
        board_size = size;
        random = new Random();
    }

    // methods
    public int[][] generate() {
        int[][] tmp = new int[board_size][board_size];

        for (int row = 0; row < board_size; row++) {
            for (int column = 0; column < board_size; column++) {

            }
        }


        return tmp;
    }
}
