package main.AIHomeWork.FifteenPuzzle.BadAstar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static Board beginBoard = new Board(Init.BEGINARR);
    public static Board endBoard = new Board(Init.ENDARR);

    public static void main(String[] args) {

        OpenTable openTable = new OpenTable();
        openTable.tbArr.add(beginBoard);// 这里需要拷贝逻辑 否则复制的只是指针
        CloseTable closeTable = new CloseTable();

        System.out.println(openTable);
        Board curBoard = null;

        int count = 0;

        while (openTable.tbArr.size() != 0) {
            System.out.println("第" + ++count + "次拓展");
            openTable.sortItSelf();
            curBoard = openTable.getMinBoard();
            closeTable.tbArr.add(curBoard);

            // 是否为end
            if (curBoard.equals(endBoard)) {
                System.out.println("SUCCESS:" + curBoard);
                while (curBoard.parentBoard != null) {
                    System.out.println("上一步：");
                    System.out.println(curBoard.parentBoard);
                    curBoard = curBoard.parentBoard;
                }
                break;
            }
            // 4方向拓展
            for (int s = 0; s < 4; s++) {
                Board newBoard = null;
                if (s == 0) {
                    if (curBoard.canDown()) {
                        newBoard = curBoard.goDown();
                    } else {
                        continue;
                    }
                } else if (s == 1) {
                    if (curBoard.canUp()) {
                        newBoard = curBoard.goUp();
                    } else {
                        continue;
                    }
                } else if (s == 2) {
                    if (curBoard.canRight()) {
                        newBoard = curBoard.goRight();
                    } else {
                        continue;
                    }
                } else if (s == 3) {
                    if (curBoard.canLeft()) {
                        newBoard = curBoard.goLeft();
                    } else {
                        continue;
                    }
                }

                if (openTable.hasBoard(newBoard)) {// 新节点在open表中 比较已有fn和新节点fn的大小
                    Board oldBoard = openTable.getBoardByArr(newBoard.arr);
                    if (newBoard.fn < oldBoard.fn) {// 新的比旧的fn小
                        // 更新指针
                        newBoard.childBoards = oldBoard.childBoards;
                        for (int i = 0; i < newBoard.childBoards.size(); i++) {
                            newBoard.childBoards.get(i).parentBoard = newBoard;
                        }
                        // 删旧的 增新的
                        openTable.tbArr.remove(openTable.getIndex(oldBoard));
                        openTable.tbArr.add(newBoard);
                        System.out.println("openTable:update");
                    }
                } else if (closeTable.hasBoard(newBoard)) {// 新节点在close表中
                    Board oldBoard = closeTable.getBoardByArr(newBoard.arr);
                    if (newBoard.fn < oldBoard.fn) {
                        newBoard.childBoards = oldBoard.childBoards;
                        for (int i = 0; i < newBoard.childBoards.size(); i++) {
                            newBoard.childBoards.get(i).parentBoard = newBoard;
                        }
                        closeTable.tbArr.remove(closeTable.getIndex(oldBoard));
//						closeTable.tbArr.add(newBoard);
                        openTable.tbArr.add(newBoard);// 重新放回open表中
                        System.out.println("openTable:update");
                    }
                } else {// 两表都不在
                    openTable.tbArr.add(newBoard);
                    System.out.println("openTable:add");
                }
            }
            openTable.tbArr.remove(openTable.getIndex(curBoard));
        }
    }
}
class Init {
    /**
     * 数组大小
     */
    public static final int SIZE = 4;
    /**
     * 初始状态
     */
    public static final int[][] BEGINARR = { { 5, 1, 2, 4 }, { 9, 6, 3, 8 }, { 13, 15, 10, 11 }, { 14, 0, 7, 12 } };
    /**
     * 目标状态
     */
    public static final int[][] ENDARR = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
}
class Utils {

