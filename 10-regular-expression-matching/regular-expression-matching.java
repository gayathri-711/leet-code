class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c*, etc. that match empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char pc = p.charAt(j - 1);
                char sc = s.charAt(i - 1);

                if (pc == sc || pc == '.') {
                    // Characters match or '.' matches any char
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else if (pc == '*') {
                    // '*' can mean zero of preceding
                    dp[i][j] = dp[i][j - 2];

                    // '*' can mean one or more if preceding char matches
                    char prev = p.charAt(j - 2);
                    if (prev == sc || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
