package com.magdemy.dboard_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "event")
public class Event {

    @Id
    private String id;

    private String textData;
    private String expiryDate;

    public String getId() {
        return id;
    }

    public String getTextData() {
        return textData;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", textData='" + textData + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
