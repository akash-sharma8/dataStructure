class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int tar = image[sr][sc];
        if (tar == color)
            return image;

        dfs( sr, sc,image, tar, color);
        return image;
    }

    public void dfs( int i, int j,int[][] image, int tar, int color) {
            if(i<0 || i>=image.length || j<0 || j>=image[0].length){
                return;
            }
            if(image[i][j]!=tar){
                return;
            }
            image[i][j]=color;

            dfs(i-1,j,image, tar,color);
            dfs(i+1,j,image, tar,color);
            dfs(i,j-1,image, tar,color);
            dfs(i,j+1,image, tar,color);
    }
}