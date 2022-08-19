## 题目
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。

示例 1：

输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
输出：[-1,3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
示例 2：

输入：nums1 = [2,4], nums2 = [1,2,3,4].
输出：[3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 

提示：

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
nums1和nums2中所有整数 互不相同
nums1 中的所有整数同样出现在 nums2 中

## 代码

```js
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function(nums1, nums2) {
    let stack = [];
    let res = Array.from(Array(nums1.length),() => -1);
    if(nums1.length === 0) return res;
    // 存储nums2中元素在nums1中的索引
    // { [nums2中的元素] : nums1中的索引，没有则是-1}
    let map = {};
    for(let i = 0; i < nums2.length; i++){
        map[nums2[i]] = nums1.findIndex(item=>item === nums2[i]);
    }
    function getTop(){
        return stack[stack.length - 1];
    }
    for(let i = 0; i < nums2.length; i++){
        // 如果当前值大于当前顶部元素的值，那么顶部元素的下一个最大值就是当前元素
        // 需要更新stack中信息，弹出小于当前元素的值
        while(stack.length > 0 && nums2[i] > getTop()){
            const top = getTop();
            // 如果top值存在于nums1中
            if(map[top] !== -1){
                // top值在nums2中的下一个最大值就是当前值
                res[map[top]] = nums2[i];
            }
            stack.pop();
        }
        stack.push(nums2[i]);
    }
    return res;
};
```
