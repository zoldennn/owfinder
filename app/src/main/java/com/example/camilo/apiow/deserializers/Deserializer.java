package com.example.camilo.apiow.deserializers;

import com.example.camilo.apiow.models.Player;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Deserializer implements JsonDeserializer<Player> {
    @Override
    public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String username = json.getAsJsonObject().get("username").getAsString();
        int level = json.getAsJsonObject().get("level").getAsInt();
        String portrait = json.getAsJsonObject().get("portrait").getAsString();
        int rank = json.getAsJsonObject().get("competitive").getAsJsonObject().get("rank").getAsInt();
        String rank_img = json.getAsJsonObject().get("competitive").getAsJsonObject().get("rank_img").getAsString();
        String marco_img = json.getAsJsonObject().get("levelFrame").getAsString();
        String star_img = json.getAsJsonObject().get("star").getAsString();
        int quickwon = json.getAsJsonObject().get("games").getAsJsonObject().get("quickplay").getAsJsonObject().get("won").getAsInt();
        int compwon = json.getAsJsonObject().get("games").getAsJsonObject().get("competitive").getAsJsonObject().get("won").getAsInt();
        int complost = json.getAsJsonObject().get("games").getAsJsonObject().get("competitive").getAsJsonObject().get("lost").getAsInt();
        int compdraw = json.getAsJsonObject().get("games").getAsJsonObject().get("competitive").getAsJsonObject().get("draw").getAsInt();
        int compplayed = json.getAsJsonObject().get("games").getAsJsonObject().get("competitive").getAsJsonObject().get("played").getAsInt();
        String comphs = json.getAsJsonObject().get("playtime").getAsJsonObject().get("competitive").getAsString();
        String quickhs = json.getAsJsonObject().get("playtime").getAsJsonObject().get("quickplay").getAsString();

        Player player = new Player(username, level, portrait , rank, rank_img, marco_img, star_img, quickwon, compwon, complost, compdraw, compplayed,comphs,quickhs);

        return player;
    }
}
