class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        // time limit exceeded code 
        // int global = 0;
        // int local = 0;
        // for(int i = 0 ; i < n-1 ; i++){
        //     for(int j = i+1 ; j< n; j++){
        //         if(nums[i]>nums[j]) global++;
        //     }
        // }
        // for(int i = 0 ; i<(n-1);i++){
        //     if(nums[i]>nums[i+1]) local++;
        // }
        // if(global == local) return true;

        // return false;
        for(int i = 0 ; i < n ; i++){
          if(  Math.abs(nums[i]-i)>1)  return false;
        }

        // In permutation, value x ki correct position index x hoti hai.
        // Agar koi element apni correct position se 2 ya zyada places door hai,
        // to usne kisi non-adjacent element ko cross kiya hoga.
        // Isse ek global inversion aisi banegi jo local inversion nahi hogi.
        // Therefore, if |nums[i] - i| > 1 => answer false.
         // Har element max 1 position hi move hua hai,
        // so every global inversion is also a local inversion.

        return true;
    }
}