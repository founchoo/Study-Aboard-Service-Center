package com.wt6.sasc.entity;

public class Tech {

    private String name;
    private String logo;
    private String uri;

    public Tech(String name, String logo, String uri) {
        this.name = name;
        this.logo = logo;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
}
