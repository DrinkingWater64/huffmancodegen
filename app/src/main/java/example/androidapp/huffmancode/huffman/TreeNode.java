package example.androidapp.huffmancode.huffman;

public class TreeNode extends HuffmanTree {
    public HuffmanTree left, right;
    public TreeNode(HuffmanTree left, HuffmanTree right) {
        super(left.frequency+right.frequency);
        this.left = left;
        this.right = right;
    }
}
