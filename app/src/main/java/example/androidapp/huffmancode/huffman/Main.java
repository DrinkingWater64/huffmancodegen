package example.androidapp.huffmancode.huffman;

import java.util.HashMap;

import de.blox.graphview.Node;

public class Main {
    public static String finalString = "";
    public static HashMap<String, String> startGenerating(String id) throws Exception {


        StringGenerator newID = new StringGenerator();

           newID.IDtemp = id;


           if(!newID.IDtemp.matches("19004\\d{4}")){
                throw new Exception("Invalid, try again");
            }
           finalString = newID.stringConverter(newID.IDtemp);

           System.out.println("Generated String: " + finalString); //prints the generated string

           int[] charFrequency = new int[128];  //an array to create a frequency table for the string
           for (char c : finalString.toCharArray()) {
               charFrequency[c]++;
           }


           HuffmanTree tree = new HuffmanTree();
           PrefixCode demo = new PrefixCode();
           tree = demo.createTree(charFrequency);
           demo.printCode(new Node(new Prefix("","")),tree, new StringBuffer());
           return demo.prefixCodes;
       }

}
