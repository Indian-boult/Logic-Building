class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        
        while (i < code.length()) {
            if (i > 0 && stack.isEmpty()) return false; // Unbalanced tags
            
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9; // CDATA start
                i = code.indexOf("]]>", j);
                if (i == -1) return false; // Invalid CDATA
                i += 3; // Skip closing CDATA
            } else if (code.startsWith("</", i)) {
                int j = i + 2; // Tag end
                i = code.indexOf('>', j);
                if (i == -1) return false; // Invalid tag end
                String tagName = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(tagName)) return false; // Unmatched tags
            } else if (code.startsWith("<", i)) {
                int j = i + 1; // Tag start
                i = code.indexOf('>', j);
                if (i == -1) return false; // Invalid tag start
                String tagName = code.substring(j, i++);
                if (!isValidTagName(tagName)) return false; // Invalid tag name
                stack.push(tagName);
            } else {
                i++;
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isValidTagName(String tagName) {
        if (tagName.length() < 1 || tagName.length() > 9) return false;
        for (char ch : tagName.toCharArray()) {
            if (!Character.isUpperCase(ch)) return false;
        }
        return true;
    }
}