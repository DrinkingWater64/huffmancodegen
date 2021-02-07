package example.androidapp.huffmancode;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import de.blox.graphview.Graph;
import de.blox.graphview.GraphAdapter;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;
import example.androidapp.huffmancode.huffman.Prefix;
import example.androidapp.huffmancode.huffman.PrefixCode;
//190042117
public class GraphActivity extends AppCompatActivity {

    public void animate() {
//        RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
//        anim.setInterpolator(new LinearInterpolator());
//        anim.setRepeatCount(Animation.INFINITE);
//        anim.setDuration(3500);
//
//// Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.clouds);
//        splash.startAnimation(anim);
//
//// Later.. stop the animation
////        splash.setAnimation(null);

        ObjectAnimator animation = ObjectAnimator.ofFloat(splash, "translationX", 1500f);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(splash, "translationX", -1500f);

                animation.setDuration(4000);
                animation.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_tree);
        GraphView graphView = findViewById(R.id.graph);
        // example tree
        // example tree
        final Graph graph = PrefixCode.graph;



        // you can set the graph via the constructor or use the adapter.setGraph(Graph) method
        GraphAdapter adapter = new GraphAdapter<GraphView.ViewHolder>(graph) {

            @Override
            public int getCount() {
                return graph.getNodeCount();
            }

            @Override
            public Object getItem(int position) {
                return graph.getNodeAtPosition(position);
            }

            @Override
            public boolean isEmpty() {
                return graph.hasNodes();
            }

            @NonNull
            @Override
            public GraphView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.node, parent, false);
                return new SimpleViewHolder(view);
            }

            @Override
            public void onBindViewHolder(GraphView.ViewHolder viewHolder, Object data, int position) {
                ((SimpleViewHolder) viewHolder).textView.setText(data.toString().replaceAll("Node\\(data=(.*)\\)","$1"));

            }
        };
        graphView.setAdapter(adapter);

        // set the algorithm here
        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(100)
                .setLevelSeparation(300)
                .setSubtreeSeparation(300)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_BOTTOM_TOP)
                .build();
        graphView.setLayout(new BuchheimWalkerAlgorithm(configuration));


    }

}

