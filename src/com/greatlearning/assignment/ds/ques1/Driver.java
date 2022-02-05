package com.greatlearning.assignment.ds.ques1;

import java.util.Scanner;

/**
 * @author rajatjain on - 05-02-2022
 * @project DataStructureAssignmentSolution
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("Enter the total no of floors in the building");
        Scanner scanner = new Scanner(System.in);
        int totalFloors = scanner.nextInt();
        SkyscraperConstruction skyscraperConstruction = new SkyscraperConstruction(totalFloors);
        skyscraperConstruction.inputFloorDeliveryByDay(scanner);
        skyscraperConstruction.processAndShowOrderOfConstruction();
    }

}
