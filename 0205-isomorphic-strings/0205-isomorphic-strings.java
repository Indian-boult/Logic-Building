class Solution {
    public boolean isIsomorphic(String s, String t) {
        return compareUtil(s, t) && compareUtil(t, s);
    }

    private static Boolean compareUtil(String s1, String s2) {
        Map<Character, Character> mapping = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char curr = s1.charAt(i);
            char map = s2.charAt(i);

            if (!mapping.containsKey(curr)) {
                mapping.put(curr, map);
            } else if (mapping.get(curr) != map) {
                return false;
            }
        }

        return true;
    }
}