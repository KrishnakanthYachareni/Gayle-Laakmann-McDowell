package algoexpert.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        // TC = O(O + E), SC = O(O)
        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            array.add(this.name);
            for (Node child : this.children)
                child.depthFirstSearch(array);

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
