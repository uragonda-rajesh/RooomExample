package room.rajesh.apps.my.rooomexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Rajesh on 04-Apr-18.
 */

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employeemodel")
    List<EmployeeModel> getAll();

    @Query("SELECT * FROM employeemodel WHERE name LIKE :name LIMIT 1")
    EmployeeModel findByName(String name);

    /**
     * Updating only price
     * By order id
     */
    @Query("UPDATE employeemodel SET email=:email_id WHERE id = :id")
    void updateEmail(String id,String email_id);

    @Insert
    void insert(EmployeeModel employeeModel);

    @Insert
    void insertAll(List<EmployeeModel> employeeModelList);

    @Update
    void update(EmployeeModel employeeModel);

    @Delete
    void delete(EmployeeModel employeeModel);

    @Query("SELECT COUNT(*) FROM employeemodel  WHERE id = :id")
    int isRecordExists(String id);
}
