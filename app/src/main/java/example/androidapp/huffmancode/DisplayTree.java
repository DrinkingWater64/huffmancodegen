package example.androidapp.huffmancode;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

import example.androidapp.huffmancode.huffman.Prefix;
import example.androidapp.huffmancode.huffman.PrefixAdapter;

public class DisplayTree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaycodes);
        ArrayList<Prefix> prefixes = new ArrayList<>();
        ListView codes = findViewById(R.id.codes);
        for ( Map.Entry<String, String> code: MainActivity.prefixCodes.entrySet()){
            prefixes.add(new Prefix(code.getKey(), code.getValue()));
        }
        PrefixAdapter adapter = new PrefixAdapter(this, prefixes, codes);

    }
}