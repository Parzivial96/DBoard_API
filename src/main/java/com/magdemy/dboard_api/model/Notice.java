package com.magdemy.dboard_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notice")
public class Notice {
    @Id
    private String id;

    private String imageData;
    private String expiryDate;

    public String getId() {
        return id;
    }

    public String getImageData() {
        return imageData;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id='" + id + '\'' +
                ", imageData='" + imageData + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
