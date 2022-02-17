package com.lamonarca.designPattern.observer.observer1;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private final List<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        for (Channel channel : this.channels) {
            channel.update(news);
        }
    }

    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel("TF1");
        NewsChannel observer2 = new NewsChannel("Arte");
        NewsChannel observer3 = new NewsChannel("BFM");

        observable.addObserver(observer);
        observable.addObserver(observer2);
        observable.addObserver(observer3);

        observable.setNews("Nouvelle planete découverte !");
        observable.removeObserver(observer2);
        observable.setNews("Ah non c'était un caillou...");
    }
}