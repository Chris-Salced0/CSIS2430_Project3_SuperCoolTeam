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

/**
 * Summarizes the output for results of all 3 greedy strategies (part 1),
 * the result of the brute-force optimal (part 2), and a brief printed
 * summary identifying which strategies matched the optimal and which
 * did not. 
 *
 * The brute-force result is used as the reference for "optimal" because it
 * is the only strategy guaranteed to find the best answer.
 */

package project3;

public class ComparisonReport {

    private Solution greedyRatingResult; // greedy - highest rating first
    private Solution greedyWeightResult; // greedy - lightest first
    private Solution greedyRatioResult;  // greedy - best ratio first 
    private Solution optimalResult;      // brute-force search (optimal)
    private Solution dpResult;           // dynamic programming

    /**
     * Constructs a ComparisonReport with all strategy results.
     *
     * @param greedyRating 
     * @param greedyWeight
     * @param greedyRatio
     * @param optimal
     * @param dp
     */
    public ComparisonReport(Solution greedyRating, Solution greedyWeight,
                            Solution greedyRatio) {
        this.greedyRatingResult = greedyRating;
        this.greedyWeightResult = greedyWeight;
        this.greedyRatioResult  = greedyRatio;
        //this.optimalResult      = optimal;
        //this.dpResult           = dp;
    }

    /**
     * Prints the full ComparisonReport.
     *
     * Example output:
     * Strategy                                   |   Weight | Rating
     * ---------------------------------------------------------------------
     * Greedy – Highest Rating First              |   637 kg |     26
     * Greedy – Lightest First                    |   694 kg |     19
     * Greedy – Best Ratio First                  |   658 kg |     46
     * ---------------------------------------------------------------------
     */
    public void printSummary() {
        // Table Header
        System.out.printf("%-42s   | %8s | %6s%n", "Strategy", "Weight", "Rating");
        System.out.println("---------------------------------------------------------------------");

        // Table Rows
        printRow(greedyRatingResult);
        printRow(greedyWeightResult);
        printRow(greedyRatioResult);
        System.out.println("---------------------------------------------------------------------");
        printRow(optimalResult);
        printRow(dpResult);

        // Brute Force Optimal Rating
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Brute-Force Optimal Rating: " + optimalResult.totalRating);
        System.out.println();

        // Result Section
        System.out.println("Optimal or Not Optimal?");
        System.out.println("---------------------------------------------------------------------");
        printResult(greedyRatingResult);
        printResult(greedyWeightResult);
        printResult(greedyRatioResult);
        //printResult(dpResult);

        System.out.println("=====================================================================");
        System.out.println();
    }

    /**
     * Helper method that prints a row in the comparison table for the solution.
     *
     * @param s Solution
     */
    private void printRow(Solution s) {
        System.out.printf("  %-42s | %5d kg | %6d%n",
                s.strategyName, s.totalWeight, s.totalRating);
    }

    /**
     * Helper method that finds whether the solution's total rating matches the optimal.
     *
     * @param s Solution
     * @return true if s.totalRating = the brute force optimal rating
     */
    private boolean matchesOptimal(Solution s) {
        return s.totalRating == optimalResult.totalRating;
    }

    /**
     * Helper method that prints a result line for a single strategy and whether it 
     * matched the optimal rating produced by brute force.
     *
     * @param s Solution
     */
    private void printResult(Solution s) {
        String result = matchesOptimal(s)
                ? "*  MATCHES OPTIMAL!"
                : "X  Did NOT match optimal (rating: " + s.totalRating
                  + " vs optimal: " + optimalResult.totalRating + ")";

        System.out.printf("  %-42s → %s%n", s.strategyName, result);
    }
}
