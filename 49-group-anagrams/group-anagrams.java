class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i =0; i<strs.length; i++){
            String s = strs[i];
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String Key = new String(ch);
            if(!map.containsKey(Key)){
                map.put(Key,new ArrayList<>());
            }
            map.get(Key).add(strs[i]);

        }
        return new ArrayList<>(map.values());
    }
}