class Solution {

    public String fractionToDecimal(int n, int d) {
        // Negative Zero
        if (n == 0) {
            return "0";
        }
        String prefix = ((n < 0) ^ (d < 0)) ? "-" : "";

        long num = Math.abs((long) n);
        long den = Math.abs((long) d);

        long first = num / den;
        num = num % den;

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(first);

        if (num == 0) {
            return sb.toString();
        }

        sb.append('.');

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());

        while (num != 0) {
            num *= 10;
            long next = num / den;
            sb.append(next);

            num %= den;

            if (map.containsKey(num)) {
                int lastIndex = map.get(num);
                sb.insert(lastIndex, '(');
                sb.append(')');
                break;

            }
            map.put(num, sb.length());
        }

        return sb.toString();

    }
}