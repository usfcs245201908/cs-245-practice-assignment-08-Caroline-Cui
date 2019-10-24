public class BST<T>
{
    Node root;
    public void insert(Comparable token)
    {
        root = insertNode(token, root);
    }
    private Node insertNode(Comparable item, Node node)
    {
        if (node == null)
        {
            return new Node(item);
        }
        if (item.compareTo(node.data) == 0)
        {
            node.count++;
        }
        if (item.compareTo(node.data)>0)
        {
            node.right = insertNode(item, node.right);
        }
        else
        {
            node.left = insertNode(item, node.left);
        }
        return node;
    }

    public boolean find(Comparable item)
    {
        return findNode(root, item);
    }

    private boolean findNode(Node node, Comparable item)
    {
        if (node == null)
        {
            return false;
        }
        if (item.compareTo(node.data) == 0)
        {
            return true;
        }
        if ( item.compareTo(node.data) > 0)
        {
            return findNode(node.right, item);
        }
        else
        {
           return findNode(node.left, item);
        }
    }

    public void delete(Comparable item)
    {

        root = delete(root, item);
    }

    private Comparable findLeft(Node node)
    {
//        Node temp = node.right;
        if (node.left.left == null)
        {
            Comparable temp = node.left.data;
            node.left = node.left.right;
            return temp;
        }
        else return findLeft(node.left);
    }

    private Node delete(Node node, Comparable item)
    {
        if (node == null) return null;
        if (node.data.compareTo(item) == 0)
        {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            if (node.right.left == null)
            {
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            }
            else node.data = findLeft(node.right);
        }
        else if (node.data.compareTo(item)> 0)
        {
            node.left = delete(node.left, item);
            return node;
        }
        else
        {
            node.right = delete(node.right, item);
        }
        return node;
    }

    private void printNode(Node node)
    {
        if (node != null){
            printNode(node.left);
            System.out.println(node.data);
            printNode(node.right);
        }
    }

    public void print()
    {
        printNode(root);
    }
}
