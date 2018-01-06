package com.example.aziznaufal.weightcalc_2;

/**
 * Created by Aziz Naufal on 1/6/2018.
 */

public class HealthyArticle {
    private String web_url;
    private String snippet;
    private String[] multimedia = new String[8];

    public HealthyArticle(){

    }
    public HealthyArticle(String _web_url, String _snippet, String[] _multimedia){
        this.web_url = _web_url;
        this.snippet = _snippet;
        this.multimedia = _multimedia;
    }

    public String getWeb_url(){
        return  web_url;
    }

    public void setWebUrl(String url){
        this.web_url = url;
    }

    public String getsnippet(){
        return  snippet;
    }

    public void setsnippet(String snippet){
        this.snippet = snippet;
    }

    public String[] getmultimedia(){
        return  multimedia;
    }

    public void setmultimedia(String[] multimedia){
        this.multimedia = multimedia;
    }
}
