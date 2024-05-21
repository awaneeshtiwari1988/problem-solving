package com.practice.problem.solving.application.parentchild;

import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {
        List<String[]> relations = Arrays.asList(
                new String[]{"root", "child1"},
                new String[]{"root", "child2"},
                new String[]{"child1", "grandchild1"},
                new String[]{"child1", "grandchild2"},
                new String[]{"child2", "grandchild3"}
        );

        Tree tree = new Tree();

        for (String[] relation : relations) {
            tree.addRelation(relation[0], relation[1]);
        }

        tree.printTree();
    }
}
