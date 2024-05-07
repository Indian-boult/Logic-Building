class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().lastIndexOf(' ') == -1 ? s.trim().length() : s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }
}