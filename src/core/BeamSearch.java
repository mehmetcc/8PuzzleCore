package core;

import utils.SearchNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A product of mecha
 */
public class BeamSearch {
    // variables
    SearchNode start;
    int width;

    // constructor
    public BeamSearch(SearchNode start, int w) {
        this.start = start;
        this.width = w;
    }

    // methods
    public SearchNode find(SearchNode start) {
        if (start.isGoal()) return start;

        Queue<SearchNode> frontier = new LinkedList();
        frontier.add(start);
        List<Boolean> visited = new ArrayList<>();
        boolean found = false;

        while (!found) {
            if (frontier.isEmpty()) {
                System.out.println("No solution for you!");
                return null;
            }

            SearchNode node = frontier.remove();



        }
    }




}
