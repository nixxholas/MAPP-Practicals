package com.example.nixholas.sqliteevents;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.BaseColumns._ID;
import static com.example.nixholas.sqliteevents.Constants.TABLE_NAME;
import static com.example.nixholas.sqliteevents.Constants.TIME;
import static com.example.nixholas.sqliteevents.Constants.TITLE;

public class EventsMain extends AppCompatActivity {

    private static String[] FROM  = { _ID, TIME, TITLE, };
    private static String ORDER_BY = TIME + " DESC" ;
    private EventsData events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_main);

        events = new EventsData(this);
        try {
            addEvent ("Hello, Android");
            Cursor cursor = getEvents();
            showEvents(cursor);
        }finally {
            events.close();
        }
    }

    private void addEvent(String string){
        SQLiteDatabase db = events.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(TITLE, string);
        db.insertOrThrow(TABLE_NAME, null, values);

    }

    private Cursor getEvents(){
        SQLiteDatabase db = events.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null, null, ORDER_BY);
        return cursor;
    }

    private void showEvents(Cursor cursor){
        StringBuilder builder = new StringBuilder("Saved events:\n");
        while (cursor.moveToNext()){
            long id = cursor.getLong(0);
            long time = cursor.getLong(1);
            String title = cursor.getString(2);
            builder.append(id).append(": ");
            builder.append(time).append(": ");
            builder.append(title).append("\n");

        }

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(builder);

    }

}
