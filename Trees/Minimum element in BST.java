int minValue(Node node)
    {
        while(node.left!=null)
        {
            node=node.left;
        }
        return node.data;
    }