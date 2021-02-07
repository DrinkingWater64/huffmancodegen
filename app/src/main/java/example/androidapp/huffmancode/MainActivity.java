package example.androidapp.huffmancode;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

import example.androidapp.huffmancode.huffman.Main;

public class MainActivity extends AppCompatActivity {
	
	FloatingActionButton button;
	TextView showString;
	TextView gotoprefix;
	TextView gotoTree;
	LinearLayout linearLayout;
	EditText input;
	static public HashMap<String, String> prefixCodes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showString = findViewById(R.id.generatedstring);
		gotoprefix = findViewById(R.id.gotoprefixcodes);
		gotoTree = findViewById(R.id.gototree);
		linearLayout = findViewById(R.id.resultgroup);
		input = findViewById(R.id.stringinput);
		input.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
				String id = input.getText().toString();
				try {
					prefixCodes = Main.startGenerating(id);
					linearLayout.setVisibility(View.VISIBLE);
					showString.setText(Main.finalString);
				} catch (Exception e) {
					Log.e("error", e.getMessage(), e.getCause());
					input.setError("Invalid Input");
					linearLayout.setVisibility(View.INVISIBLE);
				}
			}
		});
	}
	
	public void goPrefix(View go) {
		EditText input = findViewById(R.id.stringinput);
		String id = input.getText().toString();
		try {
			Intent intent = new Intent(go.getContext(), DisplayTree.class);
			startActivity(intent);
		} catch (Exception e) {
			Log.e("error", e.getMessage(), e.getCause());
			Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void goAbout(View go) {
		Intent intent = new Intent(go.getContext(), Noksesh.class);
		startActivity(intent);
	}
	
	public void goTree(View view) {
		Intent intent = new Intent(view.getContext(), GraphActivity.class);
		startActivity(intent);
	}
}