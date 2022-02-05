package com.greatlearning.assignment.ds.ques1;

import com.greatlearning.assignment.ds.utils.Queue;
import com.greatlearning.assignment.ds.utils.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rajatjain on - 30-01-2022
 * @project DataStructureAssignmentSolution
 */
public class SkyscraperConstruction {

    private final int totalFloors;
    private final Queue<Integer> floorQueue;
    private final List<Integer> floorDelivery;
    private final Stack<Integer> unusedFloorStack;

    public SkyscraperConstruction(int totalFloors) {
        this.totalFloors = totalFloors;
        floorQueue = new Queue<>(totalFloors);
        floorDelivery = new ArrayList<>();
        unusedFloorStack = new Stack<>(totalFloors);
        insertValuesInQueue();
    }

    private void insertValuesInQueue() {
        for (int i = totalFloors; i >= 1; i--) {
            floorQueue.enqueue(i);
        }
        System.out.println("Floors remaining - ");
        floorQueue.printQueue();
    }

    public void inputFloorDeliveryByDay(Scanner scanner) {
        for (int i = 0; i < totalFloors; i++) {
            System.out.println("Enter the floor size given on day - " + (i + 1));
            floorDelivery.add(scanner.nextInt());
        }
    }

    public void processAndShowOrderOfConstruction() {
        System.out.println("The order of construction is as follows - ");

        for (int i = 0; i < totalFloors; i++) {
            System.out.println("Day: " + (i + 1));
            int floorToBeConstructed = floorQueue.peek();
            checkIfFloorDeliveredAndConstructFloor(floorToBeConstructed, i);
        }
    }

    private void checkIfFloorDeliveredAndConstructFloor(int floorToBeConstructed, int i) {
        if(floorDelivery.get(i) == floorToBeConstructed){
            System.out.print(floorDelivery.get(i) + " ");
            floorQueue.dequeue();
            checkUnusedFloorsForConstruction();
            System.out.println("");
        }else{
            unusedFloorStack.push(floorDelivery.get(i));
        }
    }

    private void checkUnusedFloorsForConstruction() {
        while(!unusedFloorStack.isEmpty()){
            int floorToBeConstructed = floorQueue.peek();
            int unusedFloor = unusedFloorStack.pop();
            if(unusedFloor >= floorToBeConstructed){
                System.out.print(unusedFloor + " ");
                floorQueue.dequeue();
            }else{
                unusedFloorStack.push(unusedFloor);
                break;
            }
        }
    }
}
