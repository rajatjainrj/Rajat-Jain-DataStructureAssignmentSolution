package com.greatlearning.assignment.ds.ques2;

/**
 * @author rajatjain on - 05-02-2022
 * @project DataStructureAssignmentSolution
 */
public class Driver {

    public static void main(String[] args) {
        BSTreeToSkewedTree bsTreeToSkewedTree = new BSTreeToSkewedTree();
        BSTreeToSkewedTree.Node rightSkewed = bsTreeToSkewedTree.convertBstToRightSkewed();
        bsTreeToSkewedTree.printRightSkewedTree(rightSkewed);
    }

}
