class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int ans = -1;
        int prefixMax[] = new int[n];
        int suffixMin[] = new int[n];
        prefixMax[0] = nums[0];
        suffixMin[n-1]=nums[n-1];
        for(int i = 1; i< n;i++ ){
            prefixMax[i] = Math.max(prefixMax[i-1],nums[i]);
        }
        for(int i = n-2 ; i>=0;i--){
            suffixMin[i]=Math.min(suffixMin[i+1],nums[i]);
        }
        for(int i = 0 ; i< n; i++){
            if((prefixMax[i]-suffixMin[i])<=k){
                ans = i;
                break;
            }
        }
        return ans ;
    }
}