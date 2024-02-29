package com.example.mapsdemo23.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.mapsdemo23.R;
import com.example.mapsdemo23.databinding.ActivityNearBySearchBinding;
import com.example.mapsdemo23.util.MapManager;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class SearchDistance extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap; // GoogleMap object to interact with the map
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    public Double distance; // Distance between two locations

    LocationManager locationManager; // Manages location services
    LocationListener locationListener; // Listens for location updates
//    Marker marker; // Represents a marker on the map
    SearchView searchView; // SearchView for user input
    private ActivityNearBySearchBinding binding; // View binding object
    MapManager mapManager; // Helper class to manage map operations
    private Location currentLocation; // Represents the current location

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNearBySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // initializing our search view.
        searchView = findViewById(R.id.idsearch);

    }

    // Initializes the location listener
    public void initializeLocationListener(){
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                mapManager.geocoderLocationFetch(location);
                currentLocation = location;
            }
        };
    }

    // Checks for location permission and starts location updates
    private void checkLocationPermissionAndStartUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        } else {
            startLocationUpdates();
        }
    }

    // Starts receiving location updates
    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

    // Handles the result of location permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates();
            }
        }
    }

    // Stops location updates when the activity is stopped
    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapManager = new MapManager(mMap, this);

        // Initialize locationListener
        initializeLocationListener();
        checkLocationPermissionAndStartUpdates();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (mapManager != null) {
                    // Get the location name from search view
                    String location = searchView.getQuery().toString();
                    // Calculate distance between current location and searched location
                    distance = mapManager.searchLocationDistanceAndMark(currentLocation, location);
                    // Display distance in a toast message (converted to kilometers and rounded to 2 decimal places)
                    Toast.makeText(SearchDistance.this, "Distance is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();
                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}

