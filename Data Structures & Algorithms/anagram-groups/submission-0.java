class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();
            //sort the string array
            Arrays.sort(chars);
            //create key from the char array
            String key = new String(chars);
            //Check if the key, if so update / otherwise add new key
            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(word);
        }

        // map.forEach((k, v) ->
        //         System.out.printf(" key="+k +" value="+ v)
        // );

        return new ArrayList<>(map.values()); 
    }
}