    /**
     * 计算不在位的将牌个数
     * @return 不在位的将牌个数
     */
    public static int getAbsentCount(Board curBoard, Board endBoard) {
        // System.out.println(curBoard);
        // System.out.println(endBoard);
        int count = 0;
        for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                label: for (int m = 0; m < Init.SIZE; m++) {
                    for (int n = 0; n < Init.SIZE; n++) {
                        if (curBoard.arr[i][j] == endBoard.arr[m][n]) {
                            count += getDistance(i, j, m, n);
                            break label;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 计算两坐标的矩形距离
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static int getDistance(int x1,int y1,int x2,int y2) {
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }

    /**
     * 计算不在位的将牌个数 重载
     * @param arr 15数码的一个状态
     * @return 不在位的将牌个数
     */
    public static int getAbsentCount(Board curBoard, int[][] arr) {
        // System.out.println(curBoard);
        // System.out.println(endBoard);
        int count = 0;
        for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (curBoard.arr[i][j] != 0 && curBoard.arr[i][j] != arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
class Board {
    /**
     * 将牌状态
     */
    public int[][] arr;

    /**
     * 总耗散值
     */
    public int fn=-1;

    /**
     * 当前已走深度(耗散值)
     */
    public int dn=0;

    /**
     * 不在位将牌个数(耗散值)
     */
    public int hn=-1;

    /**
     * 父节点
     */
    public Board parentBoard;

    /**
     * 子节点列表
     */
    public ArrayList<Board> childBoards=new ArrayList<Board>();

    public Board(int[][] arr) {
        super();
        this.arr = arr;
        this.dn = 0;
        this.hn = Utils.getAbsentCount(this, Init.ENDARR);
        this.fn = this.dn + this.hn;
    }

    public Board() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                sb.append(arr[i][j] + "\t");
            }
            sb.append("\n");
        }
        sb.append("fn gn hn = " + fn + " " + dn + " " + hn+"\n");
        return sb.toString();
    }

    /**
     * 复制本身arr数值
     * @return
     */
    public int[][] copySelfArr() {
        int[][] newArr = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }
    /**
     * 判断两个board是否arr值相等
     * @param board
     * @return
     */
    public boolean equals(Board board) {
        boolean isEqual = true;
        for (int i = 0; i < Init.SIZE && isEqual == true; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (arr[i][j] != board.arr[i][j]) {
                    isEqual = false;
                    break;
                }
            }
        }
        return isEqual;
    }

    /**
     * 重载，判断board和arr是否值相等
     * @param array
     * @return
     */
    public boolean equals(int[][] array) {
        boolean isEqual = true;
        for (int i = 0; i < Init.SIZE && isEqual == true; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (arr[i][j] != array[i][j]) {
                    isEqual = false;
                    break;
                }
            }
        }
        return isEqual;
    }

    /**
     * 是否可以向下移动
     * @return
     */
    public boolean canDown() {
        boolean isOK = true;
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (arr[i][j] == 0 && i == Init.SIZE-1) {
                    isOK = false;
                    break label;
                }
            }
        }
        System.out.println("canDown:"+isOK);
        return isOK;
    }

    /**
     * 是否可以向右移动
     * @return
     */
    public boolean canRight() {
        boolean isOK = true;
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (arr[i][j] == 0 && j == Init.SIZE-1) {
                    isOK = false;
                    break label;
                }
            }
        }
        System.out.println("canRight:"+isOK);
        return isOK;
    }
    /**
     * 是否可以向左移动
     * @return
     */
    public boolean canLeft() {
        boolean isOK = true;
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (arr[i][j] == 0 && j == 0) {
                    isOK = false;
                    break label;
                }
            }
        }
        System.out.println("canLeft:"+isOK);
        return isOK;
    }

    /**
     * 是否可以向上移动
     * @return
     */
    public boolean canUp() {
        boolean isOK = true;
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (arr[i][j] == 0 && i == 0) {
                    isOK = false;
                    break label;
                }
            }
        }
        System.out.println("canUp:" + isOK);
        return isOK;
    }


    /**
     * 向下移动
     * @return
     */
    public Board goDown() {
        System.out.println("Go Down");
        Board newBoard = new Board(this.copySelfArr());
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (newBoard.arr[i][j] == 0) {
                    int t;
                    t = newBoard.arr[i][j];
                    newBoard.arr[i][j] = newBoard.arr[i + 1][j];
                    newBoard.arr[i + 1][j] = t;
                    break label;// 这里label退出循环！！避免重复操作！！
                }
            }
        }
        newBoard.dn = this.dn + 1;// 深度
        newBoard.hn = Utils.getAbsentCount(newBoard, Main.endBoard);// 不在位将牌个数
        newBoard.fn = newBoard.dn + newBoard.hn;
        newBoard.parentBoard=this;
        this.childBoards.add(newBoard);
        return newBoard;
    }

    /**
     * 向上移动
     * @return
     */
    public Board goUp() {
        System.out.println("Go Up");
        Board newBoard = new Board(this.copySelfArr());//这里不能这样复制
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (newBoard.arr[i][j] == 0) {
                    int t;
                    t = newBoard.arr[i][j];
                    newBoard.arr[i][j] = newBoard.arr[i - 1][j];
                    newBoard.arr[i - 1][j] = t;
                    break label;
                }
            }
        }
        newBoard.dn = this.dn + 1;// 深度
        newBoard.hn = Utils.getAbsentCount(newBoard, Main.endBoard);// 不在位将牌个数
        newBoard.fn = newBoard.dn + newBoard.hn;
        newBoard.parentBoard = this;
        this.childBoards.add(newBoard);
        return newBoard;
    }


    /**
     * 向右移动
     * @return
     */
    public Board goRight() {
        System.out.println("Go Right");
        Board newBoard = new Board(this.copySelfArr());
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (newBoard.arr[i][j] == 0) {
                    int t;
                    t = newBoard.arr[i][j];
                    newBoard.arr[i][j] = newBoard.arr[i][j+1];
                    newBoard.arr[i][j+1] = t;
                    break label;
                }
            }
        }
        newBoard.dn = this.dn + 1;// 深度
        newBoard.hn = Utils.getAbsentCount(newBoard, Main.endBoard);// 不在位将牌个数
        newBoard.fn = newBoard.dn + newBoard.hn;
        newBoard.parentBoard=this;
        this.childBoards.add(newBoard);
        return newBoard;
    }

    /**
     * 向左移动
     * @return
     */
    public Board goLeft() {
        System.out.println("Go Left");
        Board newBoard = new Board(this.copySelfArr());
        label: for (int i = 0; i < Init.SIZE; i++) {
            for (int j = 0; j < Init.SIZE; j++) {
                if (newBoard.arr[i][j] == 0) {
                    int t;
                    t = newBoard.arr[i][j];
                    newBoard.arr[i][j] = newBoard.arr[i][j-1];
                    newBoard.arr[i][j-1] = t;
                    break label;
                }
            }
        }
        newBoard.dn = this.dn + 1;// 深度
        newBoard.hn = Utils.getAbsentCount(newBoard, Main.endBoard);// 不在位将牌个数
        newBoard.fn = newBoard.dn + newBoard.hn;
        newBoard.parentBoard=this;
        this.childBoards.add(newBoard);
        return newBoard;
    }
}
class OpenTable {
    public ArrayList<Board> tbArr = new ArrayList<Board>();

