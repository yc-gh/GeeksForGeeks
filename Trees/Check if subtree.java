//In main tree, check if current subtree matches; if not, check it's left and right subtrees

static boolean checkSubtree(Node T,Node S) {
    //If both reach null, identical
    if(T==null && S==null) return true;
    //If only one reaches null, not identical
    if(T==null || S==null) return false;
    return (T.data==S.data && checkSubtree(T.left,S.left) && checkSubtree(T.right,S.right));
}
public static boolean isSubtree(Node T, Node S) {
    //If S is null, true will be returned on first method call itself
    if(S==null) return true;
    //If S is not null but T has reached null
    if(T==null) return false;
    //For current nodes of T and S, check if these subtrees
    if(checkSubtree(T,S)==true) return true;
    //If current subtree doesn't match, check left and right subtrees
    return isSubtree(T.left,S) || isSubtree(T.right,S);
}