class Solution {
    public int[] findBuildings(int[] heights) {
        int maxHeight = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = heights.length-1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                list.add(i);
                maxHeight = Math.max(maxHeight, heights[i]);
            }
        }
        Collections.sort(list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}