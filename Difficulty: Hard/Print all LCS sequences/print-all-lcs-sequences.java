//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<String> all_longest_common_subsequences(String s, String t) {
        
       int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> lcsSet = findLCS(s, t, m, n, dp, new StringBuilder(), memo);

        List<String> result = new ArrayList<>(lcsSet);
        Collections.sort(result);

        return result;
        
    }
    
     private static Set<String> findLCS(String s, String t, int i, int j, int[][] dp, StringBuilder sb, Map<String, Set<String>> memo) {
        String key = i + "|" + j + "|" + sb.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        Set<String> result = new HashSet<>();
        if (i == 0 || j == 0) {
            result.add(sb.reverse().toString());
            sb.reverse();
        } else {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                sb.append(s.charAt(i - 1));
                result.addAll(findLCS(s, t, i - 1, j - 1, dp, sb, memo));
                sb.deleteCharAt(sb.length() - 1);
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    result.addAll(findLCS(s, t, i - 1, j, dp, sb, memo));
                }
                if (dp[i][j - 1] >= dp[i - 1][j]) {
                    result.addAll(findLCS(s, t, i, j - 1, dp, sb, memo));
                }
            }
        }

        memo.put(key, result);
        return result;
    }
}