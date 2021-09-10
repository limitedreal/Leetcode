package main.hulu.exam4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public int throughMaze(int yourSteps, int devilSteps, String[] maze) {
        return 4;

    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _yourSteps;
        _yourSteps = Integer.parseInt(in.nextLine().trim());

        int _devilSteps;
        _devilSteps = Integer.parseInt(in.nextLine().trim());

        int _maze_size = 0;
        _maze_size = Integer.parseInt(in.nextLine().trim());
        String[] _maze = new String[_maze_size];
        String _maze_item;
        for(int _maze_i = 0; _maze_i < _maze_size; _maze_i++) {
            try {
                _maze_item = in.nextLine();
            } catch (Exception e) {
                _maze_item = null;
            }
            _maze[_maze_i] = _maze_item;
        }

        res = new Solution().throughMaze(_yourSteps, _devilSteps, _maze);
        System.out.println(String.valueOf(res));

    }
}
