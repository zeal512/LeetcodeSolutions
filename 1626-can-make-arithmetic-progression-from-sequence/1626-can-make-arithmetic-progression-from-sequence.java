class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
        int diff = arr[1] - arr[0];
        for(int i=1; i< arr.length; i++){
            if(arr[i] - arr[i-1] != diff) return false;
        }
        return true;
    }

    public static void mergeSort(int[] arr, int low, int high){
		if(low>=high){
			return;
		}
		int mid = (low+high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}

	public static void merge(int[] arr, int low, int mid, int high){
		int[] temp = new int[high-low+1];
		int left = low, right = mid+1;
		int i = 0;
		while(left<=mid && right<= high){
			if(arr[left] <= arr[right]){
				temp[i] = arr[left];
				i++;
				left++;
			}
			else{
				temp[i] = arr[right];
				i++;
				right++;
			}
		}
		while(left<= mid){
			temp[i] = arr[left];
			i++;
			left++;
		}
		while(right<= high){
			temp[i] = arr[right];
			i++;
			right++;
		}
		for(int j =low; j<=high; j++ ){
			arr[j] = temp[j-low];
		}
	}
}