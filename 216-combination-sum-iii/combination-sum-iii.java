class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<>() , n,k,1 );
        return res;   
    }

    private void backtrack(List<Integer> list ,int n,int k, int num){
        if(n==0 && k==0){
            res.add(new ArrayList<>(list));
            return;
        }
         if(n<0) return ;
      
     
       for(int i = num; i<=9; i++){
            if(i>n || k<=0) break;
            list.add(i);
            backtrack(list , n-i,k-1,i+1);
            list.remove(list.size() - 1);
            }
        

    }
}