func longestPalindrome(s string) string {
    n := len(s)
    if n < 2 {
        return s
    }

    start, maxLength := 0, 1
    dp := make([][]bool, n)
    for i := range dp {
        dp[i] = make([]bool, n)
        dp[i][i] = true // Every single character is a palindrome
    }

    // Check for palindromes of length 2
    for i := 0; i < n-1; i++ {
        if s[i] == s[i+1] {
            dp[i][i+1] = true
            start = i
            maxLength = 2
        }
    }

    // Check for palindromes of length 3 and more
    for length := 3; length <= n; length++ {
        for i := 0; i < n-length+1; i++ {
            j := i + length - 1 // End index of the current substring
            if s[i] == s[j] && dp[i+1][j-1] {
                dp[i][j] = true
                start = i
                maxLength = length
            }
        }
    }

    return s[start : start+maxLength]
}