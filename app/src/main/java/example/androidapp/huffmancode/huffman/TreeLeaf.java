package example.androidapp.huffmancode.huffman;

class TreeLeaf extends HuffmanTree {
    public char letter;
    public TreeLeaf(int frequency, char letter) {
        super(frequency);
        this.letter = letter;
    }
}
