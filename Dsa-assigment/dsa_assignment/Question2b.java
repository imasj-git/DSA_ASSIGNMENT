import java.util.*;

public class Question2b {
    // Function to get individuals who will eventually know the secret
    public static List<Integer> getIndividuals(int n, int[][] intervals, int firstPerson) {
        // List to store the result (individuals who will eventually know the secret)
        List<Integer> result = new ArrayList<>();
        Set<Integer> knownSecrets = new HashSet<>();
        knownSecrets.add(firstPerson); // Initially, add the first person who knows the secret

        // Iterate through each interval
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Set to store new individuals who will learn the secret during this interval
            Set<Integer> newIndividuals = new HashSet<>();

            // Iterate through each person 
            for (int i = start; i <= end; i++) {
                if (knownSecrets.contains(i)) {
                    for (int j = 0; j < n; j++) {
                        // Check if the individual doesn't already know the secret
                        if (!knownSecrets.contains(j)) {
                            newIndividuals.add(j);
                        }
                    }
                }
            }

            // Add the new individuals to the set of known secrets
            knownSecrets.addAll(newIndividuals);
        }

        // Add all individuals who eventually know the secret to the result list
        result.addAll(knownSecrets);
        return result;
    }

    // Main method to test the getIndividuals function
    public static void main(String[] args) {
        int n = 5;
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}};
        int firstPerson = 0;

        // Get the result by calling the getIndividuals function
        List<Integer> result = getIndividuals(n, intervals, firstPerson);

        // Print the result
        System.out.println("Individuals who will eventually know the secret: " + result);
    }
}
