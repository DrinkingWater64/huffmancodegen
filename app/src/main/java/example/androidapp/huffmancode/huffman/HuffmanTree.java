package example.androidapp.huffmancode.huffman;

public class HuffmanTree implements Comparable<HuffmanTree>{
    public int frequency;
    public HuffmanTree(int frequency){
        this.frequency = frequency;
    }

    public HuffmanTree() {

    }

    //frequency of a tree
    public int compareTo( HuffmanTree tree) //comparing two letter with their frequency
    {
        return this.frequency - tree.frequency;
    }
}
