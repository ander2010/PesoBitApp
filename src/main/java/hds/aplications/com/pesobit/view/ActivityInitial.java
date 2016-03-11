package hds.aplications.com.pesobit.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import hds.aplications.com.pesobit.R;

public class ActivityInitial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        MapView mOfflineMapView = (MapView) findViewById(R.id.offlineMapView);
//Make sure you don't get the map from online
        mOfflineMapView.setUseDataConnection(false);
//Set the Tile Source (That is MapqueueOSM)
        mOfflineMapView.setTileSource(TileSourceFactory.MAPQUESTOSM);

        mOfflineMapView.setMultiTouchControls(true);
        mOfflineMapView.setClickable(true);
        mOfflineMapView.getController().setZoom(12);
        mOfflineMapView.getController().setCenter(new GeoPoint(23.115102, -82.370338));
    }
}
