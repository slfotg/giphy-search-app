package com.github.slfotg.giphy.api.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MpaaRating {
    Y("y"),
    G("g"),
    PG("pg"),
    PG_13("pg-13"),
    R("r"),
    UNRATED("unrated"),
    NSFW("nsfw");

    private String code;

    MpaaRating(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    private static final Map<String, MpaaRating> map;

    static {
        map = new HashMap<>();
        map.put("y", Y);
        map.put("g", G);
        map.put("pg", PG);
        map.put("pg-13", PG_13);
        map.put("r", R);
        map.put("unrated", UNRATED);
        map.put("nsfw", NSFW);
    }

    public static MpaaRating fromCode(String code) {
        return map.get(code);
    }

}
