package com.codeup.springblog.controllers.models;

public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
