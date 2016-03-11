package hds.aplications.com.mycplight.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import hds.aplications.com.mycplight.R;

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
