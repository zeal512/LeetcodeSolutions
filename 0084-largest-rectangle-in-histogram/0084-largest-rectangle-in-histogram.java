class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        /* for (int i = 0; i < heights.length; i++) {
            int left =i-1, right = i+1;
            while (left >=0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < heights.length && heights[right] >= heights[i] ) {
                right++;
            }
            left++; 
            right--;
            width = right - left +1;
            area = Math.max(area, width * heights[i]);
            System.out.println(area);
        }
        return area; */
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()] ) {
                int currIndex = stack.pop();
                int prevIndex = stack.isEmpty()?-1:stack.peek();
                area = Math.max(area, (heights[currIndex] * (i - prevIndex -1)) );
            }
            stack.push(i);
        }
        int nextSmaller = heights.length;
        while (!stack.isEmpty()) {
            int currIndex = stack.pop();
            int prevIndex = stack.isEmpty()?-1:stack.peek();
            area = Math.max(area, heights[currIndex] * (nextSmaller - prevIndex -1) );
        }

        return area;



    }
}