package com.michael.jeetcode.group0.LongestPalindrome_5;

/**
 * 最长回文子串
 */
public class LongestPalindrome {

    /**
     * https://www.jianshu.com/p/a7741619dd58
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                // 判断是否是回文， dp[i+1][j-1] 是上一个判断的结果，如果上一个不是回文，则下一个就一定不是回文
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);//小于3是因为aba一定是回文
                // 如果是回文，并且长度比之前的长久取最新的值
                if(dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    // 使用中心扩展算法
    public static String longestPalindrome2(String s) {
        if (s.length() < 2) {                           // 单个字符肯定是回文串，直接返回s
            return s;
        }
        int maxLength = 0;
        int center = 0;
        for (int i = 0; i < s.length(); i++){
            int begin = centerExpand(s, i, i);          // 最长回文串长度为奇数
            int end = centerExpand(s, i, i + 1);   // 最长回文串长度为偶数

            if (maxLength < Math.max(begin, end)){
                center = i;                             // 以center为中心
                maxLength = Math.max(begin, end);       // 最长回文串长度
            }
        }
        // 如果我们的回文串的长度为偶数，那么中心左边的长度会比右边的长度小1
        return s.substring(center - (maxLength - 1) / 2, center + maxLength / 2 + 1);
    }

    private static int centerExpand(String s, int begin, int end){
        int left = begin, right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 返回以begin,end为基准，同时向左向右扩展后能够得到的最长回文串长度
        return right - left - 1;
    }

    public static void main(String[] args) {

        String s = "sdasdshdsfsdhsadlosi";
//            System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
    }


    static class Data {
        public static String str = "dsfsdhadhfkdsdsfsdhadhdsfsdhadhfkddsfsdhadhfkd" +
                "sahfksadhdsfsdhadhfkdsahfksadhfksddsfsdhadhfkdsahfksadhfksdhfusdih" +
                "fksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfio" +
                "aewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfk" +
                "sdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskhfusdihfksjadfhks" +
                "adjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskd" +
                "sfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawo" +
                "euruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfu" +
                "sdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkh" +
                "fioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadsfsdhadhfkdsahfksa" +
                "dhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncs" +
                "dbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjk" +
                "dsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdfhksad" +
                "jkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskfdsfs" +
                "dhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeurui" +
                "hweiyrtiuoncsdbfzmbfkhfioaewncfhskksdhfusdihfksjadfhksadjkdsahfdsjkhf" +
                "ksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsksahfksadhfksdhfusdi" +
                "hfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioae" +
                "wncfhskfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeur" +
                "uihweiyrtiuoncsdbfzmbfkhfioaewncfhskahfksadhfksdhfusdihfksjadfhksa" +
                "djkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsk";
    }

}
