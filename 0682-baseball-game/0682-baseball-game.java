class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack();

        for(int i =0 ; i<operations.length; i++){
            if(operations[i].equals("C")){
                st.pop();
            }else if(operations[i].equals("D")){
                st.push(2*st.peek());
            }else if(operations[i].equals("+")){
                int temp = st.pop();
                int x = st.peek() + temp;
                st.push(temp);
                st.push(x);
            }else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int ans =0;
        while(st.size() != 0){
            ans+=st.pop();
        }

        return ans;
        
    }
}