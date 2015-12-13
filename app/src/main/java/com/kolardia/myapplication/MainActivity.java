package com.kolardia.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import android.util.Pair;

public class MainActivity extends ActionBarActivity {

    TextView wyniki;
    DTW dtw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wyniki = (TextView)findViewById(R.id.wyniki);
        dtw = new DTW();

        ArrayList<Punkt> signatureSample = new ArrayList<Punkt>();
        ArrayList<Punkt> signatureTemplete = new ArrayList<Punkt>();
        Punkt example1 = new Punkt();
        Punkt example2 = new Punkt();
        Punkt example3 = new Punkt();
        Punkt example4 = new Punkt();
        signatureSample.add(example1);
        signatureSample.add(example2);
        signatureTemplete.add(example3);
        signatureTemplete.add(example4);
        example1.x = 0.1;
        example1.y = 0.3;
        example1.force = 4;
        example2.x = 0.1;
        example2.y = 0.3;
        example2.force = 4;
        example3.x = 0.3;
        example3.y = 0.4;
        example3.force = 5;
        example4.x = 0.6;
        example4.y = 0.7;
        example4.force = 2;

       Double algorytm = dtw.algorytmDTW(signatureSample, signatureTemplete);

       /* for(int i = 0; i < algorytm.length; i++) {
            for (int j = 0; j < algorytm.length; j++) {
                wyniki.append("\n");
                wyniki.append(Double.toString(algorytm[i][j]));
            }
        }*/
        wyniki.setText("Przykladowy dystans = " + Double.toString(algorytm));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
