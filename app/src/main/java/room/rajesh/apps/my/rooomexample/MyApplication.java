package room.rajesh.apps.my.rooomexample;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Rajesh on 04-Apr-18.
 */

public class MyApplication extends Application {


    SQliteDB database;
   static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }

    public static MyApplication getInstance()
    {
        return myApplication;
    }


    public RoomDatabase getRoomInstance() {
        if (database == null)
            database = Room.databaseBuilder(this, SQliteDB.class, "Rajesh").build();

        return database;
    }
}
