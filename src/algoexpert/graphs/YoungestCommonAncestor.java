package algoexpert.graphs;

public class YoungestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDepthOfDescendent(descendantOne, topAncestor);
        int depthTwo = getDepthOfDescendent(descendantTwo, topAncestor);

        if (depthOne > depthTwo)
            return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        else
            return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
    }

    private static int getDepthOfDescendent(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }

    private static AncestralTree backtrackAncestralTree(AncestralTree lowerDescendent, AncestralTree higherDescendent, int diff) {
        // Bring the lowest ancestor to equal level.
        while (diff > 0) {
            lowerDescendent = lowerDescendent.ancestor;
            diff--;
        }

        while (lowerDescendent != higherDescendent) {
            lowerDescendent = lowerDescendent.ancestor;
            higherDescendent = higherDescendent.ancestor;
        }
        return lowerDescendent;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
