package main.LeetCode.l1600;

import java.util.*;

public class ThroneInheritance {
    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        List<String> inheritanceOrder = t.getInheritanceOrder();// 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        inheritanceOrder = t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }

    TreeNode king;
    Map<String, TreeNode> map = new HashMap<>();

    class TreeNode {
        TreeNode parent = null;
        List<TreeNode> childs = new ArrayList<>();
        String name;
        boolean live = true;

        public TreeNode(String name) {
            this.name = name;
        }
    }

    public ThroneInheritance(String kingName) {
        king = new TreeNode(kingName);
        map.put(kingName,king);
    }

    public void birth(String parentName, String childName) {
        TreeNode parent = null, child = new TreeNode(childName);
        if (map.containsKey(parentName)) {
            parent = map.get(parentName);
        } else {
            parent = new TreeNode(parentName);
            map.put(parentName, parent);
        }
        map.put(childName, child);
        parent.childs.add(child);
        child.parent = parent;
    }

    public void death(String name) {
        map.get(name).live = false;

    }

    public List<String> getInheritanceOrder() {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<String> result = new LinkedList<>();
        queue.add(king);
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            if (now.live) {
                result.add(now.name);
            }
            queue.addAll(0, now.childs);
        }
        return result;
    }
}
