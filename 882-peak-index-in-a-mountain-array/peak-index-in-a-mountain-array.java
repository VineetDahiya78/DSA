class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int i = 1 ;
        int index = -1;
        while(i<n){
            if(arr[i-1]<arr[i]&&arr[i]>arr[i+1]){
                index = i;
            }
            i++;
        }
        return index;
    }
}