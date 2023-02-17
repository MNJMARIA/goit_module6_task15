package task15_module6;

public class TargetFinder {
    public int[] findTarget(int[] aiCoords, int[][] targets)
    {
        int[] result = new int[2];
        int sum = 0;
        int k = 0;
        int [][] temp = new int [targets.length][3];
        for(int i = 0; i < targets.length; i++)
        {
            for(int j = 0; j < targets[j].length; j++)
            {
                temp[i][j] = targets[i][j];
                sum = sum + targets[i][j];
                k++;
                if(k==2)
                {
                    temp[i][2] = sum;
                    sum = 0;
                    k = 0;
                }
            }
        }
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if(i==2)
            {
                if(temp[j][i] < temp[j+1][i] && temp[j][i] <temp[j+2][i])
                {
                    result[0] = temp[j][0];
                    result[1] = temp[j][1];
                }
                if(temp[j+1][i] < temp[j][i] && temp[j+1][i] <temp[j+2][i])
                {
                    result[0] = temp[j+1][0];
                    result[1] = temp[j+1][1];
                }
                if(temp[j+2][i] < temp[j+1][i] && temp[j+2][i] <temp[j][i])
                {
                    result[0] = temp[j+2][0];
                    result[1] = temp[j+2][1];
                }
            }
        }

        return result;
    }
}
