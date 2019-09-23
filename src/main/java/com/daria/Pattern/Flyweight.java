package main.java.com.daria.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flyweight {
    public static void main(String[] args) {
        TreeFactory treeFactory = new TreeFactory();
        List<Tree> trees = new ArrayList<>();

        trees.add(treeFactory.getTree("pine"));
        trees.add(treeFactory.getTree("pine"));
        trees.add(treeFactory.getTree("pine"));
        trees.add(treeFactory.getTree("birch"));
        trees.add(treeFactory.getTree("birch"));
        trees.add(treeFactory.getTree("pine"));

        int count = 3;
        for (Tree tree : trees) {
            count++;
            tree.leaf(count);
        }
    }
}

interface Tree {
    void leaf(int size);
}

class Pine implements Tree {
    @Override
    public void leaf(int size) {
        System.out.println("Leaf of pine is " + size);
    }
}

class Birch implements Tree {
    private int width = 6;

    @Override
    public void leaf(int size) {
        System.out.println("Leaf of birch is " + size * width);
    }
}

class TreeFactory {
    private static final Map<String, Tree> trees = new HashMap<>();

    public Tree getTree(String treeName) {
        Tree tree = trees.get(treeName);
        if (tree == null) {
            switch (treeName) {
                case "pine":
                    tree = new Pine();
                    break;
                case "birch":
                    tree = new Birch();
                    break;
            }
            trees.put(treeName, tree);
        }
        return tree;
    }
}