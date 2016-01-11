package com.student.matthew.opstoppingmetmaps;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.student.matthew.opstoppingmetmaps.db.DatabaseManager;
import com.student.matthew.opstoppingmetmaps.db.MysqlDatabase;
import com.student.matthew.opstoppingmetmaps.model.Plaatsen;
import com.student.matthew.opstoppingmetmaps.repo.PlaatsenRepo;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {
    PlaatsenRepo prepo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseManager.init(this);
        prepo = new PlaatsenRepo(this);
        MysqlDatabase mdb = new MysqlDatabase();

        ArrayList<Plaatsen> pls = mdb.getall();
        List<Plaatsen> pls2 = prepo.findAll();
        for(int i = pls2.size(); i<pls.size();i++){
prepo.create(pls.get(i));
        }
ArrayList<String> s = new ArrayList<String>();
        for(int i = 0; i<pls2.size();i++){
            s.add(pls2.get(i).getPininfo());
        }
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,s);

        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {

                        Intent i = new Intent(MainActivity.this, MapMain.class);
                        i.putExtra("item", position);
                        startActivity(i);
                    }
                }
        );

}}
