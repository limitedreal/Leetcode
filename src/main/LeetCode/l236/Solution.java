package main.LeetCode.l236;


public class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findRoad(root,p,q);
        return result;
    }

    public boolean findRoad(TreeNode now, TreeNode p, TreeNode q) {
        if(now==null){
            return false;
        }
        if(result!=null){
            return true;
        }
        boolean left = findRoad(now.left, p, q), right = findRoad(now.right, p, q);
        if(left && right
                || ((now == p || now == q) && (left || right))){
            if(result==null){
                result=now;
            }
            return true;
        }
        return left || right || (now == p || now == q);
    }


    //public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //    List<TreeNode> pList = findRoad(root,p)
    //            ,qList= findRoad(root,q);
    //    TreeNode result = root;
    //    Iterator<TreeNode> pIter = pList.iterator(),
    //            qIter = qList.iterator();
    //    while (pIter.hasNext()&&qIter.hasNext()){
    //        TreeNode pNext = pIter.next()
    //                ,qNext = qIter.next();
    //        if(pNext!=qNext){
    //            return result;
    //        }else{
    //            result = pNext;
    //        }
    //    }
    //    return result;
    //}
    //public List<TreeNode> findRoad(TreeNode now,TreeNode target){
    //    if(now==target){
    //        List<TreeNode> result = new LinkedList<>();
    //        result.add(0,now);
    //        return result;
    //    }if(now==null){
    //        return null;
    //    }
    //    List<TreeNode> left = findRoad(now.left,target)
    //            ,right = findRoad(now.right,target)
    //            ,result = left!=null?left:right;
    //    if(result==null){
    //        return result;
    //    }
    //    result.add(0,now);
    //    return result;
    //
    //}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

