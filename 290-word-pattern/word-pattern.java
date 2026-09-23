class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();
        String strArray[] = s.split(" ");

        if(strArray.length!=pattern.length()) return false;

        for(int i=0; i<pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(strArray[i])){
                    return false;
                }
            }else{
                map.put(pattern.charAt(i),strArray[i]);
            }
            if (reverseMap.containsKey(strArray[i])) {
                if (reverseMap.get(strArray[i]) != pattern.charAt(i)) {
                        return false;
                }
            } else {
                reverseMap.put(strArray[i], pattern.charAt(i));
            }
        

        }
        return true;
    }
}