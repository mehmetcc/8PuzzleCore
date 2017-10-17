package test;


import core.State;
import utils.ArrayUtils;
import utils.SearchNode;

import java.util.Arrays;
import java.util.List;

/**
 * A product of mecha
 */
public class Main {
    public static void main(String[] args) {
        int[][] i_initial = new int[][]{
                {1, 8, 2},
                {0, 4, 3},
                {7, 6, 5}
        };

        State state = new State(i_initial);
        SearchNode tree = new SearchNode(state);

        System.out.println(tree);
    }
}
