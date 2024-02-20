public class Question1a {
    // The main method to calculate the minimum cost
    public int minCost(int[][] costs) {
        // Check if the input array 'costs' is null or empty
        if (costs == null || costs.length == 0)
            return 0;
        // Get the number of houses (rows) and colors (columns)
        int n = costs.length;
        int k = costs[0].length;

        // Create a 2D array 'dp' to store intermediate results
        int[][] dp = new int[n][k];

        // Initialize the first row of 'dp' with the costs of painting the first house
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        // Fill in the 'dp' array for the remaining houses
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                
                dp[i][j] = Integer.MAX_VALUE;
                // Iterate over the colors of the previous house and find the minimum cost
                for (int l = 0; l < k; l++) {

                    if (j == l)
                        continue;
                    
                    // Update the minimum cost
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + costs[i][j]);
                }
            }
        }

        // Find the minimum cost among
        int resultMinCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            resultMinCost = Math.min(resultMinCost, dp[n - 1][j]);
        }

        // Return the overall minimum cost
        return resultMinCost;
    }

    // Main method
    public static void main(String[] args) {
        // Create an instance of Question1a
        Question1a resultCost = new Question1a();

        // Example input: cost matrix for painting each house with different colors
        int[][] costs = { { 1, 3, 2 }, { 4, 6, 8 }, { 3, 1, 5 } };

        // Calculate and print the minimum cost
        System.out.println("Minimum cost to decorate all the venues: " + resultCost.minCost(costs));
    }
}
