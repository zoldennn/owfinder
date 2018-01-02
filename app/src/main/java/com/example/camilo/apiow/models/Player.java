package com.example.camilo.apiow.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Player {
    private String username;
    private int level;
    private String portrait;
    private int rank;
    private String rank_img;
    @SerializedName("levelFrame")
    private String marco_img;
    @SerializedName("star")
    private String star_img;
    @SerializedName("won")
    private int quickwon;
    @SerializedName("won")
    private int compwon;
    @SerializedName("lost")
    private int complost;
    @SerializedName("draw")
    private int compdraw;
    @SerializedName("played")
    private int compplayed;
    @SerializedName("competitive")
    private String comphs;
    @SerializedName("quickplay")
    private String quickhs;

    public Player(String username, int level, String portrait, int rank, String rank_img, String marco_img, String star_img, int quickwon, int compwon, int complost, int compdraw, int compplayed, String comphs, String quickhs) {
        this.username = username;
        this.level = level;
        this.portrait = portrait;
        this.rank = rank;
        this.rank_img = rank_img;
        this.marco_img = marco_img;
        this.star_img = star_img;
        this.quickwon = quickwon;
        this.compwon = compwon;
        this.complost = complost;
        this.compdraw = compdraw;
        this.compplayed = compplayed;
        this.comphs = comphs;
        this.quickhs = quickhs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRank_img() {
        return rank_img;
    }

    public void setRank_img(String rank_img) {
        this.rank_img = rank_img;
    }

    public String getMarco_img() {
        return marco_img;
    }

    public void setMarco_img(String marco_img) {
        this.marco_img = marco_img;
    }

    public String getStar_img() {
        return star_img;
    }

    public void setStar_img(String star_img) {
        this.star_img = star_img;
    }

    public int getQuickwon() {
        return quickwon;
    }

    public void setQuickwon(int quickwon) {
        this.quickwon = quickwon;
    }

    public int getCompwon() {
        return compwon;
    }

    public void setCompwon(int compwon) {
        this.compwon = compwon;
    }

    public int getComplost() {
        return complost;
    }

    public void setComplost(int complost) {
        this.complost = complost;
    }

    public int getCompdraw() {
        return compdraw;
    }

    public void setCompdraw(int compdraw) {
        this.compdraw = compdraw;
    }

    public int getCompplayed() {
        return compplayed;
    }

    public void setCompplayed(int compplayed) {
        this.compplayed = compplayed;
    }

    public String getComphs() {
        return comphs;
    }

    public void setComphs(String comphs) {
        this.comphs = comphs;
    }

    public String getQuickhs() {
        return quickhs;
    }

    public void setQuickhs(String quickhs) {
        this.quickhs = quickhs;
    }
}
