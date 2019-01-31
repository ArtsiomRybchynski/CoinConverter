package com.example.testproject.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseObject {

    @SerializedName("Data") private List<DataObject> dataObjects;

    public ResponseObject(List<DataObject> dataObjects) {
        this.dataObjects = dataObjects;
    }

    public List<DataObject> getDataObjects() {
        return dataObjects;
    }
}
