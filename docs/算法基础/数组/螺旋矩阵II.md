# 螺旋矩阵II

[力扣题目链接](https://leetcode-cn.com/problems/spiral-matrix-ii/)

给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]

- 模拟输出：
```js
var generateMatrix = function(n) {
    let res = [];
    for(let i = 0; i < n; i++){
        res[i] = [];
    }
    let l = 0,r = n - 1,t = 0, b = n - 1;
    let j = 1;
    while(j <= n*n){
        for(let i = l; i <= r; i++){
            res[t][i] = j++;
        }
        t++;
        for(let i = t; i <= b; i++){
            res[i][r] = j++;
        }
        r--;
        for(let i = r; i >= l; i--){
            res[b][i] = j++;
        }
        b--;
        for(let i = b;i >= t;i--){
            res[i][l] = j++;
        }
        l++;
    }
    return res;
};
```