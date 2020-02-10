package com.example.graph;
import android.app.FragmentTransaction;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -2),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
        series.setShape(PointsGraphSeries.Shape.POINT);

        PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 4),
                new DataPoint(2, 2),
                new DataPoint(3, 1),
                new DataPoint(4, 5)
        });
        graph.addSeries(series2);
        series2.setShape(PointsGraphSeries.Shape.RECTANGLE);
        series2.setColor(Color.RED);

        PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 3),
                new DataPoint(2, 1),
                new DataPoint(3, 0),
                new DataPoint(4, 4)
        });
        graph.addSeries(series3);
        series3.setShape(PointsGraphSeries.Shape.TRIANGLE);
        series3.setColor(Color.YELLOW);

        PointsGraphSeries<DataPoint> series4 = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 2),
                new DataPoint(2, 0),
                new DataPoint(3, -1),
                new DataPoint(4, 3)
        });
        graph.addSeries(series4);
        series4.setColor(Color.GREEN);
        series4.setCustomShape(new PointsGraphSeries.CustomShape() {
            @Override
            public void draw(Canvas canvas, Paint paint, float x, float y, DataPointInterface dataPoint) {
                paint.setStrokeWidth(10);
                canvas.drawLine(x-20, y-20, x+20, y+20, paint);
                canvas.drawLine(x+20, y-20, x-20, y+20, paint);
            }
        });
    }


}
