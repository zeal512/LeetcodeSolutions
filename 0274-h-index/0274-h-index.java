class Solution {
    public int hIndex(int[] citations) {

/*         int arrSize = citations.length;
        int ans = 0;
        for(int i =0 ; i <=arrSize; i++){
            int papers = 0;
            for(int k =0; k< arrSize; k++){
                if(citations[k] >= i) papers++;
                if(papers >= i){
                    ans = Math.max(ans, i);
                    break;
                }
            }
        }
        return ans; */
        int n = citations.length;
        int[] numberOfPapers = new int[n+1];
        Arrays.fill(numberOfPapers, 0);
        for(int c : citations){
            numberOfPapers[Math.min(c,n)] += 1;
        }
        int h = n;
        int papers = numberOfPapers[n];
        while(papers < h){
            h-=1;
            papers += numberOfPapers[h];
        }
        return h;
    }
}
