package kwaai.com.exampleepoxy_hashcodeequals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.epoxy.EpoxyRecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final HomeController controller = new HomeController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EpoxyRecyclerView recyclerView = (EpoxyRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(controller.getAdapter());
        LinkedList<GraphData> graphDataFeed = new LinkedList<>();
        for (int i = 0; i < 10; i ++) {
            GraphData graphData1 = new GraphData(i, i);
            graphDataFeed.add(graphData1);
        }
        controller.setData(graphDataFeed);
    }
}
