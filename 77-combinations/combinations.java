class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(1, ans, list, n, k);
        return ans;
    }
    private void backtrack(int start , List<List<Integer>> ans , List<Integer> list, int n , int k ){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = start ; i<=n; i++){
            list.add(i);
            backtrack( i + 1, ans, list, n , k);
            list.remove(list.size()-1);
        }


    }
}