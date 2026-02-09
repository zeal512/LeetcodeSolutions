class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        /* Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], nums1[i]);
        }

        for(int i=0; i< nums2.length; i++){
            if(map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result; */
        Set<Integer> unique = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1){
            unique.add(num);
        }
        for(int num : nums2){
            if(unique.contains(num)){
                list.add(num);
                unique.remove(num);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}