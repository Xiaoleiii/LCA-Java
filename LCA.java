public class LCA {

    //node class
    static class Node { 
        int val; 
        Node right, left; 
   
        Node(int val) { 
            this.val = val; 
            right = left = null; 
        }    
    }

    //Binary tree class
    public static class BST {
        Node root;

        //Binary tree constructor
        BST() {
            root = null;
        }

        public boolean isEmpty(){
            return root == null;
        }
    
        Node getNode(int val){
            return getNode(root, val);
        }
    
        Node getNode(Node root, int val){
            if(root == null){
                return null;
            }
            else if(root.val == val){
                return root;
            }

            Node left = getNode(root.left, val);
            Node right = getNode(root.right, val);
            
            if(left.val == val){
                return left;
            }
            return right;
        }

        Node LCA(Node root, Node p, Node q){
            if(root == null || root == p || root == q){
                return root;
            }
    
            Node left = LCA(root.left, p, q);
            Node right = LCA(root.right, p, q);
    
            if(left == null){
                return right;
            }
            else if(right == null){
                return left;
            }
            else {
                return root;
            }
        }
    }
}