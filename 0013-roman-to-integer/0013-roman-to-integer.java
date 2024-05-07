class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);
        int finalValue = 0; int previousValue = 0; boolean controlValue = true;
        for (int i = s.length()-1; i >= 0 ; i--) {
            if (map.get(s.charAt(i)) < previousValue) {
                controlValue = true;
            } else if (map.get(s.charAt(i)) > previousValue) {
                controlValue = false;
            }
            previousValue = map.get(s.charAt(i));
            if (controlValue) {
                finalValue -= previousValue;
            } else finalValue += previousValue;
        }
        return finalValue;
    }
}