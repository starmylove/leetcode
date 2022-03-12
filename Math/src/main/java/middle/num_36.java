package middle;

import java.util.HashMap;
import java.util.Map;

public class num_36 {
    /*
    * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。
注意：
    一个有效的数独（部分已被填充）不一定是可解的。
    只需要根据以上规则，验证已经填入的数字是否有效即可。
    * */
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudokuBySunxh(char[][] board) {
        //初始化三个map数组
        Map<Integer,Integer>[] rows = new HashMap[9];
        Map<Integer,Integer>[] columns = new HashMap[9];
        Map<Integer,Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer,Integer>();
            columns[i] = new HashMap<Integer,Integer>();
            boxes[i] = new HashMap<Integer,Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if(board[i][j]!='.'){
                    int n = (int)board[i][j];
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i].put(n,rows[i].getOrDefault(n, 0)+1);
                    columns[j].put(n,columns[j].getOrDefault(n, 0)+1);
                    boxes[boxIndex].put(n,boxes[boxIndex].getOrDefault(n, 0)+1);
                    if(rows[i].get(n)>1||columns[j].get(n)>1||boxes[boxIndex].get(n)>1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
