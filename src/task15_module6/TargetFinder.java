package task15_module6;

import java.util.Arrays;

public class TargetFinder {
    public int[] findTarget(int[] aiCoords, int[][] targets)
    {
        int sumInAi = 0;
        int k = 0;
        int endOfCols = targets[1].length;
        int sum = 0;
        int[] sums = new int[targets.length];
        int[] result = new int[targets[1].length];
        for(int ai: aiCoords)
        {
            sumInAi = sumInAi + ai;
        }
        //System.out.println("Sum to compare with: " + sumInAi);
        for(int row = 0; row < targets.length; row++)
        {
            for(int col = 0; col < targets[1].length; col++)
            {
                sum = sum + targets[row][col];
                k++;
                if(k == endOfCols)
                {
                    sums[row] = sum;
                    sum = 0;
                    k = 0;
                }
            }
        }
        //System.out.println(Arrays.toString(sums));
        int minSum = Arrays.stream(sums).min().getAsInt();
        int indexOfMinSum = Arrays.stream(sums).min().getAsInt();
        //System.out.println("Min sum: " + minSum);
        for(int i = 0; i < sums.length; i++)
        {
            if(minSum == sums[i])
            {
                indexOfMinSum = i;
            }
        }
        //System.out.println("IndexOfMinSum: " + indexOfMinSum);
        for(int row = indexOfMinSum; row < targets.length; row++) // search sums to find min of sims
        {
            for(int col = 0; col < targets[1].length; col++)
            {
                if(row == indexOfMinSum)
                {
                    result[col] = targets[row][col];
                }
            }
        }
        return result;
    }
}
