package co.jbtraining.mobile.jbrecipe;


import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeFragment extends Fragment {

    String title;
    String body;
    String position;


    public RecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_recipe, container, false);

        ((TextView)v.findViewById(R.id.TitleTextView)).setText(title);
        ((TextView)v.findViewById(R.id.bodyTextView)).setText(body);


        String[] pos= position.split(",");
        double lat= Double.parseDouble(pos[0]);
        double lon= Double.parseDouble(pos[1]);


        android.support.v4.app.FragmentManager fm = getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.mapFrag);

        // get the map object from the fragment:
        GoogleMap map = mapFragment.getMap();

        // setup the map type:
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // setup map position and zoom
        LatLng position = new LatLng(lat ,lon);

        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(position, 15);
        map.moveCamera(update);

        // add a map marker:
        MarkerOptions markerOptions = new MarkerOptions()
                .position(position)
                .title("John Bryce is fun!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        Marker marker = map.addMarker(markerOptions);






        return v;
    }

}
