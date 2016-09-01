package com.happylifecreators.pdftest;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.joanzapata.pdfview.PDFView;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;
    Button btTest1;
    Button btTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView = (PDFView) findViewById(R.id.pdfview);
        pdfView.fromAsset("test.pdf").load();

        btTest1 = (Button)findViewById(R.id.test1);
        btTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float zoom = pdfView.getZoom() + (float) 0.5;
                pdfView.zoomCenteredTo(zoom, new PointF(0, 0));
            }
        });

        btTest2 = (Button)findViewById(R.id.test2);
        btTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float zoom = pdfView.getZoom() - (float)0.5;
                pdfView.zoomCenteredTo(zoom, new PointF(0, 0));
            }
        });

    }
}
