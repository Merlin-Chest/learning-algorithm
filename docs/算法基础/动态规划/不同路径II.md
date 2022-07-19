# 不同路径II

[力扣题目链接](https://leetcode.cn/problems/unique-paths-ii/)

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

![](https://img-blog.csdnimg.cn/20210111204901338.png)

网格中的障碍物和空位置分别用 1 和 0 来表示。

示例 1：

![](https://img-blog.csdnimg.cn/20210111204939971.png)

-   输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
-   输出：2 解释：
-   3x3 网格的正中间有一个障碍物。
-   从左上角到右下角一共有 2 条不同的路径：
    1.  向右 -> 向右 -> 向下 -> 向下
    2.  向下 -> 向下 -> 向右 -> 向右

示例 2：

![](https://img-blog.csdnimg.cn/20210111205857918.png)

-   输入：obstacleGrid = [[0,1],[0,0]]
-   输出：1

提示：

-   m == obstacleGrid.length
-   n == obstacleGrid[i].length
-   1 <= m, n <= 100
-   obstacleGrid\[i\]\[j\] 为 0 或 1

## 代码

```js
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    let dp = new Array(obstacleGrid.length).fill(new Array(obstacleGrid[0].length).fill(0));
    for(let i = 0; i < obstacleGrid.length; i++){
        for(let j = 0; j < obstacleGrid[0].length; j++){
	        // 当遇到障碍时，它不能作为起点到达其他的地方，所以要设置为0
            if(obstacleGrid[i][j] === 1){
                dp[i][j] = 0;
            }else if(i == 0 && j == 0){
                dp[i][j] = 1;
            }else if(i == 0){
                dp[i][j] = dp[i][j - 1];
            }else if(j == 0){
                dp[i][j] = dp[i - 1][j];
            }else{
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
    }
    return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
};
```
