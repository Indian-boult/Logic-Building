class Solution {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;

        while (p1 < version1.length() || p2 < version2.length()) {
            int v1 = 0;
            while (p1 < version1.length() && version1.charAt(p1) != '.') {
                v1 = v1 * 10 + (version1.charAt(p1) - '0');
                p1++;
            }

            int v2 = 0;
            while (p2 < version2.length() && version2.charAt(p2) != '.') {
                v2 = v2 * 10 + (version2.charAt(p2) - '0');
                p2++;
            }

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}