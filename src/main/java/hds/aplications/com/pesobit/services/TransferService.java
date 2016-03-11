package hds.aplications.com.pesobit.services;

import java.util.List;

import hds.aplications.com.pesobit.models.Transfer;
import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;


public interface TransferService {

    @FormUrlEncoded
    @POST("/api/v1/transfers.{format}")
    void add(@Path("format") String format, @Field("sender") String sender, @Field("receiver") String receiver, @Field("amount") double amount, @Field("create") String create, @Field("message") String message, @Field("state") String state, Callback<Transfer> callback);

}
