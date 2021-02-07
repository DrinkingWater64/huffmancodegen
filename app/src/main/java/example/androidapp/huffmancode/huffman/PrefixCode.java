package example.androidapp.huffmancode.huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

import de.blox.graphview.Graph;
import de.blox.graphview.Node;

public class PrefixCode {
    public static Graph graph;

    HashMap<String, String> prefixCodes = new HashMap<>();

    public HuffmanTree createTree(int[] letterFrequency) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        ;
        for (int i = 0; i < letterFrequency.length; i++) {
            if (letterFrequency[i] > 0)
                trees.offer(new TreeLeaf(letterFrequency[i], (char) i));
        }

        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            trees.offer(new TreeNode(a, b));
        }
        return trees.poll();
    }

    public void printCode(Node parentNode,HuffmanTree childNode, StringBuffer prefix) {
        if (childNode instanceof TreeLeaf) {
            TreeLeaf leaf = (TreeLeaf) childNode;
            Node n1 = new Node(new Prefix(leaf.letter+"",prefix.toString()));
            graph.addEdge(parentNode,n1);
//            System.out.println(leaf.letter + "\t" + prefix);
            prefixCodes.put(leaf.letter + "", prefix.toString());

        } else if (childNode instanceof TreeNode) {
            TreeNode node = (TreeNode) childNode;
            Node internalNode = new Node(new Prefix(node.frequency+"",""));
            graph.addEdge(parentNode, internalNode);
            prefix.append('0');
            printCode(internalNode,node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append('1');
            printCode(internalNode,node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
