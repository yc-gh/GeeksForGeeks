void printSpiral(Node node) 
      {
           if(node==null) return;
           //2 stacks used for alternate order printing of elements
           //Stack1 is used for right to left printing by pushing left and then right children of Stack2's popped element
           //Vice versa Stack2 prints right to left by pushing right then left children of Stack1's top
           Deque<Node> s1 = new ArrayDeque<>();
           Deque<Node> s2 = new ArrayDeque<>();
           StringBuilder output = new StringBuilder();
           s1.push(node);
           //Keep performing operations while either stack has elements
           while(!s1.isEmpty() || !s2.isEmpty())
           {
               //While stack1 is not empty, keep printing the top and push its' children (right,left) to stack2
               //So they can be printed in reverse order
               while(!s1.isEmpty())
               {
                   Node top = s1.pop();
                   output.append(top.data+" ");
                   if(top.right!=null) s2.push(top.right);
                   if(top.left!=null) s2.push(top.left);
               }
               //Vice versa for stack2
               while(!s2.isEmpty())
               {
                   Node top = s2.pop();
                   output.append(top.data+" ");
                   if(top.left!=null) s1.push(top.left);
                   if(top.right!=null) s1.push(top.right);
               }
           }
           System.out.print(output);
      }