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

        Queue<SearchNode> q = new LinkedList<>();
        List<SearchNode> visited = new ArrayList<>();
        visited.add(start);
        q.add(start);

        while(!q.isEmpty()) {
            SearchNode node = q.remove();

        }


        // ToDO
        return null;
    }




}
