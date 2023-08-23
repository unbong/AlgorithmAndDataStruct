package neetcode150.twopoint;

import java.util.Queue;
import java.util.Stack;

public class TrappingRainWater_42 {

    /**
     * todo 晚上再仔细想
     * @param height
     * @return
     */
    public int trap(int[] height)
    {
        int maxLeft= height[0];
        int maxRight = height[height.length-1];
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left<right){
            int currentHeight= Integer.min(maxLeft, maxRight);

            int area = currentHeight - height[left];
            if(area>0) res+=area;

            if(height[left] <= height[right]){
                if(maxLeft<height[left])
                    maxLeft = height[left];
                left++;
            }
            else{
                if(maxRight < height[right])
                    maxRight=height[right];
                right--;
            }
        }
        return  res;
    }
    /**
     * 下列代码使用的思路为确定做边的指针后，去确定右边的指针。
     *   左指针是从索引最左边开始
     *   从左指针开始的有指针的确定方法如下
     *      首先去寻找比左指针大的或相等的索引，如果找到，使用左或右中较小的索引减去-左和右中间的高度
     *      如果没有找到比左指针大或相等的右指针，则去寻找左指针的右侧中高度最高的指针位置
     *          确定下来最高的位置后，遍历夹在左和右之间的项目使用左或右中较小的索引减去-左和右中间的高度
     *
     * @param height
     * @return
     */
//    public int trap(int[] height) {
//
//
//
//
//        int left= 0;
//        int right = 1;
//        int res = 0;
//
//
//        while(left < height.length-1)
//        {
//            // 去寻找大与等于左边的项目
//            boolean isFinded = false;
//            while(right<height.length)
//            {
//                if(height[left] <= height[right])
//                {
//                    isFinded = true;
//                    break;
//                }
//                right++;
//            }
//
//            if(isFinded){
//                for(int i = left+1; i <right;i++)
//                {
//                    int he = Integer.min(height[left], height[right]) - height[i];
//                    res += he;
//                }
//                left = right;
//                right++;
//            }
//            else{
//                // 去查找右边中比当前的小的当中最高的
//                int tmpRight= left+1;
//                int tmpMaxIndex = tmpRight;
//                int tmpMaxHeight = height[tmpRight];
//                while(tmpRight < height.length)
//                {
//                    if(tmpMaxHeight < height[tmpRight]){
//                        tmpMaxIndex = tmpRight;
//                        tmpMaxHeight = height[tmpRight];
//                    }
//                    tmpRight++;
//
//                }
//                right = tmpMaxIndex;
//                //if(tmpRight == height.length) right = tmpRight-1;
//
//                for(int i = left+1; i <right;i++)
//                {
//                    int he = Integer.min(height[left], height[right]) - height[i];
//                    if(he<0) continue;
//                    res += he;
//                }
//
//                left =right;
//                right = left+1;
//            }
//
//        }
//
//        return  res;
//    }
}
