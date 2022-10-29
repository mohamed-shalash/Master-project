package com.example.master_project.Models;

public class Methedology {
    String method;
    String description;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Methedology() {
    }

    public Methedology(String method, String description) {
        this.method = method;
        this.description = description;
    }
}
