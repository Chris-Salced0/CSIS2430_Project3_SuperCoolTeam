/*
 * Team Name:    SuperCoolTeam
 * Team Members: Tayler Covington-Holler (Implementation Lead)
 *               Cameron Dickinson (Implementation Lead)
 *               Christopher Salcedo Cardenas (Verification Lead)
 *               Maxwell Jardine (Communications Lead)
 * Course:       CS 2430-501
 * Project:      Project 3 – The Knapsack Problem
 * Primary Author: Cameron Dickinson
 */

package project3;

import java.util.ArrayList;
import java.util.List;

/*
 * PART 2: BRUTE FORCE / EXHAUSTIVE SEARCH
 * 
 * Generates all 4096 possible subsets of experiments, then,
 * For each one, compute the total weight and total rating.
 * Identifies and displays the three highest-rated valid subsets, indicating which one is optimal.
 * Then, outputs the chosen experiments, total weight, and total rating.
 * 
 * This gives the true best solutions for comparison with greedy strategies 
 */

public class BruteForce {

	private List<Experiment> experiments; 	// The full list of available experiments
    private int weightLimit;				// Max payload weight (700 kg)
    private List<Solution> validSolutions = new ArrayList<>();  // List of valid solutions
    
    /**
     * Constructs a BruteForce method with the experiments and weight limit.
     *
     * @param experiments All 12 experiments to consider
     * @param weightLimit Maximum payload weight (700 kg)
     */
    public BruteForce(List<Experiment> experiments, int weightLimit) {
    	this.experiments = experiments;
    	this.weightLimit = weightLimit;
    }
    
    public List<Solution> solveTopThree() {
    	List<Experiment> empty = new ArrayList<>();
		  generateAllSubsets(experiments, 0, empty, weightLimit, validSolutions);
		
		  // selection sort for sorting the solutions by highest rating first
		  for (int i = 0; i < validSolutions.size() - 1; i++) {
            int bestIndex = i;
            for (int j = i + 1; j < validSolutions.size(); j++) {
                if (validSolutions.get(j).totalRating > validSolutions.get(bestIndex).totalRating) {
                    bestIndex = j;
                }
            }
            
            // swap for selection sort 
            Solution temp = validSolutions.get(i);
            validSolutions.set(i, validSolutions.get(bestIndex));
            validSolutions.set(bestIndex, temp);
		}
            
         	  // Label and return the top 3
            List<Solution> topThree = new ArrayList<>();
            for (int i = 0; i < Math.min(3, validSolutions.size()); i++) {
                Solution s = validSolutions.get(i);
                String label;
                if (i == 0) label = "Brute Force – OPTIMAL (1st Place)";
                else if (i == 1) label = "Brute Force – 2nd Place";
                else label = "Brute Force – 3rd Place";
                topThree.add(new Solution(s.chosenExperiments, s.totalWeight, s.totalRating, label));
            }
     
            return topThree;
    }
    
    private List<Experiment> generateAllSubsets(List<Experiment> experiments, int index, List<Experiment> currentSubset, int weightLimit, List<Solution> validSolutions) {
    	if (index == experiments.size()) {
    		int totalWeight = 0;
    		int totalRating = 0;
    		for(Experiment e : currentSubset) {
    			totalWeight += e.weight;
    			totalRating += e.rating;
    		}
    		if (isValid(currentSubset) && !currentSubset.isEmpty()) {
				  validSolutions.add(new Solution(new ArrayList<>(currentSubset), totalWeight, totalRating, "BruteForce" + index));
			  }
			  return currentSubset;
    	}
    	generateAllSubsets(experiments, index + 1, currentSubset, weightLimit, validSolutions);
		currentSubset.add(experiments.get(index));
		generateAllSubsets(experiments, index + 1, currentSubset, weightLimit, validSolutions);
		currentSubset.remove(experiments.get(index));
		return currentSubset;
	}

    
    private boolean isValid(List<Experiment> subset) {
    	int totalWeight = 0;
    	for (Experiment e : subset) {
    		totalWeight = totalWeight +  e.weight;
    	}
    	return totalWeight <= weightLimit;
    }
}
