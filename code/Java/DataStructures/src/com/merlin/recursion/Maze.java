package com.merlin.recursion;

public class Maze {
    public static void main(String[] args) {
        //二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下两行
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右两列
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = map[3][2] = 1;
        showMap(map);

        //使用递归回溯法给小球找路
        setWay(map, 1, 1);

        //输出新的地图，小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的地图情况");
        showMap(map);
    }

    //使用递归回溯来给小球找路
    //说明
    //map表示地图
    //i，j表示从地图的某个点出发
    //如果小球能到达map[6][5]，则说明通路找到
    //约定：当map[i][j]为0，表示该点没有走过
    // 当为1，表示墙
    // 当为2，表示已经走过
    // 当为3，表示已经走过，但是走不通
    // 走迷宫时，需要确定一个策略（方法）：下 -> 右 -> 上 -> 左
    // 如果该点走不通，再回溯
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到，ok
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前这个点还没走过，按策略走
                map[i][j] = 2;//假定可以走通
                if (setWay(map, i + 1, j)) {
                    //向下走,能走通，返回true
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j] != 0 ,可能是1，2，3
                return false;
            }
        }
    }

    //打印map
    public static void showMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
