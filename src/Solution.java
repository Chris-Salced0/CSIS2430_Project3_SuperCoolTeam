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

import java.util.List;

/**
 * Displays the formatted results from any knapsack solving strategy.
 *
 * Displays which experiments were chosen, the total weight of the chosen set, 
 * the total rating of the chosen set, and the name of the strategy that produced it.
 *
 * Sharing the Solution class ensures every knapsack class (Greedy, BruteForce, DP)
 * returns results in the same format.
 */
public class Solution {

    public List<Experiment> chosenExperiments;
    public int    totalWeight;
    public int    totalRating;
    public String strategyName;

    /**
     * Constructs a Solution with all required fields.
     *
     * @param chosenExperiments List of experiments selected by this strategy
     * @param totalWeight       Combined weight of selected experiments (kg)
     * @param totalRating       Combined rating of selected experiments
     * @param strategyName      Human-readable name of the strategy used
     */
    public Solution(List<Experiment> chosenExperiments, int totalWeight,
                    int totalRating, String strategyName) {
        this.chosenExperiments = chosenExperiments;
        this.totalWeight       = totalWeight;
        this.totalRating       = totalRating;
        this.strategyName      = strategyName;
    }

    /**
     * Prints the formatted solution.
     *
     * Example output:
     * 
     *   Strategy: Greedy – Highest Rating First
     *   ---------------------------------------------------------------------
     *     #2  Solar Flares    | Weight: 264 kg | Rating:  9 | Ratio: 0.0341
     *     #8   Mice Tumors    | Weight:  65 kg | Rating:  8 | Ratio: 0.1231
     *   ---------------------------------------------------------------------
     *     Total Weight: 689 kg  |  Total Rating: 42
     *     
     *   *********************************************************************
     */
    public void display() {
        System.out.println("  Strategy: " + strategyName);
        System.out.println("  Experiments chosen: " + chosenExperiments.size());
        System.out.println("---------------------------------------------------------------------");

        for (Experiment e : chosenExperiments) {
            System.out.println("  " + e);
        }

        System.out.println("---------------------------------------------------------------------");
        System.out.printf("  Total Weight: %d kg   |   Total Rating: %d%n",
                totalWeight, totalRating);
        System.out.println();
        System.out.println("*********************************************************************");
        System.out.println();
    }
}
