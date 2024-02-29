package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView)findViewById (R.id.Listview);
        /*String cities[] ={"PnmPenh","SiemReap","Koh kong","Prey veng","Kep","Kompong cham","Kompong Chnag"
        ,"Sihanouk","Battambonng","Kampong Thom","Takeo","Pursat","Mondulkiri","Stung Streng","Svay Rieng", "Preah Vihear"
        ,"Kandal","Banteay Meanchey","Ratanakiri","Kampong Speu","pai lin","kro jes","tbong kmom"};

         */
        String cities[] = getProvinceNames();
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,cities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView,View view,int Position,long l){
                String selectedProvince = (String) listView.getItemAtPosition(Position);
                Location location = loadLocationsData().get(selectedProvince);

                Toast.makeText(getApplicationContext(),location.toString(),Toast.LENGTH_LONG).show();
            }

        });
    }
    private HashMap<String, Location> loadLocationsData(){
        HashMap<String,Location> location = new HashMap<>();
        location.put("PnmPenh",new Location(11.5564,104.9287));
        location.put("Sihanouk",new Location(10.627543,103.522141));
        location.put("Kampot",new Location(10.594242,104.5478));
        location.put("SiemReap",new Location(102.4566,23.2390));
        location.put("Battambonng",new Location(12.4589,190.543));
        location.put("Kompong cham",new Location(123.954,12.789));
        location.put("Kompong Chnag",new Location(129.56,230.000));
        location.put("Kampong Thom",new Location(120.590,290.540));
        location.put("Koh kong",new Location(129.630,543.890));
        location.put("Kep",new Location(238.0009,546.008));
        location.put("Prey veng",new Location(34.001,44.765));
        location.put("Takeo",new Location(346.89,32.0006));
        location.put("Pursat",new Location(678.66,45.777));
        location.put("Mondulkiri",new Location(23.9999,77.0000));
        location.put("Stung Streng",new Location(345.0009,56.9990));
        location.put("Svay Rieng",new Location(34.9999,21.5444));
        location.put("Preah Vihear",new Location(34.8999,34.000));
        location.put("Kandal",new Location(12.4555,56.7890));
        location.put("Banteay Meanchey",new Location(230.889,340.333));
        location.put("Ratanakiri",new Location(40.678,43.908));
        location.put("Kampong Speu",new Location(34.789,234.567));
        location.put("pai lin",new Location(80.4000,32.905));
        location.put("kro jes",new Location(56.100,45.7777));
        location.put("tbong mom",new Location(34.004,12.880));
        return location;
    }
    public String[] getProvinceNames(){
        String[] province = new String[loadLocationsData().size()];
        province=loadLocationsData().keySet().toArray(province);
        return province;
    }



}