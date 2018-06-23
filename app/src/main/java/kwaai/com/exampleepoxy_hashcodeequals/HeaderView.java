package kwaai.com.exampleepoxy_hashcodeequals;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;

import com.airbnb.epoxy.ModelProp;
import com.airbnb.epoxy.ModelView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan=false)
public class HeaderView extends CardView {

    @BindView(R.id.chart1)
    LineChart lineChart;

    public HeaderView(Context context) {
        super(context);
        init();
        lineChart.getDescription().setEnabled(false);
        lineChart.setNoDataTextColor(ContextCompat.getColor(getContext(), R.color.white));
        lineChart.setTouchEnabled(true);
        lineChart.setDragDecelerationFrictionCoef(0.9f);
        lineChart.setDragEnabled(false);
        lineChart.setScaleEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setHighlightPerDragEnabled(false);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setEnabled(false);
        Legend l = lineChart.getLegend();
        l.setEnabled(false);
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setEnabled(false);
        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);
    }


    private void init() {
        inflate(getContext(), R.layout.header_view, this);
        ButterKnife.bind(this);
    }

    @ModelProp
    public void setLineChart(LinkedList<GraphData> graphDataFeed) {
        ArrayList<Entry> values = new ArrayList<Entry>();
        for (GraphData graphData : graphDataFeed) {
            values.add(new Entry(graphData.time, graphData.price));
        }
        LineDataSet set1 = new LineDataSet(values, "DataSet 1");
        set1.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ContextCompat.getColor(getContext(), R.color.white));
        set1.setLineWidth(2.5f);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);
        set1.setDrawFilled(true);
        set1.setFillAlpha(65);
        set1.setDrawCircleHole(false);
        LineData data = new LineData(set1);
        lineChart.setData(data);
        lineChart.invalidate();
    }

}
