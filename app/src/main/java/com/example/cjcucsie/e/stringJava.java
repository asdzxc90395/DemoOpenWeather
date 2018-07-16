package com.example.cjcucsie.e;

import android.annotation.TargetApi;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class stringJava implements JsonDeserializer<Weather>{
    @Override
    public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jone = json.getAsJsonObject();
        Double Done = jone.get("main").getAsJsonObject().get("temp").getAsDouble();

        Weather weather = new Weather(Done);
if(Done==null){
    System.out.println("Done Null");
}
        return weather;
    }
}
