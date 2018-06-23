package kwaai.com.exampleepoxy_hashcodeequals;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;

import java.util.LinkedList;

public class HomeController extends TypedEpoxyController<LinkedList<GraphData>> {

    @AutoModel
    HeaderViewModel_ header;

    @Override
    protected void buildModels(LinkedList<GraphData> data) {
        header.lineChart(data).addTo(this);
    }
}
