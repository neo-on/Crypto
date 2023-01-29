package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private final ArrayList<ParseItem> parseitem;

    public MainActivity(ArrayList<ParseItem> parseitem) {
        this.parseitem = parseitem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=recyclerView.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ParseAdapter adapter = new ParseAdapter(parseitem, this);
        recyclerView.setAdapter(adapter);
    }

    public class content extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String url ="https://coinmarketcap.com/";
                Document doc = Jsoup.connect(url).get();
                Elements element=doc.select("span.sc-10718977-2 fsKnWr");
                int size =element.size();
                for (int i=0;i<size;i++){
                    String imageurl=element.select("span.sc-aef7b723-0 sc-8497df48-0 iULUNk").select("img").eq(i).attr("src");
                    String name =element.select("span.sc-e225a64a-0 ePTNty").eq(i).text();
                    String value =element.select("span.cmc-link").eq(i).text();

                    parseitem.add(new ParseItem(imageurl,name,value));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }
    }
}