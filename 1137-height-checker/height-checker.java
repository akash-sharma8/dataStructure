class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        int count =0;
        countsort(heights);
        for(int i =0; i<heights.length;i++){
            if(expected[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }
    public static void countsort(int[] array){
       if(array==null || array.length<=1){
           return;
       }
       int max =array[0];
       for(int num : array){
           if(num>max){
               max = num;
           }
       }
       int[] countArr = new int[max+1];
       for(int num: array){
           countArr[num]++;
       }
       int index = 0;
       for(int i =0; i<=max ; i++){
           while(countArr[i]>0){
               array[index] = i;
               index++;
               countArr[i]--;
           }
       }
   }
}