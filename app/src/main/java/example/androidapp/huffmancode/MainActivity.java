package example.androidapp.huffmancode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

import example.androidapp.huffmancode.huffman.Main;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton button;
    TextView showString;
    TextView gotoprefix;
    TextView gotoTree;
    LinearLayout linearLayout;
    boolean flag;
    static public HashMap<String, String> prefixCodes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.floatingActionButton);
        showString = findViewById(R.id.generatedstring);
        gotoprefix = findViewById(R.id.gotoprefixcodes);
        gotoTree = findViewById(R.id.gototree);
        linearLayout = findViewById(R.id.resultgroup);
    }

    public void goPrefix(View go){
        EditText input = findViewById(R.id.stringinput);
        String id = input.getText().toString();
        try {
            Intent intent = new Intent(go.getContext(),DisplayTree.class);
            startActivity(intent);

        } catch (Exception e) {
            Log.e("error",e.getMessage(),e.getCause());
            Toast.makeText(this,"Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }
    public void onGo(View go){
        EditText input = findViewById(R.id.stringinput);
        String id = input.getText().toString();
        try {
            prefixCodes = Main.startGenerating(id);
            linearLayout.setVisibility(View.VISIBLE);
            showString.setText(Main.finalString);


        } catch (Exception e) {
            Log.e("error",e.getMessage(),e.getCause());
            Toast.makeText(this,"Invalid Input", Toast.LENGTH_SHORT).show();
            linearLayout.setVisibility(View.INVISIBLE);
        }
    }
    public void goAbout(View go){
        Intent intent = new Intent(go.getContext(), Noksesh.class);
        startActivity(intent);
    }

    public void goTree(View view) {
        Intent intent = new Intent(view.getContext(), GraphActivity.class);
        startActivity(intent);
    }
}