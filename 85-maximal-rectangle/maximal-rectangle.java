class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max =0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
       if(matrix== null || matrix.length==0 || matrix[0].length == 0){
        return 0;
       }

       for(char[] row : matrix){
        for(int i =0; i<m; i++){
            arr[i] = (row[i]=='1')?arr[i]+1:0;
        }
        max = Math.max(max, largestRectangleArea(arr));
       }

return max;


    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new  int[n];  // for identifying the the smaller element in left hand side 
        int[] right = new int[n];   // for  identifying the smaller element in right hand side
        Stack<Integer> stack = new Stack<>();  // we should store only the idx

        for(int i= 0 ; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ?-1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty()?n: stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for(int i =0 ; i<n; i++){
            int width = right[i]- left[i]-1;
            maxArea = Math.max(maxArea , heights[i]*width);
        }
        return maxArea;

    }
}