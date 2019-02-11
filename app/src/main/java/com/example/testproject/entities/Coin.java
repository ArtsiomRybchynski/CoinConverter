package com.example.testproject.entities;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "coins")
public class Coin {

    @Ignore
    public static final String BASE_IMAGE_URL = "https://www.cryptocompare.com";

    private String price;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("ImageUrl")
    private String imageUrl;

    @SerializedName("Name")
    private String name;

    @SerializedName("FullName")
    private String fullName;

    @SerializedName("Algorithm")
    private String algorithm;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getPrice() {
        return price;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}