package com.example.mapsdemo23.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.example.mapsdemo23.R;
import com.example.mapsdemo23.util.MapManager;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class SearchingMaps extends AppCompatActivity implements OnMapReadyCallback {
    private MapManager mapManager; // Instance of MapManager for handling map operations
    private SearchView searchView; // Instance of SearchView for user input
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searching);

        searchView = findViewById(R.id.idSearchView);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Set up listener for search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (mapManager != null) {
                    // Search for the location entered by the user and mark it on the map
                    mapManager.searchLocationAndMark(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Initialize MapManager with the GoogleMap object and the context
        mapManager = new MapManager(googleMap, this);
    }
}