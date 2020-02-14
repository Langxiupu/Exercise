import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String maxStr = "";

        for(String word : d)
            if(include(s, word))
            {
                if(maxStr.equals(""))
                    maxStr = word;
                else if(word.length() > maxStr.length())
                    maxStr = word;
                else if(word.length() == maxStr.length()
                && word.compareTo(maxStr) < 0)
                    maxStr = word;
            }
        return maxStr;
    }

    private boolean include(String s, String word)
    {
        int i = 0;
        int j = 0;
        while(i < s.length())
        {
            if(s.charAt(i) == word.charAt(j))
                j++;
            if(j == word.length())
                return true;
            i++;
        }
        return false;
    }
}
