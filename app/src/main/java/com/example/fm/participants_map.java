package com.example.fm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.fm.Popup_detail2;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;



public class participants_map extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private static NaverMap naverMap;
    private Marker marker;
    Button btn_maplist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participants_map);

        MapView mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btn_maplist = (Button) findViewById(R.id.map_list_check) ;

        btn_maplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_map.this, participants_store_list.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;  //


        Marker marker1 = new Marker();
        Marker marker2 = new Marker();
        Marker marker3 = new Marker();
        Marker marker4 = new Marker();
        Marker marker5 = new Marker();
        InfoWindow infoWindow = new InfoWindow();

        LocationOverlay locationOverlay = naverMap.getLocationOverlay();


        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(getApplication()){
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow){
                return "모집글: 1개";
            }
        });





        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BUILDING, true);  //건물 표시

        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(36.304325, 127.342),  //건양대학교 죽헌정보관 좌표
                14.5   //줌배율
        );
        naverMap.setCameraPosition(cameraPosition);
    }


}

