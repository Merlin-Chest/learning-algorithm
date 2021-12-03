package com.merlin.dynamic;

public class KnapsackProblem {

	public static void main(String[] args) {
		int[] w = { 1, 4, 3 }; // 物品的重量
		int[] val = { 1500, 3000, 2000 }; // 背包的价值
		int m = 4; // 背包的容量
		int n = val.length; // 物品的数量

		// 创建二维数组
		int[][] v = new int[n + 1][m + 1];
		int[][] path = new int[n + 1][m + 1];

		// 初始化第一行第一列
		for (int i = 0; i <= n; i++) {
			v[i][0] = 0;
		}
		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;
		}

		// 解题填表
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				// 因为我们的i是从1开始的，所以公式需要调整
				if (w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					if (v[i - 1][j] < v[i - 1][j - w[i - 1]] + val[i - 1]) {
						v[i][j] = v[i - 1][j - w[i - 1]] + val[i - 1];
						//把当前情况记录patch
						path[i][j] = 1;
					} else {

						v[i][j] = v[i - 1][j];

					}
				}
			}
		}
		System.out.printf("背包的最大价值为：%d\n",v[n][m]);
		int  i = path.length -1;
		int j = path[0].length -1;
		while(i>0 && j>0) {
			if(path[i][j] == 1) {
				System.out.printf("第%d个商品放入背包中\n", i);
				j -= w[i - 1];
			}
			i--;
		}
	}

}
