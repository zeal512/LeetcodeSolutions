class Solution {
    public String triangleType(int[] nums) {
        String equilateral = "equilateral", isosceles = "isosceles", scalene = "scalene", notPossible = "none";
        int side1 = nums[0] , side2 = nums[1], side3 = nums[2];
        
        if(side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2 ){
            if(side1 == side2 && side2 == side3 && side1 == side3) return equilateral;
            else if(side1 == side2 || side2 == side3 || side1 == side3) return isosceles;
            else if(side1 != side2 && side2 != side3 && side1 != side3) return scalene;
        }
        return notPossible;
    }
}