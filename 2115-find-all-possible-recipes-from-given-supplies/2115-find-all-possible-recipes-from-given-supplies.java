class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        // Initialize in-degrees and graph
        for (int i = 0; i < recipes.length; i++) {
            inDegree.put(recipes[i], 0); // Set initial in-degrees
            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
                // Only increase in-degree if the ingredient is not an initial supply
                if (!supplySet.contains(ingredient)) {
                    inDegree.put(recipes[i], inDegree.get(recipes[i]) + 1);
                }
            }
        }

        // Queue for Kahn's algorithm with recipes that can already be made
        Queue<String> queue = new LinkedList<>();
        for (String recipe : recipes) {
            if (inDegree.get(recipe) == 0) { // If all ingredients are available
                queue.add(recipe);
            }
        }

        // Process the graph
        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current); // Add recipe to result
            if (!graph.containsKey(current)) continue;
            for (String dependentRecipe : graph.get(current)) {
                inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);
                if (inDegree.get(dependentRecipe) == 0) {
                    queue.add(dependentRecipe);
                }
            }
        }

        return result;
    }
}