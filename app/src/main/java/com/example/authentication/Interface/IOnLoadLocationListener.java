package com.example.authentication.Interface;

import com.example.authentication.MyLatLng;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface IOnLoadLocationListener {
    void onLoadLocaionSuccess(List<MyLatLng> latLngs);
    void onLoadLocationFailed(String message);
}
