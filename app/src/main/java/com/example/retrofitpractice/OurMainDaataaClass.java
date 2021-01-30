package com.example.retrofitpractice;

import java.util.List;

public class OurMainDaataaClass {
    private List<ObjectDataClass> data ;

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }

    public OurMainDaataaClass(List<ObjectDataClass> data) {
        this.data = data;
    }

    public OurMainDaataaClass() {
    }
}
