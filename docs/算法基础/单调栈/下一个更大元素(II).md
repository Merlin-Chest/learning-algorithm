## 题目
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。

 

示例 1:

输入: nums = [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
示例 2:

输入: nums = [1,2,3,4,3]
输出: [2,3,4,-1,4]
 

提示:

1 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9

## 代码

```js
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function(nums) {
    let res = Array.from(Array(nums.length), () => -1);
    if(nums.length === 0) return res;
    let stack = [];
    const getTop = () => stack[stack.length - 1];
    // 因为是循环数组,在遍历的过程中模拟走了两边nums
    // index = 0: 1,2,1,1,2,1
    // index = 1: stack = [0]
    // index = 2: res[0] = nums[1] = 2, stack = [1]
    // index = 3: stack = [1, 2]
    // index = 4: stack = [1, 2, 0]
    //            res[0] = nums[1] = 2, stack = [1, 2]
    //            res[2] = nums[1] = 2, stack = [1, 2]
    //            stack = [1, 1]
    // index = 5: stack = [1, 1, 2]
    for(let i = 0; i < nums.length * 2; i++){
        while(stack.length > 0 && nums[i % nums.length] > nums[getTop()]){
            res[getTop()] = nums[i % nums.length];
            stack.pop();
        }
        stack.push(i % nums.length);
    }
    return res;
};
```
