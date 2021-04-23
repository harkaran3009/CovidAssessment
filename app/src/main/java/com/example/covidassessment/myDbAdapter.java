package com.example.covidassessment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class myDbAdapter  {

    myDbHelper helper;

    public myDbAdapter(Context context)
    {
        helper = new myDbHelper(context);
    }

    public long insertData(String name, String address,String identType, String identNumber, String eligibleGroup, String centre, String date,String timeslot )
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.ADDRESS, address);
        contentValues.put(myDbHelper.IDENTIFICATION_TYPE, identType);
        contentValues.put(myDbHelper.IDENTIFICATION_NUMBER, identNumber);
        contentValues.put(myDbHelper.ELIGIBLEGROUP, eligibleGroup);
        contentValues.put(myDbHelper.CENTRE, centre);
        contentValues.put(myDbHelper.DATE, date);
        contentValues.put(myDbHelper.TIME_SLOT, timeslot);
        long id = db.insert(myDbHelper.TABLE_NAME, null , contentValues);
        if (id != -1)
        {
            db.setTransactionSuccessful();
            db.endTransaction();
            db.close();
        }
        return id;
    }
    public ArrayList<String> fetchData(String identType, String identNumber)
    {
        System.out.println(identType +  identNumber);
        ArrayList<String> values = new ArrayList<String>();
        SQLiteDatabase db = helper.getReadableDatabase();
        System.out.println(db);
        Cursor cursor = db.rawQuery("select * from VaccineRegister where Identification_Type = ? and Identification_Number = ?" , new String [] {String.valueOf(identType),String.valueOf(identNumber)});
        //System.out.println(cursor.moveToFirst());
        if (cursor.moveToFirst()) // data?
        {
            values.add(cursor.getString(cursor.getColumnIndex("Name")));
            values.add(cursor.getString(cursor.getColumnIndex("Centre")));
            values.add(cursor.getString(cursor.getColumnIndex("Date")));
        }
        else
        {
            values.add("false");
        }


        //System.out.println(values.indexOf(0));
        cursor.close();
        db.close();
        return values;

    }
   static class myDbHelper extends SQLiteOpenHelper
   {
       private static final String DATABASE_NAME = "myDatabase";
       private static final String TABLE_NAME = "VaccineRegister";
       private static final int DATABASE_Version = 1;
       private static final String UID="_id";
       private static final String NAME = "Name";
       private static final String ADDRESS= "Address";
       private static final String IDENTIFICATION_TYPE= "Identification_Type";
       private static final String IDENTIFICATION_NUMBER= "Identification_Number";
       private static final String ELIGIBLEGROUP= "Eligible_Group";
       private static final String CENTRE= "Centre";
       private static final String DATE= "Date";
       private static final String TIME_SLOT= "Time_Slot";
       private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME +
               "( "+UID+" INTEGER PRIMARY KEY AUTOINCREMENT ," +NAME+ " VARCHAR(225) ," + ADDRESS+" VARCHAR(225)," + IDENTIFICATION_TYPE + " VARCHAR(255), " +
               IDENTIFICATION_NUMBER + " VARCHAR(255)," + ELIGIBLEGROUP + " VARCHAR(255), " + CENTRE + " VARCHAR(255), " +DATE+ " VARCHAR(20), " + TIME_SLOT +" VARCHAR(20) " +");";
      // private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
       private Context context;

       public myDbHelper(Context context) {
           super(context, DATABASE_NAME, null, DATABASE_Version);
           this.context=context;
           Message.message(context,"Started...");
       }

       @Override
       public void onCreate(SQLiteDatabase db) {
           try {
               db.execSQL(CREATE_TABLE);
               Message.message(context,"TABLE CREATED");
           } catch (Exception e) {
              Message.message(context,""+e);
           }
       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          /* try {
               Message.message(context,"OnUpgrade");
               db.execSQL(DROP_TABLE);
               onCreate(db);
           }catch (Exception e) {
               Message.message(context,""+e);
                          }*/
       }
   }
    public static class Message {
        public static void message(Context context, String message) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

}
