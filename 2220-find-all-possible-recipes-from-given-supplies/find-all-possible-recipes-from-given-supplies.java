class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Map<String, List<String>> graph =  new HashMap<>();
        Map<String,Integer> indegree = new HashMap<>();
        Queue<String> queue =  new LinkedList<>();

        for(int i =0; i<recipes.length; i++){
            String recipe = recipes[i];
            indegree.put(recipe , ingredients.get(i).size());

            for(String ingredient: ingredients.get(i)){
                graph.computeIfAbsent(ingredient, k-> new ArrayList<>()).add(recipe);
            }
        }

        for(String supply: supplies){
            queue.offer(supply);
        }
        List<String> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            String ingredient = queue.poll();
            if(!graph.containsKey(ingredient)) continue;

            for(String recipe : graph.get(ingredient)){
                indegree.put(recipe, indegree.get(recipe)-1);
                if(indegree.get(recipe)==0){
                    ans.add(recipe);
                    queue.offer(recipe);
                }
            }

        }
        return ans;
    }
}