package com.hariofspades.customrecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.hariofspades.customrecyclerview.Adapter.CustomAdapter;
import com.hariofspades.customrecyclerview.Pojo.CustomPojo;

import java.util.ArrayList;

/** Authuor: Hari vignesh Jayapalan
 *  Created on: 6 Feb 2016
 *  Email: hariutd@gmail.com
 *
 *  Implementing custom RecyclerView Adapter
 *  Tutorial @ https://medium.com/@harivigneshjayapalan
 * */
public class MainActivity extends AppCompatActivity {
    //Declare the Adapter, AecyclerView and our custom ArrayList
    RecyclerView recyclerView;
    CustomAdapter adapter;
    private ArrayList<CustomPojo> listContentArr= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        //As explained in the tutorial, LineatLayoutManager tells the RecyclerView that the view
        //must be arranged in linear fashion
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CustomAdapter(this);
        //Method call for populating the view
        populateRecyclerViewValues();
    }

    private void populateRecyclerViewValues() {
        /** This is where we pass the data to the adpater using POJO class.
         *  The for loop here is optional. I've just populated same data for 50 times.
         *  You can use a JSON object request to gather the required values and populate in the
         *  RecyclerView.
         * */
        for(int iter=1;iter<=50;iter++) {
            //Creating POJO class object
            CustomPojo pojoObject = new CustomPojo();
            //Values are binded using set method of the POJO class
            pojoObject.setName("Hari Vigensh Jayapalan");
            pojoObject.setContent("Hello RecyclerView! item: "+iter);
            pojoObject.setTime("10:45PM");
            //After setting the values, we add all the Objects to the array
            //Hence, listConentArr is a collection of Array of POJO objects
            listContentArr.add(pojoObject);
        }
        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
