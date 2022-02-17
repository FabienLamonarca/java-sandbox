package com.lamonarca.designPattern.observer.observer2;

import java.util.Observable;

public class ONewsAgency extends Observable {

    private String news;

    public void setNews(String news) {
        this.news = news;
        this.setChanged();
        this.notifyObservers(this.news);
    }

    public static void main(String[] args) {
        ONewsAgency observable = new ONewsAgency();
        ONewsChannel observer = new ONewsChannel("TF1");
        ONewsChannel observer2 = new ONewsChannel("ARTE");
        ONewsChannel observer3 = new ONewsChannel("BFMTV");

        observable.addObserver(observer);
        observable.addObserver(observer2);
        observable.addObserver(observer3);

        observable.setNews("Covid32 : le variant x");
        observable.deleteObserver(observer2);
        observable.setNews("Covid32 : le variant y");
    }
}