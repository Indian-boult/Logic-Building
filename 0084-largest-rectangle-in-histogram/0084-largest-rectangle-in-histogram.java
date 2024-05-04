class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        //PSE
        int[] pse = new int[heights.length];
        pse[0] = -1;
        st.push(0);
        for (int i = 1; i < heights.length; i++) {
            while(st.size()>0 && heights[st.peek()]>=heights[i]) st.pop();
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        st.clear();
        //NSE
        int[] nse = new int[heights.length];
        nse[nse.length-1] = nse.length;
        st.push(nse.length-1);
        for (int i = heights.length-2; i >= 0; i--) {
            while(st.size()>0 && heights[st.peek()]>=heights[i]) st.pop();
            if(st.size()==0) nse[i] = nse.length;
            else nse[i] = st.peek();
            st.push(i);
        }
        st.clear();
        //Area
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int temp = (nse[i] - pse[i] - 1)*heights[i];
            if(temp > area) area = temp;
        }
        return area;
        
    }
}