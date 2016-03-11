package hds.aplications.com.pesobit.services;

import android.content.Context;

import hds.aplications.com.pesobit.services.Util.Util;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Miguel Gomez Leon on 11/24/15.
 * mgleonsc@gmail.com
 */
public class BaseClient {
    private static final String API_BASE_URL = "http://cbs.localsupper.com";
    public static final String API_RESPONSE_FORMAT = "json";
    public static final String API_KEY = "api-241c1e5ff6071fbec3505db53ce2d7a72";

    public RestAdapter adapter;
    public Object service;
    public Context context;

    public BaseClient(Class<?> cls, Context context) {
        this.adapter  = this.getAdapter();
        this.service = adapter.create(cls);
        this.context = context;
    }

    protected final RestAdapter getAdapter() {
        return new RestAdapter.Builder().setConverter(new GsonConverter(Util.gsonWithDate())).setEndpoint(API_BASE_URL).build();
    }
}
