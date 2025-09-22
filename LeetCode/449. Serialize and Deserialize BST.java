
public class Codec {
	String data;
	int k = 0;

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(sb, root);
		return sb.toString();
	}

	private void serialize(StringBuilder sb, TreeNode cur) {
		if (cur == null) {
			sb.append("n");
			return;
		} else
			sb.append(cur.val + " ");
		serialize(sb, cur.left);
		serialize(sb, cur.right);
	}

	public TreeNode deserialize(String data) {
		this.data = data;
		if (data.charAt(0) == 'n')
			return null;
		TreeNode root = new TreeNode(getInt());
		deserialize(root);
		return root;
	}

	private void deserialize(TreeNode root) {
		if (k < data.length() && data.charAt(k) != 'n') {
			root.left = new TreeNode(getInt());
			deserialize(root.left);
		} else
			k++;
		if (k < data.length() && data.charAt(k) != 'n') {
			root.right = new TreeNode(getInt());
			deserialize(root.right);
		} else
			k++;
	}

	public int getInt() {
		String first = "";
		int i;
		for (i = k; i < data.length(); i++)
			if (data.charAt(i) == ' ')
				break;
			else
				first += data.charAt(i);
		k = i + 1;
		return Integer.parseInt(first);
	}
}
