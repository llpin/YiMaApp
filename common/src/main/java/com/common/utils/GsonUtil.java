package com.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by linlipin on 18/1/2.
 */

public class GsonUtil {
    private static Gson gson;

    public GsonUtil() {
        if (gson == null){
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH-mm-ss").create();
        }
    }

    public static Gson getGson() {
        if (gson == null){
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH-mm-ss").create();
        }
        return gson;
    }

    public static String toJson(Object src){
        return getGson().toJson(src);
    }

    public static JsonElement toJsonTree(Object src, Type typeOfSrc){
        return getGson().toJsonTree(src, typeOfSrc);
    }

    public static <T> T fromJson(String json, Class<T> classOfT){
        return getGson().fromJson(json, classOfT);
    }

    public static <T> T fromResponse(Response response, Class<T> classOfT) throws IOException {
        return getGson().fromJson(response.body().string(), classOfT);
    }
}
