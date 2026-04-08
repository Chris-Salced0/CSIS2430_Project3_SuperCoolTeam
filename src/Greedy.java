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
 * PART 1: IMPLEMENT THREE GREEDY STRATEGIES
 * 
 * Implements three separate methods, each of which builds a payload without exceeding 700 kg:
 * 		Highest Rating First
 * 			Select experiments based on highest rating without exceeding 700 kg.
 * 			Output: list of chosen experiments, total weight, and total rating.
 * 		Lightest First
 * 			Select experiments based on lightest weight without exceeding 700 kg.
 * 			Output: list of chosen experiments, total weight, and total rating.
 * 		Best Rating-to-Weight Ratio First
 * 			Compute score = rating / weight for each experiment.
 * 			Select experiments based on highest ratio while total weight ≤ 700 kg.
 * 			Output: list of chosen experiments, total weight, and total rating.
 * Clearly displays results for all three strategies.
 */

public class Greedy {
	
    private List<Experiment> experiments; 	// The full list of available experiments
    private int weightLimit; 				// Max payload weight (700 kg)

    /**
     * Constructs a Greedy method with the experiments and weight limit.
     *
     * @param experiments All 12 experiments to consider
     * @param weightLimit Maximum payload weight (700 kg)
     */
    public Greedy(List<Experiment> experiments, int weightLimit) {
        this.experiments = experiments;
        this.weightLimit = weightLimit;
    }

    /*
     * HIGHEST RATING FIRST
     */

	    /**
	     * Sorts experiments by descending rating and adds each one to the payload 
	     * if it fits.
	     *
	     * @return Solution containing the chosen experiments, total weight, and total rating.
	     */
	    public Solution solveByHighestRating() {
	        // Copy the list
	        List<Experiment> sorted = new ArrayList<>(experiments);
	
	        // Selection sort by rating, highest first
	        for (int i = 0; i < sorted.size() - 1; i++) {
	            int bestIndex = i;
	            for (int j = i + 1; j < sorted.size(); j++) {
	                if (sorted.get(j).rating > sorted.get(bestIndex).rating) {
	                    bestIndex = j;
	                }
	            }
	            Experiment temp = sorted.get(i);
	            sorted.set(i, sorted.get(bestIndex));
	            sorted.set(bestIndex, temp);
	        }
	        
	        // Selection Logic
	        List<Experiment> chosen = new ArrayList<>();
	        int currentWeight = 0;
	        int currentRating = 0;

	        for (Experiment e : sorted) {
	            if (currentWeight + e.weight <= weightLimit) {
	                chosen.add(e);
	                currentWeight += e.weight;
	                currentRating += e.rating;
	            }
	        }
	        return new Solution(chosen, currentWeight, currentRating, "Greedy – Highest Rating First");
	    }
	    

    /*
     * LIGHTEST FIRST
     */

	    /**
	     * Sorts experiments by ascending weight and adds each one to the payload
	     * if it fits. 
	     * 
	     * @return Solution containing the chosen experiments, total weight, and total rating
	     */
	    public Solution solveByLightestFirst() {
	        // Copy the list
	        List<Experiment> sorted = new ArrayList<>(experiments);
	
	        // Selection sort by weight, lightest first
	        for (int i = 0; i < sorted.size() - 1; i++) {
	            int bestIndex = i;
	            for (int j = i + 1; j < sorted.size(); j++) {
	                if (sorted.get(j).rating > sorted.get(bestIndex).weight) {
	                    bestIndex = j;
	                }
	            }
	
	            Experiment temp = sorted.get(i);
	            sorted.set(i, sorted.get(bestIndex));
	            sorted.set(bestIndex, temp);
	        }
	        
	        // Selection Logic
	        List<Experiment> chosen = new ArrayList<>();
	        int currentWeight = 0;
	        int currentRating = 0;

	        for (Experiment e : sorted) {
	            if (currentWeight + e.weight <= weightLimit) {
	                chosen.add(e);
	                currentWeight += e.weight;
	                currentRating += e.rating;
	            }
	        }
	        return new Solution(chosen, currentWeight, currentRating, "Greedy – Lightest First");
	    }

    /*
     * BEST RATING-TO-WEIGHT RATIO FIRST
     */

	    /**
	     * Uses getRatioScore from Experiment class for each experiment and sorts by
	     * descending score. 
	     *
	     * @return Solution containing the chosen experiments, total weight, and total rating
	     */
	    public Solution solveByBestRatio() {
	        // Copy the list
	        List<Experiment> sorted = new ArrayList<>(experiments);
	
	        // Selection sort by ratio, highest first
	        for (int i = 0; i < sorted.size() - 1; i++) {
	            int bestIndex = i;
	            for (int j = i + 1; j < sorted.size(); j++) {
	                if (sorted.get(j).getRatioScore() > sorted.get(bestIndex).getRatioScore()) {
	                    bestIndex = j;
	                }
	            }
	         
	            Experiment temp = sorted.get(i);
	            sorted.set(i, sorted.get(bestIndex));
	            sorted.set(bestIndex, temp);
	        }
	
	        // Selection Logic
	        List<Experiment> chosen = new ArrayList<>();
	        int currentWeight = 0;
	        int currentRating = 0;

	        for (Experiment e : sorted) {
	            if (currentWeight + e.weight <= weightLimit) {
	                chosen.add(e);
	                currentWeight += e.weight;
	                currentRating += e.rating;
	            }
	        }
	        return new Solution(chosen, currentWeight, currentRating, "Greedy – Best Ratio First");
	    }
}
