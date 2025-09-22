/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int val=0,res=0;
    public int kthSmallest(TreeNode root, int k) {
        getAns(root,k);
        return res;
    }
    public void getAns(TreeNode cur,int k)
    {
        if(cur==null)
            return;
        getAns(cur.left,k);
        val++;
        if(val==k)
        {
            res=cur.val;
            return;
        }
        getAns(cur.right,k);
    }
}
