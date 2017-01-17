package com.example.nixholas.sqliteevents;

import android.provider.BaseColumns;

/**
 * Created by nixholas on 17/1/17.
 */

public interface Constants extends BaseColumns {
    public static final String TABLE_NAME = "events";

    // columns
    public static final String TIME = "time";
    public static final String TITLE = "title";

}
