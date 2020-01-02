// https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1

/* ALGORITHM 

1. Use two stacks 
2. For stack1 elements, push right and left children into stack2
3. For stack2 elements, push left and right children into stack1
4. For printing, print each element before handling its children

*/

class Spiral
{
      void printSpiral(Node node) 
      {
        StringBuilder sb = new StringBuilder();
        Deque<Node> stack1 = new ArrayDeque<>();
        Deque<Node> stack2 = new ArrayDeque<>();
        stack1.push(node);
        while(!stack1.isEmpty() || !stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                Node curr = stack1.pop();
                sb.append(curr.data+" ");
                if(curr.right!=null)
                {
                    stack2.push(curr.right);
                }
                if(curr.left!=null)
                {
                    stack2.push(curr.left);
                }
            }
            
            while(!stack2.isEmpty())
            {
                Node curr = stack2.pop();
                sb.append(curr.data+" ");
                if(curr.left!=null)
                {
                    stack1.push(curr.left);
                }
                if(curr.right!=null)
                {
                    stack1.push(curr.right);
                }
            }
        }
        
        System.out.print(sb);
      }
}