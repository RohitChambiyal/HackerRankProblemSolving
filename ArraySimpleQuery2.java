package Data_Structure;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArraySimpleQuery2 {

   
	private Node root = null;

	private Random random = new Random();

	static class Node {
		private long key;
		private int priority;
		Node left;
		Node right;
		private int count;

		Node(long key, int priority) {
			this.key = key;
			this.priority = priority;
			this.count = 1;
		}

		public String toString() {
			return "key : " + key + "\n priority : " + priority + "\nCount : "
					+ count;
		}

		static int selfCount(Node node) {
			return node != null ? node.count : 0;
		}

		void updateCount() {
			count = selfCount(this.left) + selfCount(this.right) + 1;
		}

		long Kth(int k) {
			if (k == selfCount(left)) {
				return key;
			} else if (k < selfCount(left)) {
				return left.Kth(k);
			} else {
				return right.Kth(k - selfCount(left) - 1);
			}
		}
	}

	Node merge(Node node_1, Node node_2) {
		if (node_1 == null || node_2 == null) {
			return node_1 != null ? node_1 : node_2;
		} else if (node_1.priority > node_2.priority) {
			node_1.right = merge(node_1.right, node_2);
			node_1.updateCount();
			return node_1;
		} else {
			node_2.left = merge(node_1, node_2.left);
			node_2.updateCount();
			return node_2;
		}
	}

	Tuple<Node> split(Node node, int count) {
		if (node == null) {
			return new Tuple<Node>(null, null);
		} else if ((Node.selfCount(node.left) + 1) <= count) {

			Tuple<Node> tupleRight = split(node.right,
					count - Node.selfCount(node.left) - 1);
			node.right = tupleRight.node_1;
			node.updateCount();
			return new Tuple<Node>(node, tupleRight.node_2);
		} else {
			Tuple<Node> spliting_left_result = split(node.left, count);
			node.left = spliting_left_result.node_2;
			node.updateCount();
			return new Tuple<Node>(spliting_left_result.node_1, node);
		}
	}

	public void traverse(Node node) {
		if (node != null) {
			traverse(node.left);
			System.out.print(node.key + " ");
			traverse(node.right);
		}
	}

	void insert(long key, int position) {
		Tuple<Node> tuple = split(root, position);
		Node new_node = new Node(key, random.nextInt());
		root = merge(tuple.node_1, merge(new_node, tuple.node_2));
	}

	public static void main(String[] args) {
		ArraySimpleQuery2 treapImplicitKeys = new ArraySimpleQuery2();
		Scanner in = null;
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			// System.out.println("Enter Configuration : ");
			String length = bufferedReader.readLine();
			String[] lens = length.split(" ");
			// System.out.println("Enter Array : ");
			String str = bufferedReader.readLine();
			String[] strs = str.split(" ");

			long[] num = new long[strs.length];
			int index = 0;
			for (String number : strs) {
				num[index] = Long.parseLong(number);
				index++;
			}

			treapImplicitKeys.createTreap(num);
		//	 System.out.println("Enter Rearranging Positions : ");
			for (int i = 0; i < Integer.parseInt(lens[1]); i++) {
				String rearrangeInputs = bufferedReader.readLine();
				String[] rearrangeInputsSplit = rearrangeInputs.split(" ");
				int position = Integer.parseInt(rearrangeInputsSplit[0]);
				int start = Integer.parseInt(rearrangeInputsSplit[1]);
				int end = Integer.parseInt(rearrangeInputsSplit[2]);
				treapImplicitKeys.root = treapImplicitKeys.arrange(position,
						start, end);

			}

			System.out
					.println(Math.abs(treapImplicitKeys
							.smallestKey(treapImplicitKeys.root).key
							- treapImplicitKeys
									.largestKey(treapImplicitKeys.root).key));

			treapImplicitKeys.traverse(treapImplicitKeys.root);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (in != null) {
				in.close();
			}
		}

	}

	public Node smallestKey(Node node) {
		if (node.left == null) {
			return node;
		} else {
			return smallestKey(node.left);
		}
	}

	public Node largestKey(Node node) {
		if (node.right == null) {
			return node;
		} else {
			return largestKey(node.right);
		}
	}

	public void createTreap(long[] arr) {
		for (int index = 0; index < arr.length; index++)
			insert(arr[index], index + 1);
	}

	public Node arrange(int position, int start, int end) {
		Tuple<Node> splits = split(root, start - 1);
		Tuple<Node> secondSplits = split(splits.node_2, end - (start - 1));
		if (position == 1) {
			return merge(secondSplits.node_1,
					merge(splits.node_1, secondSplits.node_2));
		} else {
			return merge(merge(splits.node_1, secondSplits.node_2),
					secondSplits.node_1);
		}

	}

	static class Tuple<Node> {
		Node node_1;
		Node node_2;

		public Tuple(Node node1, Node node2) {
			// TODO Auto-generated constructor stub
			this.node_1 = node1;
			this.node_2 = node2;

		}

		public String toString() {
			return "Node_1 : " + node_1 + "\n" + "Node_2 : " + node_2;
		}
	}


}