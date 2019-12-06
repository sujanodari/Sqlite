package com.sujan.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sujan.sqlite.helper.MyHelper;

public class MainActivity extends AppCompatActivity {
EditText word,meaning;
Button save;
String Wordd, Meaning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word= findViewById(R.id.word);
        meaning= findViewById(R.id.meaning);
        save= findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wordd= word.getText().toString();
                Meaning= meaning.getText().toString();
                MyHelper myHelper= new MyHelper(MainActivity.this);
                SQLiteDatabase db=myHelper.getWritableDatabase();
                if(TextUtils.isEmpty(Wordd)){
                    word.setError("word cannot be null");
                }else if(TextUtils.isEmpty(Meaning)){
                    meaning.setError("Meaning cannot be null");
                }
                else{
                    myHelper.InsertData(Wordd,Meaning,db);
                }
            }
        });


    }
}
