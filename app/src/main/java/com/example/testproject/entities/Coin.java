package com.example.testproject.entities;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "coins")
public class Coin {

    @Ignore
    private static final String IMAGE_BASE_URL = "https://www.cryptocompare.com";

    @Ignore
    @SerializedName("ImageUrl")
    private String imageUrl;

    @SerializedName("Name")
    private String name;

    @SerializedName("FullName")
    private String fullName;

    @SerializedName("Algorithm")
    private String algorithm;

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String imageUri;

    private String price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return IMAGE_BASE_URL.concat(imageUrl);
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

    public String getImageUri() {
        return imageUri;
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

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
