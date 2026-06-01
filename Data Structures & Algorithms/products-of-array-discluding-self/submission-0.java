class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n=nums.length;
        //Create a new int array []
        int[] newNums=new int[n];

        for(int i = 0; i < n; i++){

            int product=1;

            for(int j = 0; j < n; j++){

               if(i != j){
                product=product * nums[j]; 
               }
            
            newNums[i]=product;
          }
        }
       return newNums; 
    }
}  
