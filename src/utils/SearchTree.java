package utils;

/**
 * A product of mecha
 */
public class SearchTree {

    // variables
    private final static int BOARD_SIZE = 3;
    private SearchNode root;

    // constructors
    public SearchTree(SearchNode root) {
        this.root = root;
    }

    public SearchTree(int[][] e_element) {
        initializeFromArray(e_element);
    }

    // methods
    private void generateTree() {
        // ToDo
    }

    // auxiliaries
    private void initializeFromArray(int[][] e_element) {
        int[][] element = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                element[i][j] = e_element[i][j];
            }
        }

        root = new SearchNode(element);
    }
}
