package example.androidapp.huffmancode.huffman;

import java.util.Scanner;

public class StringGenerator {

    String IDtemp; //holds the ID no.
    boolean flag = true;
    String finalString;
    String stringConverter( String IDtemp)
    {

            this.IDtemp = IDtemp;
            String ID = IDtemp.replace("19004", "");


            String[] digits = new String[]{"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

            this.finalString = "MYIDIS" +
                    digits[Integer.parseInt(String.valueOf(ID.charAt(0)))] +
                    digits[Integer.parseInt(String.valueOf(ID.charAt(1)))] +
                    digits[Integer.parseInt(String.valueOf(ID.charAt(2)))] +
                    digits[Integer.parseInt(String.valueOf(ID.charAt(3)))];



            return this.finalString;

    }
}
