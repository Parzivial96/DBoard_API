package com.magdemy.dboard_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marquee")
public class Marquee {
    @Id
    private String id;

    private String marqueeData;
    private String expiryDate;

    public String getId() {
        return id;
    }

    public String getMarqueeData() {
        return marqueeData;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMarqueeData(String marqueeData) {
        this.marqueeData = marqueeData;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", textData='" + marqueeData + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
