package Week9;

public class LinkedBST <T extends Comparable<T>>
{
    private class Node
    {
        T data;
        Node left;
        Node right;
        public Node(T adata)
        {
            data = adata;
            left =right  =null;
        }
    }

    private Node root;
    public LinkedBST()
    {
        root = null;
    }

    public void add(T adata)
    {
        if (root==null)
            root = new Node(adata);
        else
            add(root, adata);
    }
    private Node add(Node aNode, T aData)
    {
        if(aNode == null)
            aNode = new Node(aData);
        
        else if (aData.compareTo(aNode.data) <0)
        {
            aNode.left = add(aNode.left, aData);
        }
        else if (aData.compareTo(aNode.data) >0)
            aNode.right = add(aNode.right, aData);
        return aNode;
    }

    public void printPreorder()
    {
        printPreorder(root);
    }

    private void printPreorder(Node aNode)
    {
        if(aNode == null)  
            return;
        System.out.println(aNode.data);
        printPreorder(aNode.left);
        printPreorder(aNode.right);
    }

    public void printInOrder()
    {
        printInOrder(root);
    }
    private void printInOrder(Node aNode)
    {
        if(aNode ==null)
            return;
        printInOrder(aNode.left);
        System.out.println(aNode.data);
        printInOrder(aNode.right);

    }

    public boolean search(T aData)
    {
        return search(root, aData);
    }
    private boolean search(Node aNode, T aData)
    {
        if(aNode==null)
            return false;
        else if (aData.compareTo(aNode.data)<0)
            return search(aNode.left, aData);
        else if (aData.compareTo(aNode.data)>0)
            return search(aNode.right,aData);
        else
            return true;
    }

    public void remove(T adata)
    {
        root = remove(root, adata);
    }
    private Node remove(Node aNode, T aData)
    {
        //Find node
        if(aNode == null)
            return null;
        else if(aData.compareTo(aNode.data)<0)
            aNode.left = remove(aNode.left,aData);
        else if(aData.compareTo(aNode.data)>0)
            aNode.right = remove(aNode.right,aData);
        else
        {
            if(aNode.right==null)
                return aNode.left;
            else if(aNode.left==null)
                return aNode.right;
            //find smallest
            Node temp = findMinInTree(aNode.right);
            aNode.data = temp.data;
            aNode.right = remove(aNode.right, temp.data);


        }
        return aNode;
    }

    private Node findMinInTree(Node aNode)
    {
        if(aNode == null)
            return null;
        else if(aNode.left == null)
            return aNode;
        else
            return findMinInTree(aNode.left);
    }

    public T goRight()
    {
        Node temp = root;
        while (temp.right != null)
            temp = temp.right;
        return temp.data;
    }

    
}
