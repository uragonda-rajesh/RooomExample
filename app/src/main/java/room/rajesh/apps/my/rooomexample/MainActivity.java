package room.rajesh.apps.my.rooomexample;

import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQliteDB roomDatabase = (SQliteDB) MyApplication.getInstance().getRoomInstance();

        final TextView tv_text = findViewById(R.id.tv_text);


        //updat queries
        //https://stackoverflow.com/questions/45789325/update-some-specific-field-of-an-entity-in-android-room/49562132#49562132


        new AsyncTask<Void, Void, EmployeeModel>() {

            @Override
            protected EmployeeModel doInBackground(Void... voids) {

                /*
                * insert in to db
                * */
                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setId("1");
                employeeModel.setName("Rajesh");
                employeeModel.setEmail("raj@gmail.com");
                employeeModel.setMobile("8341440044");
                roomDatabase.employeeDao().insert(employeeModel);

                /*
                * update email
                * */
                roomDatabase.employeeDao().updateEmail("1","rrrrrrrrr@gmail.com");
                /*
                * retrive by name
                * */
                return roomDatabase.employeeDao().findByName("Rajesh");
                //return null;
            }

            @Override
            protected void onPostExecute(EmployeeModel employeeModel) {
                super.onPostExecute(employeeModel);
                tv_text.setText(employeeModel.getEmail());

            }
        }.execute();

    }
}
