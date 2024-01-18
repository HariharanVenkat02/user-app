package com.example.xpaybackuserapp.Network;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.apache.commons.lang3.StringEscapeUtils;

import java.lang.reflect.Type;

public class HtmlAdapter implements JsonDeserializer<String> {

    @Override
    public String deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context)
            throws JsonParseException {
        return StringEscapeUtils.unescapeHtml4(json.getAsString());
    }

}
