package com.example.istekep;


public class RecyclerViewData
{
    public String title;
    public String desc;
    public int image;

    RecyclerViewData(String title,String desc,int image)
    {
        this.desc=desc;
        this.title=title;
        this.image = image;
    }
    RecyclerViewData(){}

    RecyclerViewData(RecyclerViewData w){
        this.title = w.title;
        this.desc=w.desc;
        this.image = w.image;

    }
}
