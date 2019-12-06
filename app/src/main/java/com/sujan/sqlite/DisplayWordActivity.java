package com.sujan.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sujan.sqlite.helper.MyHelper;
import com.sujan.sqlite.model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayWordActivity extends AppCompatActivity {
    private ListView lstWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_word);
        lstWords=findViewById(R.id.lstWords);
        loadWord();
    }

    private void loadWord() {
        final MyHelper myHelper=new MyHelper(this);
        final SQLiteDatabase db= myHelper.getWritableDatabase();

        List<Word> wordList=new ArrayList<>();
        wordList=myHelper.GetAllWords(db);

        HashMap<String,String> hashMap=new HashMap<>();

        for(int i=0;i<wordList.size(); i++){
            hashMap.put(wordList.get(i).getWordName(),wordList.get(i).getWordMeaning());
        }

        ArrayAdapter<String>stringArrayAdapter=new ArrayAdapter<>(
         this,
         android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())
        );
        lstWords.setAdapter(stringArrayAdapter);
    }

}
