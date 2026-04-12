# Verification Plan – Knapsack Problem
CS 2430 – Programming Project 3  
Team: Super Cool Team  

---

## 1. Purpose

The purpose of this verification plan is to ensure that all implemented algorithms (greedy strategies and brute-force search) produce correct and consistent results for the Knapsack Problem.

The brute-force solution is used as the **ground truth (optimal solution)** to verify the correctness of the greedy strategies.

Dynamic Programming is included as **pseudocode only** and is not executed in the program.

---

## 2. Verification Strategy

We verify correctness using the following approach:

1. Execute all three greedy strategies:
   - Highest Rating First
   - Lightest First
   - Best Rating-to-Weight Ratio First

2. Execute brute-force search:
   - Generate all 4096 subsets (2^12)
   - Filter subsets that exceed 700 kg
   - Identify the top 3 highest-rated valid subsets
   - Use the highest-rated subset as the **optimal solution**

3. Compare greedy results to brute-force optimal:
   - If ratings match → strategy matches optimal
   - If ratings differ → expected greedy limitation

4. Manually verify correctness:
   - Ensure total weight ≤ 700 kg
   - Ensure total rating equals sum of selected experiments
   - Ensure no duplicate experiments in a solution

---

## 3. Test Cases

### Test Case 1 – Standard Dataset (Primary Test)

**Input:**
- All 12 experiments (default dataset)
- Weight limit = 700 kg

**Expected Behavior:**
- All algorithms execute successfully
- Brute-force generates valid subsets
- Top 3 solutions are identified correctly
- One optimal solution is determined

**Verification:**
- Confirm all weights ≤ 700 kg
- Confirm rating totals are correct
- Compare greedy outputs to optimal result

---

### Test Case 2 – Low Capacity Edge Case

**Input:**
- Weight limit = 10 kg

**Expected Behavior:**
- Only very light experiments can be selected
- Greedy and brute force may differ

**Verification:**
- Ensure no solution exceeds weight limit
- Confirm brute-force still finds valid optimal subset
- Validate system does not crash or return null

---

### Test Case 3 – High Capacity Edge Case

**Input:**
- Weight limit = 2000 kg

**Expected Behavior:**
- All experiments are selected in every strategy
- All strategies should match brute-force optimal

**Verification:**
- Total weight equals sum of all experiments
- All methods return identical results

---

### Test Case 4 – Tight Constraint Case

**Input:**
- Weight limit near 700 kg boundary

**Expected Behavior:**
- Only certain combinations fit exactly or near limit
- Brute force finds optimal combination

**Verification:**
- Ensure no overweight solutions exist
- Confirm optimal rating is highest possible under constraint

---

### Test Case 5 – Dominant Item Scenario

**Input:**
- Modify dataset so one experiment has extremely high rating

**Expected Behavior:**
- All strategies prioritize the high-value experiment
- Brute force confirms optimal includes it

**Verification:**
- High-value experiment appears in optimal solution
- Greedy strategies may or may not fully match optimal

---

## 4. Edge Case Considerations

The following cases are considered to ensure robustness:

- Empty subset handling in brute force
- Weight exactly equal to 700 kg
- Multiple subsets with identical ratings
- Very small or very large weights
- Ties in ratio-based greedy selection

---

## 5. Validation Checks

For every generated solution:

- Total Weight:
  - Must be ≤ 700 kg

- Total Rating:
  - Must equal sum of selected experiment ratings

- Uniqueness:
  - No experiment may appear more than once

- Correctness:
  - Greedy selections must follow sorting rules strictly

---

## 6. Evidence Collection

The following evidence will be collected:

- Program output showing:
  - All greedy strategy results
  - Brute-force top 3 solutions
  - Comparison summary output

- GitHub repository evidence:
  - Commits showing implementation of algorithms
  - Documentation updates in `/docs`

- Report integration:
  - Results included in formal project report

---

## 7. Conclusion

The brute-force algorithm provides the guaranteed optimal solution and serves as the baseline for evaluation.

Greedy strategies are compared against this optimal solution to evaluate their accuracy and limitations.

This verification process ensures correctness, consistency, and completeness of the implementation.
