package tes.semarang.satelite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Satellite {
	int preIndex = 0;

	public Satellite() {
	}

	public Tree treeFromTraversals(List<Character> preorder, List<Character> inorder) {
		int lenin = inorder.size();
		int lenpre = preorder.size();
		
		Character[] in = inorder.toArray(new Character[lenin]);
		Character[] pre = preorder.toArray(new Character[lenpre]);
		
		char[] inp = Arrays.stream(in).map(ch -> ch.toString()).collect(Collectors.joining()).toCharArray();
		char[] prep = Arrays.stream(pre).map(ch -> ch.toString()).collect(Collectors.joining()).toCharArray();
		
		Node root = buildTree(inp, prep, 0, lenin - 1);
		Tree tree = new Tree(root);
		
		return tree;
	}
	
	Node buildTree(char in[], char pre[], int inStrt, int inEnd) {
		if (inStrt > inEnd)
			return null;

		Node tNode = new Node(pre[preIndex++]);

		if (inStrt == inEnd)
			return tNode;

		int inIndex = search(in, inStrt, inEnd, tNode.value);

		tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

		return tNode;
	}

	int search(char arr[], int strt, int end, char value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}
}
