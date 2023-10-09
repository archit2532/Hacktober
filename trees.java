import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class trees {

  public static class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }

    public static Node buildTree() {
      int data;
      System.out.println("Enter the data: ");
      Scanner sc = new Scanner(System.in);
      data = sc.nextInt();

      if (data == -1) {
        return null;
      }

      Node root = new Node(data);

      System.out.println("Enter the data for left part of " + data);
      root.left = buildTree();

      System.out.println("Enter the data for right part of " + data);
      root.right = buildTree();

      return root;
    }
  }

  public static void levelOrderTraversal(Node root) {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
      Node temp = q.peek();

      q.remove();

      if (temp == null) {
        System.out.println();
        if (!q.isEmpty()) {
          q.add(null);
        }
      } else {
        System.out.print(temp.data + " ");

        if (temp.left != null) {
          q.add(temp.left);
        }

        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
  }

  public static void main(String[] args) {
    Node root = null;
    root = Node.buildTree();
    levelOrderTraversal(root);
  }
}
