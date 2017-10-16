package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import utils.ArrayUtils;

/**
 * A product of mecha
 */
public class State {
    // variables
    private final static int BOARD_SIZE = 3;
    private int board[][];
    private int cost;
    private int[][] goal;
    private boolean isGoal;

    // constructors
    public State(int[][] b_board) {
        // initialize board
        board = new int[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                board[row][column] = b_board[row][column];
            }
        }

        // initialize goal state
        goal = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        // check if in the goal state
        isGoal = Arrays.deepEquals(board, goal);

        // calculate manhattan distance
        if (!isGoal) cost = calculateCost();
        else cost = 0;
    }

    // methods
    public int[][] getBoard() { return board; }
    public int getCost() { return cost; }

    private int calculateCost() {
        int tmp = 0;
        System.out.println("x " + "y " + "sum");

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                int val = board[row][column];
                HashMap<String, Integer> goalCoordinates = findCoordinatesAtGoal(val);
                int row_cost = Math.abs(goalCoordinates.get("row") - row);
                System.out.print(row_cost + " ");
                int column_cost = Math.abs(goalCoordinates.get("column") - column);
                System.out.print(column_cost + " ");
                tmp = tmp + row_cost + column_cost;
                System.out.println(tmp);
            }
        }

        System.out.println("Heuristic: " + tmp);
        System.out.println("-----------------");
        return tmp;
    }

    public ArrayList<State> findPossibleActions() {
        HashMap<String, Integer> zero_loc = findEmptySpace();
        ArrayList<State> possibleStates = new ArrayList<>();

        int row    = zero_loc.get("row");
        int column = zero_loc.get("column");

        if (row == 0 && column == 0) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 0, 0, 0, 1);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 0, 0, 1, 0);
            possibleStates.add(new State(b));
        }
        else if (row == 1 && column == 0) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 1, 0, 0, 0);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 1, 0, 2, 0);
            possibleStates.add(new State(b));
            // third swap
            int[][] c = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, c, BOARD_SIZE);
            ArrayUtils.swap(c, 1, 0, 1, 1);
            possibleStates.add(new State(c));
        }
        else if (row == 2 && column == 0) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 2, 0, 1, 0);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 2, 0, 2, 1);
            possibleStates.add(new State(b));
        }
        else if (row == 0 && column == 1) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 0, 1, 0, 0);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 0, 1, 1, 1);
            possibleStates.add(new State(b));
            // third swap
            int[][] c = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, c, BOARD_SIZE);
            ArrayUtils.swap(c, 0, 1, 0, 2);
            possibleStates.add(new State(c));
        }
        else if (row == 1 && column == 1) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 1, 1, 0, 1);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 1, 1, 1, 0);
            possibleStates.add(new State(b));
            // third swap
            int[][] c = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, c, BOARD_SIZE);
            ArrayUtils.swap(c, 1, 1, 2, 1);
            possibleStates.add(new State(c));
            // fourth swap
            int[][] d = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, d, BOARD_SIZE);
            ArrayUtils.swap(d, 1, 1, 1, 2);
            possibleStates.add(new State(d));
        }
        else if (row == 2 && column == 1) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 2, 1, 1, 1);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 2, 1, 2, 0);
            possibleStates.add(new State(b));
            // third swap
            int[][] c = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, c, BOARD_SIZE);
            ArrayUtils.swap(c, 2, 1, 2, 2);
            possibleStates.add(new State(c));
        }
        else if (row == 0 && column == 2) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 0, 2, 0, 1);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 0, 2, 1, 2);
            possibleStates.add(new State(b));
        }
        else if (row == 1 && column == 2) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 1, 2, 0, 2);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 1, 2, 1, 1);
            possibleStates.add(new State(b));
            // third swap
            int[][] c = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, c, BOARD_SIZE);
            ArrayUtils.swap(c, 1, 2, 2, 2);
            possibleStates.add(new State(c));
        }
        else if (row == 2 && column == 2) {
            // first swap
            int[][] a = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, a, BOARD_SIZE);
            ArrayUtils.swap(a, 2, 2, 2, 1);
            possibleStates.add(new State(a));
            // second swap
            int[][] b = new int[BOARD_SIZE][BOARD_SIZE];
            ArrayUtils.copy(board, b, BOARD_SIZE);
            ArrayUtils.swap(b, 2, 2, 1, 2);
            possibleStates.add(new State(b));
        }

        return possibleStates;
    }

    public String toString() {
        return Arrays.deepToString(board);
    }


    // auxiliaries


    private HashMap<String, Integer> findEmptySpace() {
        HashMap<String, Integer> point = new HashMap<>();

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == 0) {
                    point.put("row", row);
                    point.put("column", column);
                    return point;
                }
            }
        }

        return point;
    }

    private HashMap<String, Integer> findCoordinatesAtGoal(int val) {
        HashMap<String, Integer> point = new HashMap<>();

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column <BOARD_SIZE; column++) {
                if (goal[row][column] == val) {
                    point.put("row", row);
                    point.put("column", column);
                    return point;
                }
            }
        }

        return point;
    }

} //class ends
