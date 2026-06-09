class Solution {
    public boolean isPalindrome(String s) {
       String newString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

       if(newString.isEmpty() || newString.length() == 1 )return true;

        int left=0;
        int right=newString.length() - 1;

        boolean isPalindrome=false;

       // System.out.println("String is after clean up"+s);

        while(left < right){

           if(newString.charAt(left) == newString.charAt(right)){
                isPalindrome=true;
                left++;
                right--;

           }else{
              // System.out.println(">>>>>>>"+s.charAt(left));
               //System.out.println(">>>>>>>"+s.charAt(right));
               isPalindrome=false;
               break;
            }
        }
         
        return isPalindrome;
        
    }
}
