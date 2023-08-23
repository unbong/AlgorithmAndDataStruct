package neetcode150.binarysearch;

public class SearchA2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n  = matrix[0].length;  // column
        int m = matrix.length;      // row
        int left_x=0;
        int left_y =0;
        int right_x = matrix[0].length-1;
        int right_y = matrix.length-1;
        int mid_x;
        int mid_y;

        int left =0;
        int right = right_y*n+right_x;

        while(left<=right)
        {
            int index =(right_y*n+right_x)+(left_y*n + left_x);
            mid_x = ((index )/2)%n;
            mid_y = (index)/(2*n);

            if(matrix[mid_y][mid_x] < target)
            {
                left_x = mid_x+1;
                left_y = mid_y;
                if (left_x >= n) {
                    left_x -=n;
                    left_y++;
                }

            }
            else if(matrix[mid_y][mid_x] > target){
                right_x = mid_x-1;
                right_y = mid_y;
                if(right_x < 0)
                {
                    right_x+=n;
                    right_y--;
                }
            }
            else{

                return true;
            }

            left = left_y*n + left_x;
            right = right_y*n+right_x;
        }

        return false;
    }
}
