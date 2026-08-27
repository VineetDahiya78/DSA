class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        
    //     int i = 1 ;
    //     int index = -1;
    //     while(i<n){
    //         if(arr[i-1]<arr[i]&&arr[i]>arr[i+1]){
    //             index = i;
    //         }
    //         i++;
    //     }
    //     return index;
    // }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
               
                start = mid + 1;
            } 
            else {
                
                end = mid;
            }
        }

        return start;
    }
}