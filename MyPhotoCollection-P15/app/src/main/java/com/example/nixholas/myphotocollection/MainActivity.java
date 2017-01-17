package com.example.nixholas.myphotocollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by nixholas on 17/1/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        ImageAdapter imageAdapter = new ImageAdapter(this, imageItems);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Image position " + position,
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), DisplayIndImage.class);

                //Get the selected Item id and description
                int imgID = imageItems[position].getImageResource();
                String txtDesc = imageItems[position].getDesc();

                //Toast.makeText(getApplicationContext(), "Image resources " + imgID,
                //        Toast.LENGTH_LONG).show();
                // Pass image index to another Intent

                i.putExtra("imgResc",imgID);
                i.putExtra("txtDesc", txtDesc);
                startActivity(i);


            }
        });
    }

    private ImageItem[] imageItems = {
            new ImageItem(R.drawable.p1,"pic1"),
            new ImageItem(R.drawable.p2,"pic2"),
            new ImageItem(R.drawable.p3,"pic3"),
            new ImageItem(R.drawable.p4,"pic4"),
            new ImageItem(R.drawable.p5,"pic5"),
            new ImageItem(R.drawable.p6,"pic6"),
            new ImageItem(R.drawable.p7,"pic7"),
    };

}
