package java.patternvisitor;

import java.util.ArrayList;
import java.util.*;

import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int id;
    private int value;
    private Color color;
    private int depth;

    public Tree(int id, int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
        this.id = id;
    }

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public int getId() {
        return id;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int id, int value, Color color, int depth) {
        super(id, value, color, depth);
    }

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < getDepth(); i++) sb.append("\t");
        sb.append("<<" + getColor() + "-" + getId() + "-" + getDepth() + ">> ");

        for (Tree child : children) {
            if (child instanceof TreeLeaf) {
                sb.append(child.toString());
            }
        }

        for (Tree child : children) {
            if (child instanceof TreeNode) {
                sb.append(child.toString());
            }
        }

        return sb.toString();
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int id, int value, Color color, int depth) {
        super(id, value, color, depth);
    }

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }

    public String toString() {

        return "[" + getColor() + "-" + getId() + "-" + getDepth() + "] ";
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor().equals(Color.RED)) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED)) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {

    int sumNonLeaf = 0;
    int sumLeaf = 0;

    public int getResult() {
        return Math.abs(sumLeaf - sumNonLeaf);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumNonLeaf += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) {
            sumLeaf += leaf.getValue();
        }
    }
}

public class Solution {


    private static Map<Integer, Integer> nodeCounter = new HashMap<>();
    private static final Integer ROOT_NODE_ID = 1;


    private static class Edge {
        int leftNodeId;
        int rightNodeId;

        public Edge(int leftNodeId, int rightNodeId) {
            this.leftNodeId = leftNodeId;
            this.rightNodeId = rightNodeId;
        }

        boolean hasNode(int nodeId) {
            return nodeId == leftNodeId || nodeId == rightNodeId;
        }

        int oppositeNode(int nodeId) {
            if (nodeId == leftNodeId) return rightNodeId;
            else return leftNodeId;
        }

        @Override
        public int hashCode() {

            return leftNodeId * 1000000 + rightNodeId;
        }

        @Override
        public boolean equals(Object obj) {

            Edge other = (Edge) obj;

            return other.leftNodeId == this.leftNodeId && other.rightNodeId == this.rightNodeId;
        }
    }

    public static Tree solve() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] values = initArray(in, n);
        int[] colors = initArray(in, n);
        List<Edge> edges = readEdges(in);

        return buildTreeRecursive(n, colors, values, edges);
    }

    private static Tree addNode(Integer depth, Integer parentNodeId, Integer nodeId, int[] colors, int[] values, Map<Integer, Set<Edge>> edgeMap) {

        List<Edge> childEdges = findChildEdges(nodeId, parentNodeId, edgeMap.get(nodeId));

        if (childEdges.size() == 0) {
            return creatLeafNode(values[nodeId], Color.values()[colors[nodeId]], depth);
        }

        TreeNode parentNode = createTreeNode(values[nodeId], Color.values()[colors[nodeId]], depth);

        for (Edge edge : childEdges) {
            parentNode.addChild(addNode(depth + 1, nodeId, edge.oppositeNode(nodeId), colors, values, edgeMap));
        }

        return parentNode;
    }

    private static Tree buildTreeRecursive(int n, int[] colors, int[] values, List<Edge> edges) {
        Map<Integer, Set<Edge>> edgeMap = groupEdges(edges);

        return addNode(0, 0, ROOT_NODE_ID, colors, values, edgeMap);
    }

    private static List<Edge> findChildEdges(Integer nodeId, Integer parentNodeId, Set<Edge> edges) {

        List<Edge> myEdges = new LinkedList<Edge>();

        for (Edge edge : edges) {
            if (edge.hasNode(nodeId) && !edge.hasNode(parentNodeId)) {
                myEdges.add(edge);
            }
        }

        return myEdges;
    }

    private static Map<Integer, Set<Edge>> groupEdges(List<Edge> edges) {

        Map<Integer, Set<Edge>> edgeMap = new HashMap<Integer, Set<Edge>>();

        for (Edge edge : edges) {

            Set<Edge> leftEdges = edgeMap.get(edge.leftNodeId);
            Set<Edge> rightEdges = edgeMap.get(edge.rightNodeId);

            if ( leftEdges== null) {
                leftEdges = new HashSet<Edge>();
                edgeMap.put(edge.leftNodeId, leftEdges);
            }
            if ( rightEdges== null) {
                rightEdges = new HashSet<Edge>();
                edgeMap.put(edge.rightNodeId, rightEdges);
            }

            leftEdges.add(edge);
            rightEdges.add(edge);

        }

        return edgeMap;
    }

/*
    private static Tree creatLeafNode(Integer id, Integer value, Color color, Integer depth) {
        return new TreeLeaf(id, value, color, depth);
    }

    private static TreeNode createTreeNode(Integer id, Integer value, Color color, Integer depth) {
        return new TreeNode(id, value, color, depth);
    }*/

    private static Tree creatLeafNode(Integer value, Color color, Integer depth) {
        return new TreeLeaf(value, color, depth);
    }

    private static TreeNode createTreeNode(Integer value, Color color, Integer depth) {
        return new TreeNode(value, color, depth);
    }

    private static boolean isParent(Integer nodeId) {
        Integer cnt = nodeCounter.get(nodeId);

        return cnt > 1;
    }

    private static int[] initArray(Scanner in, int n) {
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) values[i] = in.nextInt();
        return values;
    }


    private static List<Edge> readEdges(Scanner in) {
        List<Edge> edges = new LinkedList<>();

        while (in.hasNextInt()) {
            Integer nodeIdLeft = in.nextInt();
            Integer nodeIdRight = in.nextInt();

            edges.add(new Edge(nodeIdLeft, nodeIdRight));
            increaseNodeCount(nodeIdLeft);
            increaseNodeCount(nodeIdRight);
        }

        return edges;
    }

    private static void increaseNodeCount(Integer id) {
        Integer count = nodeCounter.get(id);
        if (count == null) {
            count = 0;
        }

        nodeCounter.put(id, ++count);
    }


    public static void main(String[] args) {
        Tree root = solve();

        //System.out.println(root);

        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}