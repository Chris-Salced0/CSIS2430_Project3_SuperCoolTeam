# CS 2430 – Programming Project 3  
## The Knapsack Problem  

---

## Team Name  
**SuperCoolTeam**

---

## Team Members  
- Tayler Covington-Holler (Implementation Lead)  
- Cameron Dickinson (Implementation Lead)  
- Christopher Salcedo Cardenas (Verification Lead)  
- Maxwell Jardine (Communications Lead)  

---

## Project Overview  
This project solves a version of the **knapsack problem**, where the goal is to select the best combination of items without exceeding a fixed weight limit.

In this case, the items are science experiments, and the constraint is a **700 kg payload limit**. The objective is to **maximize total scientific rating** while staying within that limit.

To explore different approaches, we implemented and compared multiple algorithmic strategies:
- Greedy – Highest Rating First  
- Greedy – Lightest First  
- Greedy – Best Rating-to-Weight Ratio First  
- Brute Force – Exhaustive Search (optimal solution)

---

## How to Run  

1. Open a terminal  
2. Navigate to the project directory  
3. Compile the program:
4. Run the program:
  
---

## Program Output  

The program displays:

- A list of all available experiments  
- Results for all three greedy strategies  
- The top 3 brute-force solutions (including the optimal solution)  
- A comparison summary showing which strategies matched the optimal result  

---

## Project Structure  

| File | Description |
|------|-------------|
| `Main.java` | Runs the program and coordinates all parts |
| `Experiment.java` | Stores experiment data and calculates ratio |
| `Greedy.java` | Implements the three greedy strategies |
| `BruteForce.java` | Generates and evaluates all subsets |
| `Solution.java` | Standardized format for displaying results |
| `ComparisonReport.java` | Displays final comparison summary |

---

## Algorithms Implemented  

### Greedy Strategies  
These approaches are fast and simple but do not guarantee the optimal solution:
- Highest Rating First  
- Lightest First  
- Best Ratio (rating/weight)

### Brute Force  
- Generates all possible subsets (2¹² = 4096 combinations)  
- Evaluates each subset  
- Guarantees the optimal solution  
- Used as a benchmark for comparison  

---

## Notes  

- Weight limit: **700 kg**  
- Total experiments: **12**  
- Total subsets evaluated: **4096**  

This project demonstrates the trade-off between:
- **Speed (greedy algorithms)**  
- **Accuracy (brute force optimal solution)**  

---

## Summary  

This project shows how different algorithmic strategies perform on the same optimization problem. While greedy methods are efficient and easy to implement, they may not always find the best solution. Brute force guarantees the correct answer but is computationally expensive. Understanding these trade-offs is essential in algorithm design.
