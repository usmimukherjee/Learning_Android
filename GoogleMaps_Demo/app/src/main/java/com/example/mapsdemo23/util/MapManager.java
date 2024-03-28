package com.example.mapsdemo23.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;

import java.io.IOException;
import java.util.List;

public class MapManager {
    private GoogleMap mMap;
    private Context context;
    private Geocoder geocoder;
    Marker marker;
    public static LatLng searchedLoc;
    public static LatLng currentLoc;
    Double distance;
    public MapManager(GoogleMap googleMap, Context context) {
        this.mMap = googleMap;
        this.context = context;
        this.geocoder = new Geocoder(context);
    }

    // Using geocoder to search using latitude and longitude
    public void geocoderLocationFetch(Location location){
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Log.d("location","latitude" + latitude + "longitute" + longitude);

        /* Geocoder derives the location name, the specific country and city of the user as a list. */
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String adress = addresses.get(0).getLocality() + ":";
            adress += addresses.get(0).getCountryName();
            /* The latitude and longitude is combined and placed on the google map using a marker in the following part. */
            LatLng latLng = new LatLng(latitude, longitude);

            if (marker != null) {
                marker.remove();
            }
            marker = mMap.addMarker(new MarkerOptions().position(latLng).title(adress));
            mMap.setMaxZoomPreference(15);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Using geocoder to search using query
    public void searchLocationAndMark(String location) {
        if (location == null || location.isEmpty()) {
            return;
        }

        Geocoder geocoder = new Geocoder(context);

        List<Address> addressList;

        try {
            addressList = geocoder.getFromLocationName(location, 1);

            if (!addressList.isEmpty()) {
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Using geocoder to search using query and calculating distance

    public double searchLocationDistanceAndMark(Location currentLocation, String location) {

        // below line is to create a list of address
        // where we will store the list of all address.
        List<Address> addressList = null;
        // checking if the entered location is null or not.
        if (location != null || location.equals("")) {
            // on below line we are creating and initializing a geo coder.
            Geocoder geocoder = new Geocoder(context);
            try {
                // on below line we are getting location from the
                // location name and adding that location to address list.
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // on below line we are getting the location
            // from our list a first position.
            Address address = addressList.get(0);

            // on below line we are creating a variable for our location
            // where we will add our locations latitude and longitude.
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());

            searchedLoc = latLng;
            currentLoc = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

            // on below line we are adding marker to that position.
            mMap.addMarker(new MarkerOptions().position(latLng).title(location));
            mMap.setMaxZoomPreference(10);

            // below line is to animate camera to that position.
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

            distance = SphericalUtil.computeDistanceBetween(currentLoc, searchedLoc);

            return distance;
        }else{
            distance = (double)0;
            return distance;
        }
    }

}
