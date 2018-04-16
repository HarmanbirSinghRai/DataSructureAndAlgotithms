package BinaryTreeSearchNonSearch;

public class HeightDepth_WidthOfBST {

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(34, 'A');
		bst.insert(64, 'R');
		bst.insert(23, 'Y');
		bst.insert(71, 'E');
		bst.insert(30, 'H');
		bst.insert(33, 'O');
		bst.insert(20, 'W');
		bst.insert(22, 'Q');
		bst.insert(19, 'N');
		bst.insert(66, 'N');
		bst.insert(76, 'D');
		bst.insert(65, 'R');
		bst.insert(85, 'T');
		
		  int height=maxDepth(bst.root); 
		  System.out.println("height of BST  " + height);
		  int width=getMaxWidth(bst.root); 
		  System.out.println("width of bst  " + width);



	}
	
	static int maxDepth(Node node) 
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.leftNode);
            int rDepth = maxDepth(node.rightNode);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
	
	static int getMaxWidth(Node node) 
    {
        int maxWidth = 0;
        int width;
        int h = height(node);
        int i;
  
        /* Get width of each level and compare 
           the width with maximum width so far */
        for (i = 1; i <= h; i++) 
        {
            width = getWidth(node, i);
            if (width > maxWidth)
                maxWidth = width;
        }
  
        return maxWidth;
    }
  
    /* Get width of a given level */
    static int getWidth(Node node, int level) 
    {
        if (node == null)
            return 0;
  
        if (level == 1)
            return 1;
        else if (level > 1)
            return getWidth(node.leftNode, level - 1)
                    + getWidth(node.rightNode, level - 1);
        return 0;
    }
  
    /* UTILITY FUNCTIONS */
     
    /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node.*/
    static int height(Node node) 
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the height of each subtree */
            int lHeight = height(node.leftNode);
            int rHeight = height(node.rightNode);
              
            /* use the larger one */
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }
	
}
