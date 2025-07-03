class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0 ) return new int[0][0];
        
        int index1 = 0, index2 = 0;
        List<int[]> list = new ArrayList<>();
        while (index1 < firstList.length && index2 < secondList.length) {
            
            int start = Math.max(firstList[index1][0], secondList[index2][0]);
            int end = Math.min(firstList[index1][1], secondList[index2][1]);
            if(start <= end){
                list.add(new int[]{start,end});    
            }
            if(firstList[index1][1] < secondList[index2][1]){
                index1++;
            }
            else{ index2 ++;}
        }
        return list.toArray(new int[list.size()][]);
    }
}