class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBalancedBST(nums, 0, nums.length-1);
    }

    public TreeNode constructBalancedBST(int[] arr, int start, int end){
        if(start < 0 || end >= arr.length || start > end ){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        TreeNode left = constructBalancedBST(arr, start, mid-1);
        TreeNode right = constructBalancedBST(arr, mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}