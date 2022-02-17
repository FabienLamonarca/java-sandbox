package com.lamonarca.designPattern.observer.observer2;

import java.util.Observable;
import java.util.Observer;

import static com.lamonarca.MyLogger.logger;

public class ONewsChannel implements Observer {

    private final String channelName;
    private String news;

    ONewsChannel(String channelName){
        this.channelName = channelName;
    }

    public void setNews(Object news){
        this.news = (String) news;
    }

    @Override
    public void update(Observable o, Object news) {
        this.setNews(news);
        logger.info("[{}] - Flash news : {}", this.channelName, this.news);
    }
}
