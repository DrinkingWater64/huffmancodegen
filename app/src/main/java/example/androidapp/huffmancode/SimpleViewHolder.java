package example.androidapp.huffmancode;

import android.view.View;
import android.widget.TextView;

import de.blox.graphview.GraphView;

class SimpleViewHolder extends GraphView.ViewHolder {
    TextView textView;

    SimpleViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.kalojaam);
    }
}