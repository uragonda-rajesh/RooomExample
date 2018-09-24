package room.rajesh.apps.my.rooomexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Rajesh on 04-Apr-18.
 */


@Database(entities = {EmployeeModel.class}, version = 1)
public abstract class SQliteDB extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}

