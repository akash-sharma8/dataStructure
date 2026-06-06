class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCharfreq = new int[26];
        int[] tempCharfreq = new int[26];
        for(String word: words2){
            Arrays.fill(tempCharfreq,0);
            for(char ch : word.toCharArray()){
                tempCharfreq[ch-'a']++;
            }

            for(int i =0; i<26; i++){
                maxCharfreq[i]  = Math.max(maxCharfreq[i], tempCharfreq[i]);
            }
        }
        List<String> universalWords = new ArrayList<>();
        for(String word: words1){
            Arrays.fill(tempCharfreq,0);
            for(char ch : word.toCharArray()){
                tempCharfreq[ch-'a']++;
            }

            boolean isUniversal = true;
            for(int i =0 ; i<26; i++){
                if(maxCharfreq[i]>tempCharfreq[i]){
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal){
                universalWords.add(word);
            }
        }
        return universalWords;        
        }
}