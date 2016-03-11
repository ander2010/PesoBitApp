package hds.aplications.com.mycplight.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * Created by Miguel Gomez Leon on 11/23/15.
 * mgleonsc@gmail.com
 */
public class WifiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if(action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)){
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            boolean connected = info.isConnected();

            if (connected){
                Toast toast = Toast.makeText(context, "Connected...", Toast.LENGTH_LONG);
                toast.show();
            }
            else {
                /*Toast toast = Toast.makeText(context, "Offline...", Toast.LENGTH_LONG);
                toast.show();*/

                //MessageToast.showError(context, "No hay conexión a internet");
            }
        }
    }

    public static boolean isOnline(Context context)
    {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
