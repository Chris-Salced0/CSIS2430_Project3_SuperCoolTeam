/*
 * Team Name:    SuperCoolTeam
 * Team Members: Tayler Covington-Holler (Implementation Lead)
 *               Cameron Dickinson (Implementation Lead)
 *               Christopher Salcedo Cardenas (Verification Lead)
 *               Maxwell Jardine (Communications Lead)
 * Course:       CS 2430-501
 * Project:      Project 3 – The Knapsack Problem
 * Primary Author: Tayler Covington-Holler
 */

package project3;


import java.util.ArrayList;
import java.util.List;


/**
 * This project implements, compares, and critically evaluates multiple algorithmic 
 * strategies to solve the classic knapsack optimization problem. We often run into 
 * problems where we have a finite amount of one or more resources and must find the 
 * best possible solution given our constraints.
 * 
 * This program runs four solving strategies in sequence and compares their results:
 *
 * Part 1 – Three Greedy Strategies (Greedy.java):
 *  1. Highest Rating First
 *  2. Lightest First
 *  3. Best Rating-to-Weight Ratio First
 *
 * Part 2 – Brute Force Exhaustive Search (BruteForce.java):
 *  Checks all 2^12 = 4,096 subsets and returns the top 3 by rating.
 *  This gives the true best solution for comparison against the greedy strategies.
 *
 * Part 3 – Comparison Summary (ComparisonResults.java):
 *  Prints a formatted table comparing all strategies vs. optimal.
 *
 * Part 4 – Dynamic Programming (DP.java):
 *  Solves optimally using a DP table and traceback.
 */

public class Main {

    // The space shuttle could lift up to 700 kg of science payloads into near-earth orbit.
    static final int WEIGHT_LIMIT = 700;

    public static void main(String[] args) {

        // Load all hard-coded experiments
        List<Experiment> experiments = loadExperiments();

        // Print program header
        System.out.println("---------------------------------------------------------------------");
        System.out.println("              The Knapsack Problem by SuperCoolTeam");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                       Weight Limit: 700 kg");
        System.out.println("                     Experiments Available: 12");
        System.out.println("---------------------------------------------------------------------");

        // Print the full experiment list
        System.out.println("All Available Experiments:");
        System.out.println("---------------------------------------------------------------------");
        for (Experiment e : experiments) {
            System.out.println("  " + e);
        }
        System.out.println();

        
        
        /*
         * PART 1: GREEDY STRATEGIES
         */
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                  PART 1: GREEDY STRATEGIES");
        System.out.println("---------------------------------------------------------------------");

        Greedy greedy = new Greedy(experiments, WEIGHT_LIMIT);

        // Run all three greedy strategies and store results
        Solution greedyRating = greedy.solveByHighestRating();
        Solution greedyWeight = greedy.solveByLightestFirst();
        Solution greedyRatio  = greedy.solveByBestRatio();

        // Display each result
        greedyRating.display();
        greedyWeight.display();
        greedyRatio.display();

        
        
        /*
         * PART 2: BRUTE FORCE
         */
        System.out.println("---------------------------------------------------------------------");
        System.out.println("             PART 2: BRUTE FORCE / EXHAUSTIVE SEARCH");
        System.out.println("                    (2^12 = 4,096 subsets)");
        System.out.println("---------------------------------------------------------------------");

        /** TODO */

        
        
        /* 
         * PART 4 – Dynamic Programming (extra credit)
         * (before Part 3 so the DP result is available for comparison)
        */
        System.out.println("---------------------------------------------------------------------");
        System.out.println("           PART 4: DYNAMIC PROGRAMMING (Extra Credit)");
        System.out.println("---------------------------------------------------------------------");

        /** TODO */
        
        
        

        /*
         * PART 3 – Comparison Summary (intended for the report)
         */
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                    PART 3: COMPARISON SUMMARY");
        System.out.println("---------------------------------------------------------------------");

        /** TODO */

        //report.printSummary();
    }

    /**
     * Creates the list of 12 space shuttle science experiments.
     * 
     * @return List of all 12 experiment objects
     */
    public static List<Experiment> loadExperiments() {
        List<Experiment> experiments = new ArrayList<>();

        //                              ID        Name                         Weight  Rating
        experiments.add(new Experiment(  1,  "Cloud Patterns",                   365,    2  ));
        experiments.add(new Experiment(  2,  "Solar Flares",                     264,    9  ));
        experiments.add(new Experiment(  3,  "Solar Power",                      188,    6  ));
        experiments.add(new Experiment(  4,  "Binary Stars",                     203,    8  ));
        experiments.add(new Experiment(  5,  "Relativity",                       104,    8  ));
        experiments.add(new Experiment(  6,  "Seed Viability",                    74,    7  ));
        experiments.add(new Experiment(  7,  "Sun Spots",                         90,    2  ));
        experiments.add(new Experiment(  8,  "Mice Tumors",                       65,    8  ));
        experiments.add(new Experiment(  9,  "Microgravity Plant Growth",          75,    5  ));
        experiments.add(new Experiment( 10,  "Micrometeorites",                  170,    9  ));
        experiments.add(new Experiment( 11,  "Cosmic Rays",                       80,    7  ));
        experiments.add(new Experiment( 12,  "Yeast Fermentation",               274,    4  ));

        return experiments;
    }
}
