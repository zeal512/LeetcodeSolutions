class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length() ) return false;
        int i =0, j=0;
        while (i< word.length() && j< abbr.length()) {
            StringBuilder build = new StringBuilder();
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                if (build.length() == 0 && abbr.charAt(j) == '0') return false;
                build.append(abbr.charAt(j++));
                }
            
            if (build.length() != 0) {
                i+=Integer.parseInt(build.toString());   
            }
            if (j == abbr.length()) break;
            
            if ( (i>= word.length()) || word.charAt(i) != abbr.charAt(j)) return false;
            i++;
            j++;
        }
        return i== word.length() && j==abbr.length();
    }
}