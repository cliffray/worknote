package com.project.worknote;

public class Data {
    private String laction;
    private int TVID;

    public Data(String laction, int TVID){
        this.laction = laction;
        this.TVID = TVID;
    }

    public String getLaction(){
        return laction;
    }

    public int getTVID(){
        return TVID;
    }
}
