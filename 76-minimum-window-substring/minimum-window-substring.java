class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minCount = t.length();
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        int start = 0;

        for(int right =0 ; right<s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                if(map.get(ch)>0) minCount--;
                map.put(ch, map.get(ch)-1);
            }

            while(minCount==0){
                int winLength = right-left+1;
                if(winLength<minLength){
                    minLength = winLength;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar)+1);
                    if(map.get(leftChar)>0){
                        minCount++;
                    }
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start+minLength);   
    }
}