    /**
     * Open表排序
     */
    public void sortItSelf() {
        Collections.sort(tbArr, new Comparator<Board>() {
            @Override
            public int compare(Board b1, Board b2) {// 重写 Comparator 函数
                if (b1.fn < b2.fn)//小的排前面
                    return -1;
                else if (b1.fn > b2.fn)
                    return 1;
                else
                    return 0;
            }
        });
        System.out.println("Open表Board个数："+this.tbArr.size());
//		System.out.println("排序后：\n"+tbArr);
        System.out.println("最小fn="+tbArr.get(0));
        System.out.println("\n");
    }

    /**
     * 返回fn最小Board
     * @return
     */
    public Board getMinBoard() {
        return tbArr.get(0);
    }

    /**
     * 判断Table中是否包含某个board
     * @param board
     * @return
     */
    public boolean hasBoard(Board board) {
        boolean hasBoard = false;
        for (int i = 0; i < tbArr.size(); i++) {
            if (tbArr.get(i).equals(board)) {
                hasBoard = true;
                break;
            }
        }
        return hasBoard;
    }

    /**
     * 获取Board在OpenTable中的索引
     * @param board
     * @return 索引值
     */
    public int getIndex(Board board) {
        int index=-1;
        for (int i = 0; i < tbArr.size(); i++) {
            if (tbArr.get(i).equals(board)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Board getBoardByArr(int[][] array){
        for (int i = 0; i < tbArr.size(); i++) {
            if (tbArr.get(i).equals(array)) {
                return tbArr.get(i);
            }
        }
        try {
            throw new Exception("Opentable:不存在该arr!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("\n");
        sb.append("OpenTable:\n");
        for(int i=0;i<tbArr.size();i++) {
            sb.append(tbArr.get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
class CloseTable {
    ArrayList<Board> tbArr = new ArrayList<Board>();
    /**
     * 判断Table中是否包含某个board
     * @param board
     * @return
     */
    public boolean hasBoard(Board board) {
        boolean hasBoard = false;
        for (int i = 0; i < tbArr.size(); i++) {
            if (tbArr.get(i).equals(board)) {
                hasBoard = true;
                break;
            }
        }
        return hasBoard;
    }

    /**
     * 获取Board在CloseTable中的索引
     * @param board
     * @return 索引值
     */
    public int getIndex(Board board) {
        int index=-1;
        for (int i = 0; i < tbArr.size(); i++) {
            if (tbArr.get(i).equals(board)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Board getBoardByArr(int[][] array){
        for (int i = 0; i < tbArr.size(); i++) {
            if (tbArr.get(i).equals(array)) {
                return tbArr.get(i);
            }
        }
        try {
            throw new Exception("Closetable:不存在该arr!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

