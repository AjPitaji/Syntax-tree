

class TreeNode {
    String val;
    TreeNode left, right;

    TreeNode(String value) {
        this.val = value;
        this.right = null;
        this.left = null;
    }

}

public class Syntax {
    public static int cal(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null) {
            return Integer.parseInt(node.val); // "5" -> 5
        }

        int leftvalue = cal(node.left);
        int rightvalue = cal(node.right);

        // leftvalue op rightvalue
        switch (node.val) {
            case "+":
                return leftvalue + rightvalue;
            case "-":
                return leftvalue - rightvalue;
            case "*":
                return leftvalue * rightvalue;
            case "/":
                if (rightvalue != 0)
                    return leftvalue / rightvalue;
                else
                    System.out.println("Error: Division by zero");

            default:
                throw new IllegalArgumentException("Invalid operator : " + node.val);
        }
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode("+");
        root.left = new TreeNode("3");
        root.right = new TreeNode("*");
        root.right.left = new TreeNode("5");
        root.right.right = new TreeNode("2");
        System.out.println(cal(root));
    }
}
