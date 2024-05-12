class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // Odd number of parentheses can't be balanced

        return validate(s, locked, '(') && validate(s, locked, ')');
    }

    private boolean validate(String s, String locked, char target) {
        int balance = 0; // Tracks the number of open '(' needed
        int free = 0; // Tracks the number of characters that can be freely changed

        // We use target to decide the direction of validation
        int start = (target == '(') ? 0 : s.length() - 1;
        int end = (target == '(') ? s.length() : -1;
        int step = (target == '(') ? 1 : -1;

        for (int i = start; i != end; i += step) {
            if (locked.charAt(i) == '0') {
                // This character can be freely changed
                free++;
            } else {
                // If it's locked and is the target, we need one less target character
                // If it's locked and not the target, we need one more target character
                balance += (s.charAt(i) == target) ? 1 : -1;
            }

            if (balance + free < 0) { // Not enough free to make up for deficit
                return false;
            }
        }

        // Overall, we must be able to balance out
        // In left-to-right check, balance + free must be non-negative (can't have more ')' than '(')
        // In right-to-left check, balance + free must be non-negative (can't have more '(' than ')')
        return (balance <= free);
    }
}