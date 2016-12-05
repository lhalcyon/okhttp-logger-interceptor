package com.halcyon.logger.util;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {

    private static final int JSON_INDENT = 2;

    /**
     *
     * @param jsonStr string param .expect a json string
     * @return formatted json string if param is a json string,otherwise return the param
     */
    public static String convert(String jsonStr){
        try {
            jsonStr = jsonStr.trim();
            if(jsonStr.startsWith("{")){
                JSONObject jsonObject = new JSONObject(jsonStr);
                return jsonObject.toString(JSON_INDENT);
            }
            if(jsonStr.startsWith("[")){
                JSONArray jsonArray = new JSONArray(jsonStr);
                return jsonArray.toString(JSON_INDENT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
