import org.junit.Test;
import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void LCA() {

        // Empty Tree with null nodes
        BST tree = new BST();
        Node p = null;
        Node q = null;
        Node LCA = tree.LCA(p,q);
        assertNull(LCA);

        /*
            Case 1
                   3
                  / \
                 5   1
                /     \
               6       8
         */
        tree = new BST(3);
        p = new Node(5);
        q = new Node(1);
        tree.root.left = p;
        tree.root.right = q;
        tree.root.left.left = new Node(6);
        tree.root.right.right = new Node(8);
        LCA = tree.LCA(p,q);
        assertEquals(LCA, tree.root);

        /*
            Case 2
                   3
                  / \
                 5   1
                / \
               6   2
         */
        tree = new BST(3);
        p = new Node(6);
        q = new Node(2);
        tree.root.left = new Node(5);
        tree.root.right = new Node(1);
        tree.root.left.left = p;
        tree.root.left.right = q;
        LCA = tree.LCA(p,q);
        assertEquals(LCA, tree.root.left);

        /*
            Case 3
                   3
                  / \
                 5   1
                  \
                  2
                 /
                7
         */
        tree = new BST(3);
        p = new Node(7);
        q = new Node(1);
        tree.root.left = new Node(5);
        tree.root.right = q;
        tree.root.left.right = new Node(2);
        tree.root.left.right.left = p;
        LCA = tree.LCA(p,q);
        assertEquals(LCA, tree.root);
    }
}