package com.practice.problem.solving.array;

public class ContainerWithMostWater {

    public int maxWaterAreaContainer(int[] height){
        int maxArea = 0, currentArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while(leftIndex < rightIndex){
            currentArea = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex - leftIndex);
            maxArea = Math.max(currentArea, maxArea);

            if(height[leftIndex] < height[rightIndex]){
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] heights = {13, 18, 12, 8};
        System.out.println(containerWithMostWater.maxWaterAreaContainer(heights));
    }
}
