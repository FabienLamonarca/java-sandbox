package com.lamonarca.designPattern.observer.observer1;

import static com.lamonarca.MyLogger.logger;

public class NewsChannel implements Channel {
    private final String channelName;
    private String news;

    NewsChannel(String channelName){
        this.channelName = channelName;
    }

    private void setNews(String news) {
        this.news = news;
    }

    @Override
    public void update(Object news) {
        this.setNews((String) news);
        logger.info("[{}] - Flash news : {}", this.channelName, this.news);
    }
}