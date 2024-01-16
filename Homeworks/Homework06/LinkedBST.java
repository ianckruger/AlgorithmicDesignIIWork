package Homeworks.Homework06;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LinkedBST <Shape extends Comparable<Shape>>
{
    private class Node
    {
        Shape data;
        Node left;
        Node right;
        public Node(Shape adata)
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

    public void add(Shape adata)
    {
        if (root==null)
            root = new Node(adata);
        else
            add(root, adata);
    }
    private Node add(Node aNode, Shape aData)
    {
        if(aNode == null)
            aNode = new Node(aData);
        
        else if (aData.compareTo(aNode.data) <0)
            aNode.left = add(aNode.left, aData);
        else if (aData.compareTo(aNode.data) >0)
            aNode.right = add(aNode.right, aData);
        //do nothing if the shape is the same aka compare to is 0
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
        System.out.println(aNode.data.toString());
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
        System.out.println(aNode.data.toString());
        printInOrder(aNode.right);

    }

    public void printPostOrder()
    {
        printPostOrder(root);
    }

    private void printPostOrder(Node aNode)
    {
        if(aNode==null)
            return;
        printPostOrder(aNode.left);
        printPostOrder(aNode.right);
        System.out.println(aNode.data.toString());
    }

    public boolean search(Shape aData, String type)
    {
        return search(root, aData, type);
    }
    private boolean search(Node aNode, Shape aData, String type)
    {
        if(aNode==null)
            return false;
        else if (aData.compareTo(aNode.data)<0)
            return search(aNode.left, aData, type);
        else if (aData.compareTo(aNode.data)>0)
            return search(aNode.right,aData, type);
        else
            {
                boolean add = false;
                if(type.equalsIgnoreCase("Circle"))
                    if(aNode.data.getRadius() == aData.getRadius())
                        add = true;
                
                else if(type.equalsIgnoreCase("Rectangle"))
                    if(aNode.data.getWidth() == aData.getWidth()&& aNode.data.getLength() == aData.getLength())
                        add = true;
                
                else if(type.equalsIgnoreCase("Right Triangle"))
                    if(aNode.data.getHeight() == aData.getHeight()&& aNode.data.getBase() == aData.getBase())
                        add = true;
                if(add== true)
                    return true;
            }
            
    }

    public void remove(Shape adata, String type)
    {
        root = remove(root, adata, type);
    }

    private Node remove(Node aNode, Shape aData, String type)
    {
        //Find node
        if(aNode == null)
            return null;
        else if(aData.compareTo(aNode.data)<0)
            aNode.left = remove(aNode.left,aData, type);
        else if(aData.compareTo(aNode.data)>0)
            aNode.right = remove(aNode.right,aData,type);
        else
        {
            boolean add = false;
            if(type.equalsIgnoreCase("Circle"))
                if(aNode.data.getRadius() == aData.getRadius())
                    add = true;
            
            else if(type.equalsIgnoreCase("Rectangle"))
                if(aNode.data.getWidth() == aData.getWidth()&& aNode.data.getLength() == aData.getLength())
                    add = true;
            
            else if(type.equalsIgnoreCase("Right Triangle"))
                if(aNode.data.getHeight() == aData.getHeight()&& aNode.data.getBase() == aData.getBase())
                    add = true;

            if(add==true)
            {
                if(aNode.right==null)
                    return aNode.left;
                else if(aNode.left==null)
                    return aNode.right;
                //find smallest
                Node temp = findMinInTree(aNode.right);
                aNode.data = temp.data;
                aNode.right = remove(aNode.right, temp.data, type);
            }


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

    public double getMaxArea()
    {
        Node temp = root;
        while(temp.right != null)
            temp = temp.right;
        double area = temp.data.getArea();
        return area;
    }

    public void removeGreaterThanArea(double area)
    {
        root = removeGreaterThanArea(root, area);
    }

    private Node removeGreaterThanArea(Node aNode, double area)
    {
        if (aNode == null)
            return null;

        // If the area of the current node's shape is greater than the specified area, remove it
        if (aNode.data.getArea() > area) 
        {
            aNode = removeNode(aNode, aNode.data);
        }

        // Recursively remove nodes in the left and right subtrees
        aNode.left = removeGreaterThanArea(aNode.left, area);
        aNode.right = removeGreaterThanArea(aNode.right, area);

        return aNode;
    }

    private Node removeNode(Node aNode, Shape aData)
    {
        // Similar to your existing remove method, but without the check for type
        if (aNode == null)
            return null;
        else if (aData.compareTo(aNode.data) < 0)
            aNode.left = removeNode(aNode.left, aData);
        else if (aData.compareTo(aNode.data) > 0)
            aNode.right = removeNode(aNode.right, aData);
        else 
        {
            if (aNode.right == null)
                return aNode.left;
            else if (aNode.left == null)
                return aNode.right;

            // Find the smallest node in the right subtree
            Node temp = findMinInTree(aNode.right);
            aNode.data = temp.data;
            aNode.right = removeNode(aNode.right, temp.data);
        }

        return aNode;
    }


    public void printToFileWriter(String fileName)
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
            printToFileWriter(root, fileWriter);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void printToFileWriter(Node aNode, PrintWriter fileWriter)
    {
        if(aNode ==null)
            return;
        printToFileWriter(aNode.left,fileWriter);
        fileWriter.println(aNode.data.toString()+"\n");
        printToFileWriter(aNode.right,fileWriter);

    }


    
}