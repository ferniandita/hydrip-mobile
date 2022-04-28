package com.example.hydrip;

import com.google.gson.annotations.SerializedName;

public class DataMonitoring {
    @SerializedName("id_area")
    private int id_area;
    @SerializedName("date")
    private String date;
    @SerializedName("ph")
    private String ph;
    @SerializedName("light")
    private String light;
    @SerializedName("moist1")
    private Double moist1;
    @SerializedName("moist2")
    private Double moist2;
    @SerializedName("moist3")
    private Double moist3;
    @SerializedName("moist4")
    private Double moist4;
    @SerializedName("suhu")
    private Double suhu;
    @SerializedName("hum")
    private Double hum;
    @SerializedName("airtem")
    private Double airtem;
    @SerializedName("level")
    private Double level;

    public DataMonitoring(int id_area, String date, double moist1, double moist2, double moist3, double moist4, double suhu, double hum, double airtem, double level, String ph, String light) {
        this.id_area = id_area;
        this.date = date;
        this.ph = ph;
        this.light = light;
        this.moist1 = moist1;
        this.moist2 = moist2;
        this.moist3 = moist3;
        this.moist4 = moist4;
        this.suhu = suhu;
        this.hum = hum;
        this.airtem = airtem;
        this.level = level;
    }


    public int getIdarea() { return id_area; }

    public String getDate() { return date; }

    public String getPh() { return ph; }

    public String getLight() { return light; }

    public Double getMoist1() { return moist1; }

    public Double getMoist2() { return moist2; }

    public Double getMoist3() { return moist3; }

    public Double getMoist4() { return moist4; }

    public Double getSuhu() { return suhu; }

    public Double getHum() { return hum; }

    public Double getAirtem() { return airtem; }

    public Double getLevel() { return level; }

//    public void setIdarea(int idarea) { this.idarea = idarea; }
//
//    public void setDate(String date) { this.date = date; }
//
//    public void setPh(String ph) { this.ph = ph; }
//
//    public void setLight(String light) { this.light = light; }
//
//    public void setMoist1(Double moist1) { this.moist1 = moist1; }
//
//    public void setMoist2(Double moist2) { this.moist2 = moist2; }
//
//    public void setMoist3(Double moist3) { this.moist3 = moist3; }
//
//    public void setMoist4(Double moist4) { this.moist4 = moist4; }
//
//    public void setSuhu(Double suhu) { this.suhu = suhu; }
//
//    public void setHum(Double hum) { this.hum = hum; }
//
//    public void setAirtem(Double airtem) { this.airtem = airtem; }
//
//    public void setLevel(Double level) { this.level = level; }


}
