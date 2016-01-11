package com.student.matthew.opstoppingmetmaps;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.student.matthew.opstoppingmetmaps.model.Plaatsen;
import com.student.matthew.opstoppingmetmaps.repo.PlaatsenRepo;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

public class MapMain extends AppCompatActivity implements OnMapReadyCallback,EditFragment.ToolbarListener {

    GoogleMap mMap;
    double pinLat,pinLng;
    String pinInfo;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detailmenu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Date beginTijd, eindTijd;
        int id = Integer.parseInt(getIntent().getStringExtra("item"));
        PlaatsenRepo prepo = new PlaatsenRepo(this);
        List<Plaatsen> pls = prepo.findAll();

        pinInfo = pls.get(id).getPininfo();
        pinLat = pls.get(id).getPinLat();
        pinLng = pls.get(id).getPinLng();
       beginTijd = pls.get(id).getBegintijd();
        eindTijd = pls.get(id).getEindtijd();

            MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

                ((TextView) findViewById(R.id.textView)).setText(pinInfo);
        ((TextView) findViewById(R.id.textView2)).setText(beginTijd.toString());
        ((TextView) findViewById(R.id.textView3)).setText(eindTijd.toString());
    }
@Override
public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){
      case  R.id.action_settings:
sendToActionIntent();
        return true;

        default:

            return super.onOptionsItemSelected(item);
    }
}

    private void sendToActionIntent() {
        StringBuilder uri = new StringBuilder("geo:");
        uri.append(pinLat);
        uri.append(",");
        uri.append(pinLng);
        uri.append("?z=10");
        uri.append("&q=" + URLEncoder.encode(pinInfo));

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString()));
        startActivity(intent);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(new LatLng(pinLat,pinLng)).title(pinInfo));
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(new LatLng(pinLat,pinLng),5);
        mMap.moveCamera(update);

    }



    public void onButtonClick(String text) {

        text textFragment =
                (text)
                        getSupportFragmentManager().findFragmentById(R.id.text);

        textFragment.changeTextProperties(text);
    }
}
