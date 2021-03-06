package hds.aplications.com.pesobit.services.Util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Miguel Gomez Leon on 12/9/15.
 * mgleonsc@gmail.com
 */
public class DateDeserializer implements JsonDeserializer<Date> {
    final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return df.parse(json.getAsString());
        } catch (final java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
