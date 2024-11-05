import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        ArrayList<String> list = new ArrayList<>();
        int equal, not;

        int i = 0;
        while (i < s.length()) {
            equal = 1;
            not = 0;
            char x = s.charAt(i);

            int j = i + 1;
            while (j < s.length()) {
                char y = s.charAt(j);
                if (x == y)
                    equal++;
                else
                    not++;

                if (equal == not) {
                    list.add(s.substring(i, j + 1));
                    i = j; 
                    break;
                }
                j++;
            }

            if (equal != not || j == s.length()) {
                list.add(s.substring(i, j));
                i = j; 
            }

            i++;
        }

        return list.size();
    }
}
