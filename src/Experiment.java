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

/**
 * Represents science experiments available for loading onto the space shuttle.
 *
 * The space shuttle could lift up to 700 kg of science payloads into 
 * near-earth orbit. Answers the question under investigation: what combination 
 * of payloads gives the highest overall rating?
 */

public class Experiment {

    public int    id;      // Experiment number on assignment list (1–12)
    public String name;    // Experiment name
    public int    weight;  // Experiment weight in kilograms
    public int    rating;  // Scientific value rating

    /**
     * Constructs a new Experiment with id, name, weight and rating.
     *
     * @param id     Unique identifier for the experiment (1–12)
     * @param name   Human-readable name of the experiment
     * @param weight Weight of the experiment in kilograms
     * @param rating Scientific value/rating of the experiment
     */
    public Experiment(int id, String name, int weight, int rating) {
        this.id     = id;
        this.name   = name;
        this.weight = weight;
        this.rating = rating;
    }

    /**
     * Computes the rating-to-weight ratio. A higher ratio = more value per kg.
     *
     * This score is used by the Greedy strategy's "Best Rating-to-Weight Ratio First" but keeping
     * it in Experiment makes it accessible to any class without going through Greedy.
     * 
     * @return ratio = rating divided by weight
     */
    public float getRatioScore() {
        return (float) rating / weight;
    }

    /**
     * Returns a formatted id, weight, rating, and ratio of the experiment.
     *
     * Example output:
     *   #5  Relativity                      | Weight: 104 kg | Rating:   8 | Ratio: 0.08
     */
    @Override
    public String toString() {
        return String.format("#%-3d %-32s | Weight: %3d kg | Rating: %2d | Ratio: %.4f",
                id, name, weight, rating, getRatioScore());
    }
}
