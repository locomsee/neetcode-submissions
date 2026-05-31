class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb=new StringBuilder();
        //encode the string
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
       return sb.toString();
    }

    public List<String> decode(String str) {
      List<String> result=new ArrayList();
      //Reading cursor
      int i = 0; 
      //Loop
      while(i < str.length()){
        //Find the #
        int j = str.indexOf('#',i);

        //Read the length number
        int len=Integer.parseInt(str.substring(i,j));

        //grab the actual word
        result.add(str.substring(j+1,j+1+len)); //j+1 start after the #, j+1+len end exactly len characters later
        //The slice is the original word, Add it to the result list

        //Move the cursor forward
        i=j+1+len;
      }
       return result;
    }
}
