class Pair{
    int i,j,k;
    Pair(int i, int j, int k){
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        List<Pair> pairs = new ArrayList<>();
        for(int i=0; i< arr.length-2; i++){
            for(int j=i+1; j< arr.length-1; j++){
                for(int k=j+1; k< arr.length; k++){
                    if(Math.abs(arr[i] - arr[j])<= a && Math.abs(arr[j] - arr[k]) <=b &&
                       Math.abs(arr[i] - arr[k]) <=c){
                        pairs.add(new Pair(i,j,k));
                       }
                }
            }
        }
        return pairs.size();
    }
}