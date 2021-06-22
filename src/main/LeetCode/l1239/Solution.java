package main.LeetCode.l1239;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int result = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) {
                    // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    //这个位运算其实很好理解，因为ch只有0-25，所以把mask右移ch位正好吧第ch位的移动到了最右边，与1做合取
                    //如果ch位有，则说明有重复了。
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
                // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return result;
    }

    public void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            result = Math.max(result, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) {
            // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }
}
