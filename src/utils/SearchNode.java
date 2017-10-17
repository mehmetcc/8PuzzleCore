package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import core.State;

/**
 * A product of mecha
 */
public class SearchNode implements Comparable {

    // variables
    private final static int BOARD_SIZE = 3;
    private ArrayList<SearchNode> children;

    // elements
    private State state;
    private int cost;

    // constructors
    public SearchNode(int[][] e_element) {
        state = new State(e_element);
        cost  = state.getCost();
    }

    public SearchNode(State state) {
        this.state = state;
        cost = state.getCost();

    }

    // methods
    public boolean isGoal() {
        return state.getCost() == 0;
    }
    public ArrayList<SearchNode> getChildren() {
        return children;
    }

    public int[][] getBoard() {
        return state.getBoard();
    }

    public int getCost() {
        return cost;
    }

    public State getState() {
        return state;
    }

    public void addPossibleChildren() {
        ArrayList<State> states = state.findPossibleActions();
        for (State a : states) {
            children.add(new SearchNode(a));
        }

        Collections.sort(children);
    }

    // standard tree algorithms
    // i don't think that i would ever use them but still...
    public void addNewChildren(SearchNode node) {
        children.add(node);
        Collections.sort(children);
    }

    public void addNewChildren(int[][] board) {
        children.add(new SearchNode(board));
        Collections.sort(children);
    }

    public void addNewChildren(ArrayList<State> states) {
        for (State a : states) {
            children.add(new SearchNode(a));
        }

        Collections.sort(children);
    }

    // comparable interface
    @Override
    public int compareTo(Object o) {
        SearchNode tmp = (SearchNode)o;
        int val = tmp.getCost();
        return this.cost - val;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.getBoard());
    }
}
