package com.sujan.sqlite.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import com.sujan.sqlite.model.Word;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {
    private  static final  String db_name="Dictionary";
    private  static final  int version=1;

    private  static final  String tblName="tblWord";


    private  static final  String wordID="wordID";
    private  static final  String wordName="wordName";
    private  static final  String wordMeaning="wordMeaning";


    //Constructor
    public MyHelper(@Nullable Context context) {
        super(context, db_name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //IF NOT EXISTS
//        String query="CREATE TABLE "+tblName+
//                " ( "+wordID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                +wordName+" TEXT, "
//                +wordMeaning+" TEXT "+" )";
//        db.execSQL(query);
       // db=getWritableDatabase();
        String  query=" create table "+tblName+"("+
                wordID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+wordName+
                " TEXT, "+ wordMeaning+ " TEXT "+")";
                db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean InsertData(String word, String meaning,SQLiteDatabase db){
        try{
            String query="insert into "+tblName+"("+wordName+","+wordMeaning+") values('"+word+"','"+meaning+"')";
            //getWritableDatabase().execSQL(query);
            db.execSQL(query);
            return  true;
        }catch (Exception e){
            Log.d("Error :",e.toString());
            return  false;
        }


    }
        public List<Word> GetAllWords(SQLiteDatabase db){
        List<Word>dictionaryList=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from "+tblName,null);
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0),
                        cursor.getString(1),cursor.getString(2)));

            }
        }
        return  dictionaryList;
    }
}
