class Solution {
    public boolean isAnagram(String s, String t) {
        int ls = s.length();
        int ts = t.length();
        int[] table = new int[26];
        for (int i = 0; i < ls; i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ts; i++) {
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }
}