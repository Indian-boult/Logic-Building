class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1=new Stack<>();
        Stack<Character> st2=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char a=s.charAt(i);
            if(st1.empty() && a=='#')
            {
                continue;
            }
            if(a=='#' && !st1.empty())
            {
                st1.pop();
            }
            else
            {
                st1.push(a);
            }
        }
        for(int i=0;i<t.length();i++)
        {
            char b=t.charAt(i);
            if(st2.empty() && b=='#')
            {
                continue;
            }
            if(b=='#' && !st2.empty())
            {
                st2.pop();
            }
            else
            {
                st2.push(b);
            }
        }
        return st1.equals(st2);
    }
}