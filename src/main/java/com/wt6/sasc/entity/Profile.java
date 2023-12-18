package com.wt6.sasc.entity;

import java.util.List;

public class Profile {

    private String name;
    private String avatar;
    private String contact;
    private String intro;
    private List<String> does;

    public Profile(String avatar, String name, String contact, String intro, List<String> does) {
        this.name = name;
        this.avatar = avatar;
        this.contact = contact;
        this.intro = intro;
        this.does = does;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<String> getDoes() {
        return does;
    }

    public void setDoes(List<String> does) {
        this.does = does;
    }
}
