class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int temp;
        int l = image.length;
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image.length; j++){
                temp = image[i][j];
                if(j<(l+1)/2) 
                {
                    image[i][j] = image[i][l-j-1];
                    image[i][l-j-1] = temp;
                }
                image[i][j] = (image[i][j] == 0 ) ? 1 : 0;    
            }
        }
        return image;
    }
}