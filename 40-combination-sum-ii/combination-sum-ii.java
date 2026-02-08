import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Step 1: sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {

        // Base case: target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore candidates
        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // If current number exceeds target, stop (array is sorted)
            if (candidates[i] > target) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            // Explore with next index (i + 1 → each number used once)
            backtrack(candidates, target - candidates[i], i + 1, current, result);

            // Undo choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
