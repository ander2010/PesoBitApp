package hds.aplications.com.pesobit.services;

import android.content.Context;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import java.util.List;

import hds.aplications.com.pesobit.models.Transfer;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TransferClient extends BaseClient {
    //public AccommodationService service;

    public TransferClient(Context context) {
        super(TransferService.class, context);
    }

    public void add(String sender, String receiver, double amount, String create, String message, Callback<Transfer> callback){
        ((TransferService)this.service).add(BaseClient.API_RESPONSE_FORMAT, sender, receiver, amount, create, message, callback);
    }
}
