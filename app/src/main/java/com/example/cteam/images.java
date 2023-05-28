package com.example.cteam;

public class images {


    private String Description,url,price;

    public images() {

    }


    public images(String description, String url, String price) {
        this.Description = description;
        this.url = url;
        this.price=price;
    }




    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
