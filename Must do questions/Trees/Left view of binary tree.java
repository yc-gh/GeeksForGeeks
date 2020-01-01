// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

/*

ALGORITHM

Given a Binary Tree, print Left view of it. 
Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. 
The task is to complete the function leftView(), which accepts root of the tree as argument.

1. Use a queue for level order traversal starting from root
2. For each level, print first element

*/

class Tree
{
    void leftView(Node root)
    {
        StringBuilder sb = new StringBuilder();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
          int size = queue.size();
          sb.append(queue.peek().data+" ");
          while(size-->0)
          {
            Node curr = queue.poll();
            if(curr.left!=null) queue.offer(curr.left);
            if(curr.right!=null) queue.offer(curr.right);
          }
        }
        System.out.print(sb);
    }
}
