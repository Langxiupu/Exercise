import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        Set<Character> hashSet = new HashSet<>(){{
            add('a');add('e');add('i');add('o');add('u');
            add('A');add('E');add('I');add('O');add('U');
        }} ;

        int i = 0;
        int j = s.length() - 1;
        char[] rslt = new char[s.length()];
        while(i <= j)
        {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(!hashSet.contains(c1))
                rslt[i++] = c1;
            if(!hashSet.contains(c2))
                rslt[j--] = c2;
            if(hashSet.contains(c1) && hashSet.contains(c2))
            {
                rslt[i++] = c2;
                rslt[j--] = c1;
            }
        }

        return String.valueOf(rslt);
    }
}
