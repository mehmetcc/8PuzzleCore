package test;


import core.InitialStateGenerator;
import core.State;

/**
 * A product of mecha
 */
public class Main {
    public static void main(String[] args) {
        InitialStateGenerator generator = new InitialStateGenerator(3);
        int[][] goal = new int[][] {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}
        };

        State state = new State(goal);

        System.out.println(state.getCost());
    }
}
