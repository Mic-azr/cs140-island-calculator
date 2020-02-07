
/**
 * Takes 4 variables from user inputs and calculates overall length and width, as well as the area and width of the circular sidewalks.
 * The program also calculates the required garden materials for the island's plant beds, which are plants per bed, total number of plants,
 * and cubic yards of soil required.
 * Author: Michael Cummings
 * Version 1, 2.4.2020
 */
import java.util.Scanner;
public class islandCalculator {
    public static void main(){
    float x, y, spacing, soilDepth; //user-defined variables
    
    float lgCircleArea, smCircleArea, middleArea, sidewalkArea, sidewalkWidth, soilForCircle, soilForMiddle, soilArea, plantArea, overallWidth, overallLength; 
    int plantsForCircle, plantsForMiddle, totalPlants; //results of calculations using user variables
    
    final float CUBIC_FEET_PER_SQUARE_YARD = 27;
    
    Scanner scnr = new Scanner(System.in);
    
    System.out.println("Enter requirements");
    System.out.println("==================");
    
    System.out.print("Enter measurement x (feet): ");
    x = scnr.nextFloat();
    
    System.out.print("Enter measurement y (feet): ");
    y = scnr.nextFloat();
    
    System.out.print("Enter plant spacing (feet): ");
    spacing = scnr.nextFloat();
    
    System.out.print("Enter depth of garden soil (feet): ");
    soilDepth = scnr.nextFloat();
    System.out.println("");
    
    overallWidth = x;
    overallLength = 2 * x;
    lgCircleArea = (float)(Math.PI * Math.pow((0.5 * x), 2));
    smCircleArea = (float)(Math.PI * Math.pow((0.5 * y), 2)); //area of each flowerbed
    sidewalkArea = 2 * (lgCircleArea - smCircleArea); //subtracting the area of smaller circle (flowerbed) from larger. Multiplied by two for two circular flowerbeds
    sidewalkWidth = (float)((0.5 * x) - (0.5 * y)); //sidewalk width is equal to difference in radii of circles. (0.5 * 30) - (0.5 * 20) = 5, sidewalk width of 5 feet
    middleArea = (float)(Math.pow(x, 2) - (sidewalkArea / 2) - (smCircleArea)); //x is length of one side of the square, x^2 is area of the square. Two semicircles of sidewalk and flowerbed are in middle area = one circle = half sidewalk area. Area of a flowerbed is subtracted because that area is already counted
    
    System.out.println("Specifications");
    System.out.println("==================");
    System.out.println("Traffic island overall length: " + overallLength + " feet");
    System.out.println("Traffic island overall width: " + overallWidth + " feet");
    System.out.println("Sidewalk area: " + sidewalkArea + " square feet");
    System.out.println("Sidewalk width: " + sidewalkWidth + " feet");
    System.out.println("");
    
    System.out.println("Garden materials needed");
    System.out.println("==================");
    
    plantsForCircle = (int)(smCircleArea / Math.pow(spacing, 2)); //number of plants for each circular flowerbed
    plantsForMiddle = (int)(middleArea / Math.pow(spacing, 2)); //number of plants for middle flowerbed
    totalPlants = 2 * plantsForCircle + plantsForMiddle;
    plantArea = 2 * smCircleArea + middleArea; //total square feet of flower beds
    soilForMiddle = (soilDepth * middleArea) / CUBIC_FEET_PER_SQUARE_YARD;
    soilForCircle = (soilDepth * smCircleArea) / CUBIC_FEET_PER_SQUARE_YARD; //amount of soil in each circular flowerbed in cubic feet
    soilArea = 2 * soilForCircle + soilForMiddle;
    
    System.out.println("Plants for each circle garden: " + plantsForCircle);
    System.out.println("Plants for the middle garden: " + plantsForMiddle);
    System.out.println("Total plants for garden: " + totalPlants);
    System.out.println("Soil for each circle garden: " + soilForCircle + " cubic yards");
    System.out.println("Soil for the middle garden: " + soilForMiddle + " cubic yards");
    System.out.println("Total soil for the garden: " + soilArea + " cubic yards");
    
}
}
