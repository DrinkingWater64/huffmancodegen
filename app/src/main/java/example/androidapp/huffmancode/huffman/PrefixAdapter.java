package example.androidapp.huffmancode.huffman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import example.androidapp.huffmancode.R;

public class PrefixAdapter extends ArrayAdapter<Prefix> {

    public PrefixAdapter(@NonNull Context context, @NonNull ArrayList<Prefix> prefixes, ListView layout) {
        super(context, 0, prefixes);
        layout.setAdapter(this);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_layout, parent,false);
        }
        Prefix prefix = getItem(position);
        ((TextView) convertView.findViewById(R.id.letter)).setText(prefix.getLetter());
        ((TextView) convertView.findViewById(R.id.prefix)).setText(prefix.getPrefix());
        return convertView;
    }
}