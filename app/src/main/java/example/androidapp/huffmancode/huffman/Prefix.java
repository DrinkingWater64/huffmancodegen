package example.androidapp.huffmancode.huffman;

import de.blox.graphview.Node;

public class Prefix {
    String letter;
    String prefix;

    public Prefix(String letter, String prefix) {
        this.letter = letter;
        this.prefix = prefix;
    }

    public String getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return this.letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
